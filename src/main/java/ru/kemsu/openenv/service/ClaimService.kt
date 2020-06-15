package ru.kemsu.openenv.service

import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.model.Claim

interface ClaimService {
    fun createClaim(claim: ClaimDTO, userID: String)
    fun getClaimsByIdService(idService: String): List<Claim>
    fun getClaimsByIdUser(idUser: String): List<Claim>
    fun changeStatusClaim(status: Int, idClaim: String)
}