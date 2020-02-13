package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.stereotype.Service
import ru.kemsu.openenv.exception.model.UserAlreadyCreatedException
import ru.kemsu.openenv.model.Authority
import ru.kemsu.openenv.model.User
import ru.kemsu.openenv.repository.UserRepository
import java.time.LocalDateTime
import java.util.*

@Service
class BasicUserService @Autowired constructor(private val repository: UserRepository) : UserService {

//    @Bean
//    fun encoder(): Pbkdf2PasswordEncoder {
//        return Pbkdf2PasswordEncoder()
//    }

    override fun create(user: User): User {
        val encoder = Pbkdf2PasswordEncoder()
        val _user = repository.findByUsername(user.username)
        return if (_user != null) {
            throw UserAlreadyCreatedException("Пользователь уже существует")
        } else {
            user.createdAt = LocalDateTime.now().toString()
            user.password = encoder.encode(user.password)
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

}
