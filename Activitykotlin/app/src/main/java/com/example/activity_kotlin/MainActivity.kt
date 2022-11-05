package com.example.activity_kotlin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var inputText:EditText
    lateinit var text:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputText=findViewById(R.id.edit_text_id)
        val secondActivityButton: Button = findViewById(R.id.next_activity_button_id)


        //below code is used for intent without passing data
        /*secondActivityButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }*/

        //when we pass data through intent we use below code
        secondActivityButton.setOnClickListener {
            text=inputText.text.toString().trim()
            val intent=Intent(this,MainActivity2::class.java).apply {  putExtra("TEXT",text)}
            startActivity(intent)
        }
    }
}