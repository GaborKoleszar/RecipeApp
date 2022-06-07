package gabor.koleszar.recipeapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import gabor.koleszar.recipeapp.presentation.ScreenRoutes

@Composable
fun RecipeListScreen(navController: NavController) {
    Column {
        Text(text = "Main List Screen")
        Button(onClick = { navController.navigate(ScreenRoutes.RecipeDetails.withArgs("Spagetti")) }) {
            Text(text = "Navigate to Details")
        }
    }
}