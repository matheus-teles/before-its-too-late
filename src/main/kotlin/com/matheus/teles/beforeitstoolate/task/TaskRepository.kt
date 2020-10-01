package com.matheus.teles.beforeitstoolate.task

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.Repository
import java.util.*

interface TaskRepository : Repository<Task, UUID>, JpaSpecificationExecutor<Task> {
    fun save(task: Task): Task
}