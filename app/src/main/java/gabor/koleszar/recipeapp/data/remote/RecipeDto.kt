package gabor.koleszar.recipeapp.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import gabor.koleszar.recipeapp.domain.model.Recipe

@JsonClass(generateAdapter = true)
data class RecipeDto(
    @Json(name = "cooking_instructions")
    val cookingInstructions: String?,
    @Json(name = "date_added")
    val dateAdded: String,
    @Json(name = "date_updated")
    val dateUpdated: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "featured_image")
    val featuredImage: String,
    @Json(name = "ingredients")
    val ingredients: List<String>,
    @Json(name = "long_date_added")
    val longDateAdded: Int,
    @Json(name = "long_date_updated")
    val longDateUpdated: Int,
    @Json(name = "pk")
    val pk: Int,
    @Json(name = "publisher")
    val publisher: String,
    @Json(name = "rating")
    val rating: Int,
    @Json(name = "source_url")
    val sourceUrl: String,
    @Json(name = "title")
    val title: String
) {
    fun toRecipe(): Recipe {
        return Recipe(
            cookingInstructions = cookingInstructions ?: "",
            dateAdded = dateAdded,
            dateUpdated = dateUpdated,
            description = description,
            featuredImage = featuredImage,
            ingredients = ingredients,
            longDateAdded = longDateAdded,
            longDateUpdated = longDateUpdated,
            primaryKey = pk,
            publisher = publisher,
            rating = rating,
            sourceUrl = sourceUrl,
            title = title
        )
    }
}