package ru.kemsu.openenv.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.model.Claim
import ru.kemsu.openenv.repository.ClaimRepository

@Service
class BasicClaimService @Autowired constructor(private val repository: ClaimRepository) : ClaimService {
    override fun createClaim(claim: ClaimDTO, userID: String) {
        val claim = Claim(userID, claim.idService, claim.time, 0, claim.description)
        repository.save(claim)
    }

    override fun getClaimsByIdService(idService: String): List<Claim> {
        return repository.findByServiceID(idService)
    }

    override fun getClaimsByIdUser(idUser: String): List<Claim> {
        return repository.findByUserID(idUser)
    }

    override fun changeStatusClaim(status: Int, idClaim: String) {
        val claim: Claim = repository.findById(idClaim).get()
        claim.status = status
        repository.save(claim)
    }
}