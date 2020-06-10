package ru.kemsu.openenv.service

import ru.kemsu.openenv.model.Support

/**
 * @startuml
 * interface ISupportService {
 *  fun createSupport(support: Support): Support
 * }
 * @enduml
 */
interface ISupportService {
    fun createSupport(support: Support): Support
}