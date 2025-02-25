package com.vimal.kinzooandroidchallenge.presentation.screen.character_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vimal.kinzooandroidchallenge.domain.model.Episode
import com.vimal.kinzooandroidchallenge.domain.use_cases.UseCases
import com.vimal.kinzooandroidchallenge.util.Constant.CHARACTER_DETAIL_ARGUMENT_KEY
import com.vimal.kinzooandroidchallenge.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val useCases: UseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _characterDetailState =
        MutableStateFlow<CharacterDetailState>(CharacterDetailState())
    val characterDetailState: StateFlow<CharacterDetailState> get() = _characterDetailState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val characterId = savedStateHandle.get<Int>(CHARACTER_DETAIL_ARGUMENT_KEY)
            characterId?.let {
                getCharacter(characterId = it)
            }
        }
    }

    fun onClickRetry() {
        val characterId = savedStateHandle.get<Int>(CHARACTER_DETAIL_ARGUMENT_KEY)
        _characterDetailState.update { it.copy(isError = false) }
        characterId?.let {
            getCharacter(characterId = it)
        }
    }

    private fun getCharacter(characterId: Int) {

        viewModelScope.launch {
            useCases.getCharacterDetailUseCase(characterId = characterId)
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            _characterDetailState.update { it.copy(isLoading = true) }
                        }

                        is Resource.Success -> {
                            _characterDetailState.update { state -> state.copy(character = it.data) }
                            if (it.data != null) getEpisode(it.data.episode)
                        }

                        is Resource.Error -> {
                            _characterDetailState.update { it.copy(isError = true) }
                        }
                    }
                }
        }
    }

    private fun getEpisode(episodes: List<String>) {
        _characterDetailState.update { it.copy(isLoading = true) }

        viewModelScope.launch(Dispatchers.IO) {
            val list: MutableList<Episode> = mutableListOf()

            episodes.forEach { episodeUrl ->
                val episodeId = (episodeUrl.split("/"))[5]
                val episode = useCases.getEpisodeUseCase(episodeId = episodeId.toInt())
                list.add(episode)
            }
            _characterDetailState.update { it.copy(isLoading = false, episodes = list) }
        }
    }
}