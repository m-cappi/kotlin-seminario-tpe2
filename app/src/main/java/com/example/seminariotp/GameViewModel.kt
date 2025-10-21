package com.example.seminariotp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seminariotp.ddl.GameRepository
import com.example.seminariotp.ddl.models.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject  constructor(
    private val gameRepository: GameRepository
): ViewModel(){
    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()
    private val _error = MutableStateFlow(false)
    val error = _error.asStateFlow()
    private val _games = MutableStateFlow<List<Game>?>(null)
    val games = _games.asStateFlow()

    fun getGames(qty: Int){
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            val games = gameRepository.getGames(qty)
            _loading.value = false
            _games.value = games
            _error.value = games == null
        }
    }

}