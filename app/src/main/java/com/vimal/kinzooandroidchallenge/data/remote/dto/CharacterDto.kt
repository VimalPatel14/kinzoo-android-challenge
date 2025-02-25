package com.vimal.kinzooandroidchallenge.data.remote.dto

import com.vimal.kinzooandroidchallenge.domain.model.Character
import com.vimal.kinzooandroidchallenge.domain.model.CharacterDetail

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: CharacterLocation,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

data class Origin(
    val name: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String,
)

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        image = image,
        species = species,
        gender = gender
    )
}

fun List<CharacterDto>.toCharacter(): List<Character> {
    return map {
        Character(
            id = it.id,
            name = it.name,
            status = it.status,
            image = it.image,
            species = it.species,
            gender = it.gender
        )
    }
}

fun CharacterDto.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        id = id,
        name = name,
        status = status,
        image = image,
        species = species,
        type = type,
        gender = gender,
        origin = origin,
        location = location,
        episode = episode
    )
}