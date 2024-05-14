package com.ashan.todolistapp

interface TaskItemClickListner {
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}