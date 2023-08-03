package com.br.myjetpackcomposeapplication.injection

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.br.myjetpackcomposeapplication.nav.MyNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object MyAppModule {

    @OptIn(ExperimentalComposeUiApi::class,
        ExperimentalFoundationApi::class,
        ExperimentalMaterialApi::class,
        ExperimentalAnimationApi::class
    )
    @Singleton
    @Composable
    @ViewScoped
    @Provides
    fun myNavigation() = MyNavigation()
}