package com.github.raphaelfontoura

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
class Message(
        @Id
        @GeneratedValue
        var id: Long? = null,
        val text: String
)