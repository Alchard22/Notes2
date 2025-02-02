package com.plcoding.improvednotesapp.note.domain

import com.plcoding.improvednotesapp.core.domain.DataError
import com.plcoding.improvednotesapp.core.domain.DataError.Remote
import com.plcoding.improvednotesapp.core.domain.EmptyResult
import com.plcoding.improvednotesapp.core.domain.Note
import com.plcoding.improvednotesapp.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface NoteRepository{
    suspend fun searchBooks(query: String): Result<List<Note>, Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Note>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(note: Note): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)
}