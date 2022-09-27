package com.example.kmmapplication.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailResult(
    @SerialName("adult")
    var adult: Boolean?,
    @SerialName("backdrop_path")
    var backdropPath: String?,
    @SerialName("belongs_to_collection")
    var belongsToCollection: BelongsToCollection?,
    @SerialName("budget")
    var budget: Double?,
    @SerialName("genres")
    var genres: MutableList<Genres>?,
    @SerialName("homepage")
    var homepage: String?,
    @SerialName("id")
    var id: Long?,
    @SerialName("imdb_id")
    var imdbId: String?,
    @SerialName("original_language")
    var originalLanguage: String?,
    @SerialName("original_title")
    var originalTitle: String?,
    @SerialName("overview")
    var overview: String?,
    @SerialName("popularity")
    var popularity: Double?,
    @SerialName("poster_path")
    var posterPath: String?,
    @SerialName("production_companies")
    var productionCompanies: MutableList<ProductionCompanies>?,
    @SerialName("production_countries")
    var productionCountries: MutableList<ProductionCountries>?,
    @SerialName("release_date")
    var releaseDate: String?,
    @SerialName("revenue")
    var revenue: Double?,
    @SerialName("runtime")
    var runtime: Long?,
    @SerialName("spoken_languages")
    var spokenLanguages: MutableList<SpokenLanguages>?,
    @SerialName("status")
    var status: String?,
    @SerialName("tagline")
    var tagline: String?,
    @SerialName("title")
    var title: String?,
    @SerialName("video")
    var video: Boolean?,
    @SerialName("vote_average")
    var voteAverage: Double?,
    @SerialName("vote_count")
    var voteCount: Long?
)

@Serializable
data class BelongsToCollection(
    @SerialName("id")
    var id: Long?,
    @SerialName("name")
    var name: String?,
    @SerialName("poster_path")
    var posterPath: String?,
    @SerialName("backdrop_path")
    var backdropPath: String?
)

@Serializable
data class Genres(
    @SerialName("id")
    var id: Long?,
    @SerialName("name")
    var name: String?
)

@Serializable
data class ProductionCompanies(
    @SerialName("id")
    var id: Long?,
    @SerialName("logo_path")
    var logoPath: String?,
    @SerialName("name")
    var name: String?,
    @SerialName("origin_country")
    var originCountry: String?
)

@Serializable
data class ProductionCountries(
    @SerialName("iso_3166_1")
    var iso31661: String?,
    @SerialName("name")
    var name: String?
)

@Serializable
data class SpokenLanguages(
    @SerialName("english_name")
    var englishName: String?,
    @SerialName("iso_639_1")
    var iso6391: String?,
    @SerialName("name")
    var name: String?
)