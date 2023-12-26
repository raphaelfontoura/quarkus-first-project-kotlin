package com.github.raphaelfontoura

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.persistence.EntityNotFoundException

@ApplicationScoped
class MessageService(
    @Inject
    val repository: MessageRepository
) {

    fun getAll(): List<Message> {
        return repository.getAll()
    }

    fun save(message: Message) {
        repository.save(message)
    }

    fun getOneById(id: Long): Message {
        return repository.getById(id) ?: throw EntityNotFoundException("Valor não localizado")
    }

}