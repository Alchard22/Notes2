package com.plcoding.improvednotesapp

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.plcoding.improvednotesapp.core.presentation.SelectedNoteViewModel
import com.plcoding.improvednotesapp.core.presentation.note_list.NoteListScreenRoot
import com.plcoding.improvednotesapp.core.presentation.note_list.NoteListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.NoteGraph
        ) {
            navigation<Route.NoteGraph>(
                startDestination = Route.NoteList
            ) {
                composable<Route.NoteList>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    val viewModel = koinViewModel<NoteListViewModel>()
                    val selectedNoteViewModel =
                        it.sharedKoinViewModel<SelectedNoteViewModel>(navController)

                    LaunchedEffect(true) {
                        selectedNoteViewModel.onSelectBook(null)
                    }

                    NoteListScreenRoot(
                        viewModel = viewModel,
                        onBookClick = { note ->
                            selectedBookViewModel.onSelectBook(note)
                            navController.navigate(
                                Route.NoteDetail(note.id) // Note ID
                            )
                        }
                    )
                }
                composable<Route.NoteDetail>(
                    enterTransition = { slideInHorizontally { initialOffset ->
                        initialOffset
                    } },
                    exitTransition = { slideOutHorizontally { initialOffset ->
                        initialOffset
                    } }
                ) {
                    val selectedBookViewModel =
                        it.sharedKoinViewModel<SelectedBookViewModel>(navController)
                    val viewModel = koinViewModel<BookDetailViewModel>()
                    val selectedBook by selectedBookViewModel.selectedBook.collectAsStateWithLifecycle()

                    LaunchedEffect(selectedBook) {
                        selectedBook?.let {
                            viewModel.onAction(BookDetailAction.OnSelectedBookChange(it))
                        }
                    }

                    NoteDetailScreenRoot(
                        viewModel = viewModel,
                        onBackClick = {
                            navController.navigateUp()
                        }
                    )
                }
            }
        }

    }
}