package io.github.bozorgzadai.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.bozorgzadai.bookshelf.R
import io.github.bozorgzadai.bookshelf.ui.screens.BookViewModel
import io.github.bozorgzadai.bookshelf.ui.screens.HomeScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { BookTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val bookViewModel: BookViewModel =
                viewModel(factory = BookViewModel.Factory)
            HomeScreen(
                bookUiState = bookViewModel.bookUiState,
                retryAction = bookViewModel::getBooks,
                contentPadding = it
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF9B4425)
        ),
        modifier = modifier
    )
}
