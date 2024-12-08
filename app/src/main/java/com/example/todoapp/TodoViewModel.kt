package com.example.todoapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {

    private var _todoList= MutableLiveData<List<Todo>>()

    val todoList:LiveData<List<Todo>> = _todoList


    private fun getAllTodo(){
        Log.i("ss", "getAllTodo:  ")
    _todoList.value= TodoManager.getAllTodo()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title:String){
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun deleteTodo(id:Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }
}