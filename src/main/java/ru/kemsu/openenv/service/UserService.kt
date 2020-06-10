package ru.kemsu.openenv.service

import ru.kemsu.openenv.dto.UserChangeDTO
import ru.kemsu.openenv.model.User

/**
 * @startuml
 * interface UserService {
 * fun create(user: User): User
 * fun find(id: String): User
 * fun findByUsername(userName: String): User
 * fun findAll(): List<User>
 *     fun update(id: String, user: User): User
fun delete(id: String): String
fun changeRole(name: String, isAdmin: Boolean): User
fun resetPassword(username: String): String
fun updateUser(name: String, userChange: UserChangeDTO): Boolean

 * }
 * @enduml
 */
interface UserService {
    fun create(user: User): User
    fun find(id: String): User
    fun findByUsername(userName: String): User
    fun findAll(): List<User>
    fun update(id: String, user: User): User
    fun delete(id: String): String
    fun changeRole(name: String, isAdmin: Boolean): User?
    fun resetPassword(username: String): String?
    fun updateUser(name: String, userChange: UserChangeDTO): Boolean
}