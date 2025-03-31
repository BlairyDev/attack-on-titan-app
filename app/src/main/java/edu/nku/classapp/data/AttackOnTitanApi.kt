package edu.nku.classapp.data

import edu.nku.classapp.model.AttackOnTitanCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface AttackOnTitanApi {
    @GET("/characters")
    suspend fun getCharacters(): Response<AttackOnTitanCharacterResponse>
}