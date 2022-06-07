package gabor.koleszar.recipeapp.domain.repository

import gabor.koleszar.recipeapp.core.Resource
import gabor.koleszar.recipeapp.domain.model.RecipeListPage
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipeListPage(page: Int, query: String): Flow<Resource<RecipeListPage>>
}