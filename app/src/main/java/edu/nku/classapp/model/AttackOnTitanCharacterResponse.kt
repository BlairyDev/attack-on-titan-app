package edu.nku.classapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttackOnTitanCharacterResponse(
    //@Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val characters: List<Character>
) {
    @JsonClass(generateAdapter = true)
    data class Info(
        @Json(name = "count")
        val count: Int,
        @Json(name = "next_page")
        val nextPage: String,
        @Json(name = "pages")
        val pages: Int,
        @Json(name = "prev_page")
        val prevPage: Any?
    )

    @JsonClass(generateAdapter = true)
    data class Character(
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
        val groups: List<Group>,
        @Json(name = "height")
        val height: String,
        @Json(name = "id")
        val id: Int,
        @Json(name = "img")
        val img: String?,
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
        data class Group(
            @Json(name = "name")
            val name: String,
            @Json(name = "sub_groups")
            val subGroups: List<String>
        )

        @JsonClass(generateAdapter = true)
        data class Relative(
            @Json(name = "family")
            val family: String,
            @Json(name = "members")
            val members: List<String>
        )
    }
}