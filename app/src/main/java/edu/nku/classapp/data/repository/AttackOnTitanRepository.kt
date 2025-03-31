package edu.nku.classapp.data.repository

import edu.nku.classapp.data.model.AttackOnTitanApiResponse

interface AttackOnTitanRepository {
    suspend fun getCharacters() : AttackOnTitanApiResponse
}