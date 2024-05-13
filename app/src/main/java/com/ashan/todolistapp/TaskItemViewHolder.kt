package com.ashan.todolistapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.ashan.todolistapp.databinding.TaskItemCellBinding

class TaskItemViewHolder(
    private val contex: Context,
    private val binding: TaskItemCellBinding
): RecyclerView.ViewHolder(binding.root){

    fun bindTaskItem(taskItem: TaskItem){
        binding.name.text = taskItem.name
    }

}