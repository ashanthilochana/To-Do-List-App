package com.ashan.todolistapp

import android.content.Context
import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ashan.todolistapp.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val contex: Context,
    private val binding: TaskItemCellBinding,
    private val clickListner: TaskItemClickListner

): RecyclerView.ViewHolder(binding.root){

    @RequiresApi(Build.VERSION_CODES.O)
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    @RequiresApi(Build.VERSION_CODES.O)
    fun bindTaskItem(taskItem: TaskItem){
        binding.name.text = taskItem.name

        if(taskItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(contex))

        binding.completeButton.setOnClickListener {
            clickListner.completeTaskItem(taskItem)
        }

        binding.taskCellContainer.setOnClickListener {
            clickListner.editTaskItem(taskItem)
        }

        if (taskItem.dueTime != null) {
            binding.dueTime.text = timeFormat.format(taskItem.dueTime)
        } else {
            binding.dueTime.text = ""
        }

    }

}