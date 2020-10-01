package com.matheus.teles.beforeitstoolate.task

import org.springframework.data.jpa.domain.Specification

object TaskSpecification {
    fun byStatus(status: TaskStatus?) : Specification<Task> {
        return Specification { root, _, cb ->
            status?.let {
                cb.equal(root.get<TaskStatus>("status"), it)
            }
        }
    }
}