package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date


@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,
    var title:String,
    var createdAt:Date
)


@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodos(): List<Todo> {

    return listOf<Todo>(
        Todo(id = 1,"forst",Date.from(Instant.now())),
        Todo(id = 2,"seconde",Date.from(Instant.now())),
        Todo(id = 3,"third",Date.from(Instant.now())),
        Todo(id = 4,"fourth",Date.from(Instant.now())),
        )
}
