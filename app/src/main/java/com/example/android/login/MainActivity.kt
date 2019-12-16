package com.example.android.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor( val inValue: Int){

        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var login = findViewById<TextView>(R.id.idLoginText)
        var password = findViewById<TextView>(R.id.idPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            when (checkLogin(login.text.toString(),password.text.toString())) {

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext,getString(R.string.errMessageLogin),Toast.LENGTH_LONG).show()
                    login.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext,getString(R.string.errMessagePassword),Toast.LENGTH_LONG).show()
                    password.requestFocus()
                }
                else -> Toast.makeText(applicationContext,"Success!",Toast.LENGTH_LONG).show()
            }
        }

    }
    fun checkLogin(txtLogin: String, txtPassword: String): LoginSuccess{
        val holdLogin = "Van"
        val holdPassword = "password"

        if (holdLogin != txtLogin){
            return LoginSuccess.login
        }
        return if (holdPassword != txtPassword){
             LoginSuccess.password
        } else {
             LoginSuccess.success
        }

    }
}
