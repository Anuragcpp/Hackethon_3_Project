package com.example.heckehon_3_project.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity(tableName = "Employee_table")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    var employeeID : Int = 0,

    @ColumnInfo(name = "name")
    var  name : String = "",

    @ColumnInfo(name = "Phone Number")
    var phoneNo: String = "",

    @ColumnInfo(name = "Address")
    var address: String = "",

    @ColumnInfo(name = "Salary")
    var salary :String = "",
)
