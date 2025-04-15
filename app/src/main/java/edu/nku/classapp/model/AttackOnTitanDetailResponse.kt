package edu.nku.classapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttackOnTitanDetailResponse(
    @Json(name = "age")
    val age: String,
    @Json(name = "alias")
    val alias: List<String>,
    @Json(name = "birthplace")
    val birthplace: String,
    @Json(name = "episodes")
    val episodes: List<String>,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "groups")
    val groups: List<Any?>,
    @Json(name = "height")
    val height: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "img")
    val img: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "occupation")
    val occupation: String,
    @Json(name = "relatives")
    val relatives: List<Relative>,
    @Json(name = "residence")
    val residence: String,
    @Json(name = "roles")
    val roles: List<String>,
    @Json(name = "species")
    val species: List<String>,
    @Json(name = "status")
    val status: String
) {
    @JsonClass(generateAdapter = true)
    data class Relative(
        @Json(name = "family")
        val family: String,
        @Json(name = "members")
        val members: List<String>
    )
}