package br.com.bbarros.kotlinspringgraphqlkickstartpoc.exception

class UsecaseException(message: String?) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}