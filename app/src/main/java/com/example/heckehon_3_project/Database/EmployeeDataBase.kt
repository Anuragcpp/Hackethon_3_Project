package com.example.heckehon_3_project.Database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class EmployeeDataBase: RoomDatabase() {

    abstract fun EmployeeDatabaseDao(): EmployeeDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE : EmployeeDataBase? = null

        fun getInstance(context : Context) : EmployeeDataBase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeDataBase::class.java,
                        "romm_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}