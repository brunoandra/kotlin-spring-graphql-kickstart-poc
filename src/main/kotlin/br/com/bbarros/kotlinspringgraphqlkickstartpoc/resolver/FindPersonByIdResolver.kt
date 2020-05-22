package br.com.bbarros.kotlinspringgraphqlkickstartpoc.resolver

import br.com.bbarros.kotlinspringgraphqlkickstartpoc.domain.PersonDomain
import br.com.bbarros.kotlinspringgraphqlkickstartpoc.exception.UsecaseException
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class FindPersonByIdResolver: GraphQLQueryResolver {
    fun findPersonById(id: Long): PersonDomain {
        throw UsecaseException("teste de erro")
        return PersonDomain(1,"bruno","Barros", "Bruno Barros")
    }
}