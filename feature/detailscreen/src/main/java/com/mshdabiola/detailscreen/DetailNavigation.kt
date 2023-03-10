package com.mshdabiola.detailscreen


import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mshdabiola.ui.data.TrackUiState

const val detailRoute = "detail_route"
const val detail_id = "detail_id"
const val detail_type = "detail_type"

internal class DetailArg(val id: String, val type: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        checkNotNull(savedStateHandle[detail_id]),
        checkNotNull(savedStateHandle[detail_type])
    )
}

fun NavGraphBuilder.detailScreen(
    onBack: () -> Unit,
    onMediaItems: (List<TrackUiState>) -> Unit = {}
) {
    composable(
        route = "$detailRoute/{$detail_id}/{$detail_type}"
    ) {
        DetailScreen(
            onBack = onBack,
            onMediaItems = onMediaItems
        )
    }
}

fun NavController.navigateToDetail(id: String, type: String) {
    navigate(route = "$detailRoute/$id/$type")

}
