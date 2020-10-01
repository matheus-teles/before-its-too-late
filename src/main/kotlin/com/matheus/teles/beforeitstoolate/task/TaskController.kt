package com.matheus.teles.beforeitstoolate.task

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskRepository: TaskRepository
) {
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun create(@Valid @RequestBody taskCreationSchema: TaskCreationSchema) {
        val task = taskCreationSchema.toTask()
        taskRepository.save(task)
    }

    @GetMapping
    fun list(@RequestParam status: TaskStatus?): List<TaskDTO> {
        return taskRepository.findAll(TaskSpecification.byStatus(status)).map { TaskDTO.from(it) }
    }
}