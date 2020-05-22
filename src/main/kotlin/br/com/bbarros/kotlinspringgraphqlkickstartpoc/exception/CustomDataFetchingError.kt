package br.com.bbarros.kotlinspringgraphqlkickstartpoc.exception

import graphql.ErrorType
import graphql.GraphQLError
import graphql.execution.ExecutionPath
import graphql.language.SourceLocation
import java.util.*

class CustomDataFetchingError(private val path: ExecutionPath, private val throwable: Throwable, private val location: SourceLocation) : GraphQLError {
    override fun getMessage(): String {
        return (if (throwable is UsecaseException) throwable.message else throwable.toString())!!
    }

    override fun getLocations(): List<SourceLocation> {
        return Collections.singletonList(location)
    }

    override fun getErrorType(): ErrorType {
        return ErrorType.DataFetchingException
    }

    override fun getPath(): List<Any> {
        return path.toList()
    }

    override fun getExtensions(): Map<String, Any> {
        val extensions = LinkedHashMap<String, Any>()
        var code = "fail"

        extensions.put("code", code)
        if (throwable is GraphQLError) {
            val map = (throwable as GraphQLError).extensions
            if (map != null) extensions.putAll(map)
        }
        return extensions
    }

}