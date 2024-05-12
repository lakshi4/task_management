package com.example.todo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.todo.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db:TaskDatabase
    private var taskId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding =ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_update_task)
        db = TaskDatabase(this)

        taskId =intent.getIntExtra("task_id",-1)
        if(taskId == -1){
            finish()
            return
        }
        val task =db.getTaskByID(taskId)
        binding.updateTitleEditText.setText(task.title)
        binding.updateContentEditText.setText(task.content)

         binding.updateSaveButton.setOnClickListener {
             val newTitle = binding.updateTitleEditText.text.toString()
             val newContent= binding.updateContentEditText.text.toString()
             val updateTask =Task(taskId,newTitle,newContent)
             db.updateTask(updateTask)
             finish()
             Toast.makeText(this,"Changes Saved",Toast.LENGTH_SHORT).show()


         }

    }
}