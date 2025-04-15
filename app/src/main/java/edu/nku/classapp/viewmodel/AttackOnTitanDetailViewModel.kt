package edu.nku.classapp.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.data.model.AttackOnTitanApiResponse
import edu.nku.classapp.data.model.AttackOnTitanDetailApiResponse
import edu.nku.classapp.data.repository.AttackOnTitanRepository
import edu.nku.classapp.model.AttackOnTitanCharacterResponse
import edu.nku.classapp.model.AttackOnTitanDetailResponse
import edu.nku.classapp.viewmodel.AttackOnTitanCharacterViewModel.AttackOnTitanCharacterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AttackOnTitanDetailViewModel @Inject constructor(
    private val attackOnTitanRepository: AttackOnTitanRepository
): ViewModel() {

    private val _character = MutableStateFlow<AttackOnTitanDetailState>(AttackOnTitanDetailState.Loading)
    val character: StateFlow<AttackOnTitanDetailState> = _character.asStateFlow()

    fun fetchById(id: Int) = viewModelScope.launch {

        when(val response = attackOnTitanRepository.getCharactersById(id)) {
            AttackOnTitanDetailApiResponse.Error -> _character.value = AttackOnTitanDetailState.Failure
            is AttackOnTitanDetailApiResponse.Success -> _character.value = AttackOnTitanDetailState.Success(response.character)
        }
    }



    sealed class AttackOnTitanDetailState {
        data class Success(val character: AttackOnTitanDetailResponse): AttackOnTitanDetailState()
        data object Failure : AttackOnTitanDetailState()
        data object Loading : AttackOnTitanDetailState()
    }


}