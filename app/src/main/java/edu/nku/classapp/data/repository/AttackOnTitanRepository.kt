package edu.nku.classapp.data.repository

import edu.nku.classapp.data.model.AttackOnTitanApiResponse
import edu.nku.classapp.data.model.AttackOnTitanDetailApiResponse
import edu.nku.classapp.model.AttackOnTitanDetailResponse

interface AttackOnTitanRepository {
    suspend fun getCharacters() : AttackOnTitanApiResponse
    suspend fun getCharactersById(id: Int): AttackOnTitanDetailApiResponse
}