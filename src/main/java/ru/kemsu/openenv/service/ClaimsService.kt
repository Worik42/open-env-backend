package ru.kemsu.openenv.service

import ru.kemsu.openenv.dto.ClaimDTO
import ru.kemsu.openenv.dto.UserStatusDTO
import ru.kemsu.openenv.model.Claim

interface ClaimsService {
    fun createClaimOrAddUserToClaim(dto: ClaimDTO, userId: String)

    fun updateUserStatus(dto: UserStatusDTO)

    fun findAllClaimByIdService(idService: String): List<Claim>
}