package com.plcoding.improvednotesapp

import kotlinx.serialization.Serializable

sealed interface Route {

    data object NoteGraph: Route

    @Serializable
    data object NoteList: Route

    @Serializable
    data class NoteDetail(val id: String): Route
}
