package gabor.koleszar.recipeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gabor.koleszar.recipeapp.data.RecipeApi
import gabor.koleszar.recipeapp.data.RecipeApi.Companion.BASE_URL
import gabor.koleszar.recipeapp.data.repository.RecipeRepositoryImpl
import gabor.koleszar.recipeapp.domain.repository.RecipeRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRecipeApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }


    @Singleton
    @Provides
    fun providesRecipeApi(api: RecipeApi): RecipeRepository {
        return RecipeRepositoryImpl(api)
    }

}