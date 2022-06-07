package gabor.koleszar.recipeapp.data

import gabor.koleszar.recipeapp.data.remote.RecipeListDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeApi {

    @GET(SEARCH_URL)
    suspend fun getRecipeListPage(
        @Header("Authorization") auth_token: String = AUTH_TOKEN,
        @Query("page") page: Int = 1,
        @Query("query") query: String
    ): RecipeListDto

    companion object {
        const val BASE_URL = "https://food2fork.ca/"
        const val SEARCH_URL = "api/recipe/search/"
        const val AUTH_TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}