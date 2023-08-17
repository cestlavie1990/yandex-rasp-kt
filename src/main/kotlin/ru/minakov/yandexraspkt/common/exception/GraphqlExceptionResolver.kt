package ru.minakov.yandexraspkt.common.exception

import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.schema.DataFetchingEnvironment
import jakarta.persistence.EntityNotFoundException
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter
import org.springframework.graphql.execution.ErrorType
import org.springframework.stereotype.Component

@Component
class GraphqlExceptionResolver : DataFetcherExceptionResolverAdapter() {
    override fun resolveToSingleError(ex: Throwable, env: DataFetchingEnvironment): GraphQLError {
        ex.printStackTrace()

        val error = GraphqlErrorBuilder.newError(env)
            .message(ex.message.orEmpty())
            .errorType(ErrorType.INTERNAL_ERROR)
            .path(env.getExecutionStepInfo().getPath())
            .location(env.getField().getSourceLocation())

        if (ex is EntityNotFoundException) error.errorType(ErrorType.NOT_FOUND)

        return error.build()
    }
}