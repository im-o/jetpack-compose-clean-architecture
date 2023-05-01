package com.rivaldy.id.core.domain.usecase

abstract class BaseUseCaseSuspend<in Params, out T> {
    abstract suspend fun execute(params: Params): T
}