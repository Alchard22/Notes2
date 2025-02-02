package com.plcoding.improvednotesapp.core.presentation.note_list

import com.plcoding.improvednotesapp.core.domain.Note
import com.plcoding.improvednotesapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Note> = emptyList(), //TODO Change
    val favoriteBooks: List<Note> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)