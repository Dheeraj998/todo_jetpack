package com.example.todoapp

import android.icu.text.CaseMap.Title
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {
    val todoDao = MainApplication.todoDataBase.getTodoDao()
    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))

        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)

        }
    }
}



//TodoManager
//class TodoViewModel : ViewModel() {
//
//    private var _todoList= MutableLiveData<List<Todo>>()
//
//    val todoList:LiveData<List<Todo>> = _todoList
//
//
//    private fun getAllTodo(){
//        Log.i("ss", "getAllTodo:  ")
//    _todoList.value= TodoManager.getAllTodo()
//    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun addTodo(title:String){
//        TodoManager.addTodo(title)
//        getAllTodo()
//    }
//
//    fun deleteTodo(id:Int){
//        TodoManager.deleteTodo(id)
//        getAllTodo()
//    }
//}