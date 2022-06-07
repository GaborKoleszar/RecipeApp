package gabor.koleszar.recipeapp.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import gabor.koleszar.recipeapp.domain.model.RecipeListPage

@JsonClass(generateAdapter = true)
data class RecipeListDto(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String?,
    @Json(name = "previous")
    val previous: String?,
    @Json(name = "results")
    val results: List<RecipeDto>
) {
    fun toRecipeListPage(): RecipeListPage {
        return RecipeListPage(
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toRecipe() }
        )
    }
}