package com.example.seminariotp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seminariotp.ddl.GameRepository
import com.example.seminariotp.ddl.models.Genre
import com.example.seminariotp.ddl.models.Platform
import com.example.seminariotp.ddl.models.Publisher
import com.example.seminariotp.ddl.models.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    private val gameRepository: GameRepository
) : ViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()
    private val _error = MutableStateFlow(false)
    val error = _error.asStateFlow()
    private val _genres = MutableStateFlow<List<Genre>?>(null)
    val genres = _genres.asStateFlow()
    private val _platforms = MutableStateFlow<List<Platform>?>(null)
    val platforms = _platforms.asStateFlow()
    private val _publishers = MutableStateFlow<List<Publisher>?>(null)
    val publishers = _publishers.asStateFlow()
    private val _stores = MutableStateFlow<List<Store>?>(null)
    val stores = _stores.asStateFlow()

    fun getGenres(qty: Int) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            val genres = gameRepository.getGenres(qty)
            _loading.value = false
            _genres.value = genres
            _error.value = genres == null
        }
    }

    fun getPlatforms(qty: Int) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            val res = gameRepository.getPlatforms(qty)
            _loading.value = false
            _platforms.value = res
            _error.value = res == null
        }
    }

    fun getPublishers(qty: Int) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            val res = gameRepository.getPublishers(qty)
            _loading.value = false
            _publishers.value = res
            _error.value = res == null
        }
    }

    fun getStores(qty: Int) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = false
            val res = gameRepository.getStores(qty)
            _loading.value = false
            _stores.value = res
            _error.value = res == null
        }
    }

}
