package edu.nku.classapp.data.model

import edu.nku.classapp.model.AttackOnTitanDetailResponse


sealed class AttackOnTitanDetailApiResponse {

    data class Success(val character: AttackOnTitanDetailResponse): AttackOnTitanDetailApiResponse()
    data object Error : AttackOnTitanDetailApiResponse()

}