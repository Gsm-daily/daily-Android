package com.daily.presentation.view.diary.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.daily.presentation.view.diary.DiaryScreen

const val diaryRoute = "diary_route"

fun NavController.navigateToDiary(isEditable: Boolean) {
    this.navigate("$diaryRoute/$isEditable")
}

fun NavGraphBuilder.diaryScreen() {
    composable(
        route = "$diaryRoute/{isEditable}",
        arguments = listOf(navArgument("isEditable") {
            type = NavType.BoolType
            defaultValue = false
        })
    ) { backStackEntry ->
        DiaryScreen(isEditable = backStackEntry.arguments?.getBoolean("isEditable") ?: false)
    }
}