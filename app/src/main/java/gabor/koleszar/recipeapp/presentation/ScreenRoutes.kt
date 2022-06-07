package gabor.koleszar.recipeapp.presentation

sealed class ScreenRoutes(val route: String) {
    object RecipeList : ScreenRoutes("recipe_list_screen")
    object RecipeDetails : ScreenRoutes("recipe_details_screen")

    companion object {
        const val NAVARG_RECIPE_NAME = "recipeName"
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
