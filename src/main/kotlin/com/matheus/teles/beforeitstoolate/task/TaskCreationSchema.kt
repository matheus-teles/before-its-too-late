package com.matheus.teles.beforeitstoolate.task

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull

data class TaskCreationSchema(
    @get:NotNull
    @JsonProperty("title")
    val title: String?,
    val description: String?
) {
    fun toTask(): Task {
        return Task.build(title!!, description)
    }
}