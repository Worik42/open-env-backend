package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.model.Support
import ru.kemsu.openenv.repository.ISupportRepository
import java.time.LocalDateTime

@Service
class BasicSupportService @Autowired constructor(private val repository: ISupportRepository) : ISupportService {
    override fun createSupport(support: Support): Support {
        support.createdAt = LocalDateTime.now().toString()
        repository.save(support)
        return support
    }

}