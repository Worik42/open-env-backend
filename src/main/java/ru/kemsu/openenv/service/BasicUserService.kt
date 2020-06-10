package ru.kemsu.openenv.service

import org.passay.AllowedCharacterRule.ERROR_CODE
import org.passay.CharacterData
import org.passay.CharacterRule
import org.passay.EnglishCharacterData
import org.passay.PasswordGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.kemsu.openenv.dto.UserChangeDTO
import ru.kemsu.openenv.exception.model.UserAlreadyCreatedException
import ru.kemsu.openenv.model.Authority
import ru.kemsu.openenv.model.User
import ru.kemsu.openenv.repository.UserRepository
import java.time.LocalDateTime
import java.util.*

/**
 * @startuml
 * class BasicUserService implements UserService, UserDetailsService {
 *  - val repository: UserRepository
 *   fun encoder(): BCryptPasswordEncoder
 *   fun create(user: User): User
 *   fun find(id: String): User
 *   fun findByUsername(userName: String): User
 *   fun findAll(): List<User>
 *       fun update(id: String, user: User): User
 *       fun resetPassword(username: String): String?
 *      fun delete(id: String): String
 *      fun updateUser(name: String, userChange: UserChangeDTO): Boolean
 * fun loadUserByUsername(username: String?): UserDetails
 * fun generatePassayPassword(): String
 * }
 * @enduml
 */

@Service
class BasicUserService @Autowired constructor(private val repository: UserRepository) : UserService, UserDetailsService {

    @Autowired
    fun encoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun create(user: User): User {
        val _user = repository.findByUsername(user.username)
        return if (_user != null) {
            throw UserAlreadyCreatedException("Пользователь уже существует")
        } else {
            user.createdAt = LocalDateTime.now().toString()
            user.password = encoder().encode(user.password)
            repository.save(user)
        }
    }

    override fun find(id: String): User {
        return repository.findById(id).get()
    }

    override fun findByUsername(userName: String): User {
        return repository.findByUsername(userName)
    }

    override fun findAll(): List<User> {
        return repository.findAll()
    }

    override fun update(id: String, user: User): User {
        user.id = id
        val saved = repository.findById(id).get()
        user.createdAt = saved.createdAt
        user.updatedAt = LocalDateTime.now().toString()
        repository.save(user)
        return user
    }

    override fun resetPassword(username: String): String? {
        val user = findByUsername(username)
        if (user != null) {
            val user_ = user
            val newPass = generatePassayPassword()
            user_.password = encoder().encode(newPass)
            repository.save(user_)
            return newPass
        }
        return null
    }

    override fun delete(id: String): String {
        repository.deleteById(id)
        return id
    }

    override fun changeRole(name: String, isAdmin: Boolean): User? {
        val user = repository.findByUsername(name)
        return if (user != null) {
            val authorities: MutableList<Authority> = ArrayList()
            if (isAdmin) authorities.add(Authority.ROLE_ADMIN) else authorities.add(Authority.ROLE_USER)
            user.setAuthorities(authorities)
            repository.save(user)
            user
        } else {
            null
        }
    }

    override fun updateUser(name: String, userChange: UserChangeDTO): Boolean {
        val user = repository.findByUsername(name)
        if (user != null) {
            val user_ = user
            user_.about = userChange.about
            user_.email = userChange.email
            user.diagnosis = userChange.diagnosis
            repository.save(user_)
            return true
        }
        return false
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val dbUser: User = repository.findByUsername(username)

        return if (dbUser != null) {
            val grantedAuthorities: MutableCollection<GrantedAuthority> = ArrayList()
            for (role in dbUser.authorities) {
                val authority: GrantedAuthority = SimpleGrantedAuthority(role.authority)
                grantedAuthorities.add(authority)
            }
            org.springframework.security.core.userdetails.User(
                    dbUser.username, dbUser.password, grantedAuthorities)
        } else {
            throw UsernameNotFoundException(String.format("User '%s' not found", username))
        }
    }

    fun generatePassayPassword(): String {
        val gen = PasswordGenerator()
        val lowerCaseChars: CharacterData = EnglishCharacterData.LowerCase
        val lowerCaseRule = CharacterRule(lowerCaseChars)
        lowerCaseRule.numberOfCharacters = 2
        val upperCaseChars: CharacterData = EnglishCharacterData.UpperCase
        val upperCaseRule = CharacterRule(upperCaseChars)
        upperCaseRule.numberOfCharacters = 2
        val digitChars: CharacterData = EnglishCharacterData.Digit
        val digitRule = CharacterRule(digitChars)
        digitRule.numberOfCharacters = 2
        val specialChars: CharacterData = object : CharacterData {

            override fun getErrorCode(): String {
                return ERROR_CODE
            }

            override fun getCharacters(): String {
                return "!@#$%^&*()_+"
            }
        }
        val splCharRule = CharacterRule(specialChars)
        splCharRule.numberOfCharacters = 2
        return gen.generatePassword(10, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule)
    }
}
