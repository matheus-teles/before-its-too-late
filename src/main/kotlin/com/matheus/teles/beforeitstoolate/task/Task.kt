package com.matheus.teles.beforeitstoolate.task

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tasks")
class Task private constructor(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(name = "title")
    val title: String,

    @Column(name = "description")
    val description: String?,

    @Column(name = "status")
    var status: TaskStatus
) {
    companion object {
        fun build(
            title: String,
            description: String?,
            status: TaskStatus = TaskStatus.TO_DO
        ) = Task(
            title = title,
            description = description,
            status = status
        )
    }

    fun markAsDone() {
        this.status = TaskStatus.DONE
    }
}

enum class TaskStatus {
    TO_DO, DONE
}