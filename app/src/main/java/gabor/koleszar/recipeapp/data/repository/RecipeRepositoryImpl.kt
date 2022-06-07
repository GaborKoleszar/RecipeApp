package gabor.koleszar.recipeapp.data.repository

import gabor.koleszar.recipeapp.core.Resource
import gabor.koleszar.recipeapp.data.RecipeApi
import gabor.koleszar.recipeapp.domain.model.RecipeListPage
import gabor.koleszar.recipeapp.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RecipeRepositoryImpl(
    private val api: RecipeApi
) : RecipeRepository {
    override fun getRecipeListPage(page: Int, query: String): Flow<Resource<RecipeListPage>> =
        flow {
            emit(Resource.Loading())
            try {
                val response = api.getRecipeListPage(page = page, query = query).toRecipeListPage()
                emit(Resource.Success(response))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message()))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: e.toString()))
            }
        }
}