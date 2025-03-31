package edu.nku.classapp.data.repository

import android.util.Log
import edu.nku.classapp.data.AttackOnTitanApi
import edu.nku.classapp.data.model.AttackOnTitanApiResponse
import javax.inject.Inject

class AttackOnTitanRepositoryReal @Inject constructor(
    private val attackOnTitanApi: AttackOnTitanApi
) : AttackOnTitanRepository {

    override suspend fun getCharacters(): AttackOnTitanApiResponse {
        val result = attackOnTitanApi.getCharacters()
        return if (result.isSuccessful) {
            AttackOnTitanApiResponse.Success(result.body()?.characters ?: emptyList())

        } else {
            AttackOnTitanApiResponse.Error
        }
    }
}