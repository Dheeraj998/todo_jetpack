package com.example.todoapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date
import kotlin.math.log

object TodoManager {
    private val todoList = mutableListOf<Todo>()


    fun getAllTodo(): List<Todo> {
        return todoList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        todoList.add(Todo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))

    }

    fun deleteTodo(id: Int) {
        todoList.removeIf {
            it.id == id
        }
        Log.i("tet", todoList.toString())
    }

}