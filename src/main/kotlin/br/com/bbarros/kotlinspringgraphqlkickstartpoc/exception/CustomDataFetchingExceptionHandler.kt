package br.com.bbarros.kotlinspringgraphqlkickstartpoc.exception

import graphql.execution.DataFetcherExceptionHandler
import graphql.execution.DataFetcherExceptionHandlerParameters
import graphql.execution.DataFetcherExceptionHandlerResult

class CustomDataFetchingExceptionHandler : DataFetcherExceptionHandler {
    override fun onException(handlerParameters: DataFetcherExceptionHandlerParameters): DataFetcherExceptionHandlerResult? {
        var path = handlerParameters.path
        var exception = handlerParameters.exception
        var location = handlerParameters.sourceLocation
        var error = CustomDataFetchingError(path, exception, location)
        return DataFetcherExceptionHandlerResult.newResult().error(error).build();
    }
}