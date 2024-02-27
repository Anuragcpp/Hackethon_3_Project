package com.example.heckehon_3_project

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.heckehon_3_project.Database.Employee
import com.example.heckehon_3_project.Database.EmployeeDataBase
import com.example.heckehon_3_project.Database.EmployeeDatabaseDao
import com.example.heckehon_3_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var userName:EditText
    private lateinit var userAddress:EditText
    private lateinit var userSalary:EditText
    private lateinit var userPhoneNo:EditText
    private lateinit var application: Application
    private lateinit var submitBtn:Button
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        userName = binding.userName
        userAddress = binding.userAddress
        userPhoneNo = binding.userPhoneNo
        userSalary = binding.userSalary
        submitBtn = binding.submitBtn



        submitBtn.setOnClickListener {
            //db().start()

            var ab : EmployeeDataBase = Room.databaseBuilder(this@MainActivity,EmployeeDataBase::class.java,
                "employee_table").build()
            var employeeDBDao:EmployeeDatabaseDao = ab.EmployeeDatabaseDao()
            employeeDBDao.insertRecord(Employee(userName.text.toString(),userPhoneNo.text.toString(),
                userAddress.text.toString(),userSalary.text.toString()))
        }

    }
   inner class db:Thread(){
        override fun run() {
            super.run()
        }
    }
}