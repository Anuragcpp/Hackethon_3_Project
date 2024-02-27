package com.example.heckehon_3_project.Database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface EmployeeDatabaseDao {
    @Insert
    fun insertRecord(employee: Employee)

}