package gabor.koleszar.recipeapp.domain.model

data class Recipe(
    val cookingInstructions: String,
    val dateAdded: String,
    val dateUpdated: String,
    val description: String,
    val featuredImage: String,
    val ingredients: List<String>,
    val longDateAdded: Int,
    val longDateUpdated: Int,
    val primaryKey: Int,
    val publisher: String,
    val rating: Int,
    val sourceUrl: String,
    val title: String
)
