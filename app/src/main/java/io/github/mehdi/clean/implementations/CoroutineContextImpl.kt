package io.github.mehdi.clean.implementations

import io.github.mehdi.domain.usecase.UseCaseThreads
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CoroutineContextImpl
@Inject constructor(): UseCaseThreads
{
    override var backgroundContext: CoroutineContext
        get() = Dispatchers.IO
        set(value) {}

    override var foregroundContext: CoroutineContext
        get() = Dispatchers.Main
        set(value) {}
}