package io.github.mehdi.clean.di.bindings

import dagger.Binds
import dagger.Module
import io.github.mehdi.clean.implementations.CoroutineContextImpl
import io.github.mehdi.clean.implementations.ErrorUtil
import io.github.mehdi.domain.usecase.UseCaseErrorUtil
import io.github.mehdi.domain.usecase.UseCaseThreads

@Module
interface ModuleImplBindings {

    @Binds
    fun bindUseCaseThreads(coroutineContextImpl: CoroutineContextImpl): UseCaseThreads

    @Binds
    fun bindUseCaseErrorUtil(errorUtil: ErrorUtil): UseCaseErrorUtil
}