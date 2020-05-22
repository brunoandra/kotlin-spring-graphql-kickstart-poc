package br.com.bbarros.kotlinspringgraphqlkickstartpoc.domain

data class PersonDomain(
        val id: Long,
        val firstName: String,
        val lastName: String,
        val fullName: String
)