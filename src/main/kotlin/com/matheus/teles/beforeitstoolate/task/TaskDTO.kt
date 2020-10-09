package com.matheus.teles.beforeitstoolate.task

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskDTO(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("status")
    val status: TaskStatus
) {
    companion object {
        fun from(task: Task) = TaskDTO(
            title = task.title,
            description = task.description,
            status = task.status
        )
    }
}