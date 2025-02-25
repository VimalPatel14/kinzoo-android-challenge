package com.vimal.kinzooandroidchallenge.presentation.screen.character_detail

import com.vimal.kinzooandroidchallenge.domain.model.CharacterDetail
import com.vimal.kinzooandroidchallenge.domain.model.Episode

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val isError: Boolean = false,
    val episodes: List<Episode> = emptyList()
)