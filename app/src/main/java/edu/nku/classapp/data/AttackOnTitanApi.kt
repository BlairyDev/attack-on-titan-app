package edu.nku.classapp.data

import edu.nku.classapp.model.AttackOnTitanCharacterResponse
import edu.nku.classapp.model.AttackOnTitanDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AttackOnTitanApi {
    @GET("/characters")
    suspend fun getCharacters(): Response<AttackOnTitanCharacterResponse>

    @GET("/characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<AttackOnTitanDetailResponse>
}