package edu.nku.classapp.viewmodel

import android.R.attr.description
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.data.model.AttackOnTitanApiResponse
import edu.nku.classapp.data.repository.AttackOnTitanRepository
import edu.nku.classapp.model.AttackOnTitanCharacterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class AttackOnTitanCharacterViewModel @Inject constructor(
    private val attackOnTitanRepository: AttackOnTitanRepository
): ViewModel() {

    private val _characters = MutableStateFlow<AttackOnTitanCharacterState>(AttackOnTitanCharacterState.Loading)
    val characters: StateFlow<AttackOnTitanCharacterState> = _characters.asStateFlow()

    fun fillData() = viewModelScope.launch {
        when (val response = attackOnTitanRepository.getCharacters()) {
            AttackOnTitanApiResponse.Error -> _characters.value = AttackOnTitanCharacterState.Failure
            is AttackOnTitanApiResponse.Success -> _characters.value = AttackOnTitanCharacterState.Success(response.characters)
        }
    }



    sealed class AttackOnTitanCharacterState {
        data class Success(val characters: List<AttackOnTitanCharacterResponse.Character>): AttackOnTitanCharacterState()
        data object Failure : AttackOnTitanCharacterState()
        data object Loading : AttackOnTitanCharacterState()
    }


}

