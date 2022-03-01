package com.telda.di

import com.telda.data.remote.MoviesApis
import com.telda.data.repository.MoviesRepository
import com.telda.domain.model.popular.MoviesGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun providesMoviesRepository(api: MoviesApis): MoviesGateway =
        MoviesRepository(api)



}