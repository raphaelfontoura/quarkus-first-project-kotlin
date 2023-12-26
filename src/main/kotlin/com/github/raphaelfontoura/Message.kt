package com.github.raphaelfontoura

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Message(
        @Id
        @GeneratedValue
        var id: Long? = null,
        val text: String
)