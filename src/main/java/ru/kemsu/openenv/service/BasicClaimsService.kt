package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.dto.UserStatusDTO
import ru.kemsu.openenv.model.Claim
import ru.kemsu.openenv.model.UserClaim
import ru.kemsu.openenv.repository.ClaimsRepository

@Service
class BasicClaimsService @Autowired constructor(private val repository: ClaimsRepository) : ClaimsService {
    override fun createClaimOrAddUserToClaim(dto: ClaimDTO, userId: String) {
        val result = repository.findByIdService(dto.idService)
        if (result.isEmpty()) {
            val user = UserClaim(userId, status = 0)
            val claim = Claim(listOf(user), dto.idService, dto.timeStart)
            repository.save(claim)
        } else {
            for (item in result) {
                val user = UserClaim(userId, status = 0)
                if (item.date === dto.timeStart) {
                    item.userIDs.plus(user)
                }
            }
        }
    }

    override fun updateUserStatus(dto: UserStatusDTO) {
        val result = repository.findById(dto.idClaim).get()
        if (result != null) {
            val result_ = result
            for (item in result_.userIDs) {
                if (item.idUser == dto.userId) {
                    item.status = dto.status
                }
            }
            repository.save(result_)
        }
    }

    override fun findAllClaimByIdService(idService: String): List<Claim> {
        return repository.findByIdService(idService)
    }


}