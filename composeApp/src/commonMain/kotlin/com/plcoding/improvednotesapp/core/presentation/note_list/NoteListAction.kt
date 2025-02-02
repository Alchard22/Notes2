package com.plcoding.improvednotesapp.core.presentation.note_list

import com.plcoding.improvednotesapp.core.domain.Note

sealed interface NoteListAction {
    data class OnSearchQueryChange(val query: String): NoteListAction
    data class OnNoteClick(val note: Note): NoteListAction
    data class OnTabSelected(val index: Int): NoteListAction
}