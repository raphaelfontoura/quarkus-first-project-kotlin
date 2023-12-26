package com.github.raphaelfontoura

interface MessageRepository {
    fun getAll(): List<Message>
    fun save(message: Message)
    fun getById(id: Long): Message?
}