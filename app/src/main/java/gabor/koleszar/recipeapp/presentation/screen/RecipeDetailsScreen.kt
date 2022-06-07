package gabor.koleszar.recipeapp.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetailsScreen(recipeName: String?) {
    Text(text = "Details Screen $recipeName")
}