package com.plcoding.improvednotesapp.core.domain

data class Note(
    val id: String,
    val title: String,
    val description: String?,
    val data: String?,
    val createdOn: String, //TODO Convert to date time
    val modifiedOn: String? // TODO Convert to date time
)