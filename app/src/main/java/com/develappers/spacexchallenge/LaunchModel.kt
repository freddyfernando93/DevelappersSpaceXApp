package com.develappers.spacexchallenge

data class LaunchModel (
    val flight_number: Int? = null,
    val mission_name: String? = null,
    val rocket: RocketModel? = null,
    val details: String? = null,
    )

data class RocketModel (
    val rocket_id: String? = null,
    val rocket_name: String? = null,
    val rocket_type: String? = null,
)