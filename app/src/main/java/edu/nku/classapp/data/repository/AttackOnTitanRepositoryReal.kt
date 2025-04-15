package edu.nku.classapp.data.repository

import android.util.Log
import edu.nku.classapp.data.AttackOnTitanApi
import edu.nku.classapp.data.model.AttackOnTitanApiResponse
import edu.nku.classapp.data.model.AttackOnTitanDetailApiResponse
import edu.nku.classapp.model.AttackOnTitanDetailResponse
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

    override suspend fun getCharactersById(id: Int): AttackOnTitanDetailApiResponse {
        val result = attackOnTitanApi.getCharacterById(id)

        return if (result.isSuccessful) {
            Log.i("TAG", result.body().toString())
            AttackOnTitanDetailApiResponse.Success(result.body()!!)
        } else {
            AttackOnTitanDetailApiResponse.Error
        }
    }
}