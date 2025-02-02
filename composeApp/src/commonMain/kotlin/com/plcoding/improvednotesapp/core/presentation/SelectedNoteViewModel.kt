package com.plcoding.improvednotesapp.core.presentation

import androidx.lifecycle.ViewModel
import com.plcoding.improvednotesapp.core.domain.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedNoteViewModel: ViewModel() {

    private val _selectedNote = MutableStateFlow<Note?>(null)
    val selectedNote = _selectedNote.asStateFlow()

    fun onSelectNote(note: Note?) {
        _selectedNote.value = note
    }
}