package edu.nku.classapp.data.model

import edu.nku.classapp.model.AttackOnTitanCharacterResponse

sealed class AttackOnTitanApiResponse {
    data class Success(val characters: List<AttackOnTitanCharacterResponse.Character>): AttackOnTitanApiResponse()
    data object Error : AttackOnTitanApiResponse()
}