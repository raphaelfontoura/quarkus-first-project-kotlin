package com.github.raphaelfontoura

import jakarta.inject.Singleton

@Singleton
class MessageRepositoryMemory: MessageRepository {

    companion object {
        var index = 0L
    }

    private val messageList = mutableListOf<Message>()

    override fun getAll(): List<Message> {
        return messageList
    }

    override fun save(message: Message) {
        message.id = ++index
        messageList.add(message)
    }

    override fun getById(id: Long): Message? {
        if (id > index) return null
        return messageList[id.toInt()-1]
    }
}