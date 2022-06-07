package gabor.koleszar.recipeapp.domain.model

data class RecipeListPage(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Recipe>
)
