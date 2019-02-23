package io.github.mehdi.domain.usecase

import kotlin.coroutines.CoroutineContext

interface UseCaseThreads {
    var backgroundContext: CoroutineContext
    var foregroundContext: CoroutineContext
}