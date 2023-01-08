package com.example.a7monthlesson1.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7monthlesson1.domain.model.Note
import com.example.a7monthlesson1.domain.usecase.GetAllNotesUseCase
import com.example.a7monthlesson1.domain.utils.Resource
import com.example.a7monthlesson1.presentation.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect {
                when (it) {
                    is Resource.Loading -> {
                        _getAllNotesState.value = UIState.Loading()
                    }
                    is Resource.Error -> {
                        _getAllNotesState.value = UIState.Error(it.message!!)
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getAllNotesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}