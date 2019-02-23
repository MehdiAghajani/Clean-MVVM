package io.github.mehdi.domain.usecase

import io.github.mehdi.domain.model.wrapper.APIResponse
import io.github.mehdi.domain.model.wrapper.ErrorResponse
import io.github.mehdi.domain.model.wrapper.SuccessResponse
import kotlinx.coroutines.*
import java.lang.Exception

abstract class BaseUseCase<T>(
    private val errorUti: UseCaseErrorUtil,
    private val threads: UseCaseThreads
) {

    protected var parentJob: Job = Job()

    abstract suspend fun buildUseCaseDeferred(): Deferred<T>

    fun execute(
        jobList: MutableList<Job>,
        onResponse: (APIResponse<T>) -> Unit
    ){
        parentJob.cancel()
        parentJob =
        GlobalScope.launch(threads.foregroundContext){
            try {
                val result = withContext(threads.backgroundContext){
                    buildUseCaseDeferred().await()
                }
                onResponse(SuccessResponse(result))
            }
            catch (e: CancellationException){

            }
            catch (e: Exception){
                onResponse(ErrorResponse(errorUti.getErrorModel(e)))
            }
        }.also { jobList.add(it) }
    }
}