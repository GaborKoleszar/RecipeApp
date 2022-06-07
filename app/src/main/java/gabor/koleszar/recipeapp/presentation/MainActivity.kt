package gabor.koleszar.recipeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import gabor.koleszar.recipeapp.presentation.ScreenRoutes.Companion.NAVARG_RECIPE_NAME
import gabor.koleszar.recipeapp.presentation.screen.RecipeDetailsScreen
import gabor.koleszar.recipeapp.presentation.screen.RecipeListScreen
import gabor.koleszar.recipeapp.presentation.theme.RecipeAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.RecipeList.route) {
        composable(route = ScreenRoutes.RecipeList.route) {
            RecipeListScreen(navController = navController)
        }
        composable(
            route = ScreenRoutes.RecipeDetails.withArgs(NAVARG_RECIPE_NAME),
            arguments = listOf(
                navArgument(name = NAVARG_RECIPE_NAME) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            RecipeDetailsScreen(recipeName = entry.arguments?.getString(NAVARG_RECIPE_NAME))
        }
    }
}