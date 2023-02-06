package com.noname.taskman.local_storage

import android.content.Context
import androidx.room.*
import androidx.room.Room.databaseBuilder
import com.noname.taskman.data_structure.Task


@Dao
interface TaskDao {
    // Добавление Person в бд
    @Insert
    fun insertAll(vararg task: Task?)

    // Удаление Person из бд
    @Delete
    fun delete(task: Task?)

    // Получение всех Person из бд
    @get:Query("SELECT * FROM tasks")
    val getTasks: List<Any?>?

    // Получение всех Person из бд с условием
    @Query("SELECT * FROM tasks WHERE id = :task_id")
    fun getAllPeopleWithFavoriteColor(task_id: Int?): List<Task?>?
}

@Database(
    entities = [Task::class /*, AnotherEntityType.class, AThirdEntityType.class */],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract val taskDao: TaskDao?
}
