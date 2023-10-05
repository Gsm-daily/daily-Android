package com.daily.presentation.view.diary.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.daily.presentation.view.diary.DiaryScreen

const val diaryRoute = "diary_route"

fun NavController.navigateToDiary(date: String) {
    this.navigate("$diaryRoute/$date")
}

fun NavGraphBuilder.diaryScreen() {
    composable("$diaryRoute/{date}") { backStackEntry ->
        DiaryScreen(date = backStackEntry.arguments?.getString("date"))
    }
}
