package com.example.activity_kotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Part.TEXT
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ShareCompat
import java.net.URI

class MainActivity2 : AppCompatActivity() {
   /* companion object{
        var TEXT="TEXT"
    }*/

    lateinit var text1:TextView
    lateinit var msg:String
    lateinit var backButton: Button
    lateinit var webButton: Button
    lateinit var dialButton: Button
    lateinit var mapButton: Button
    lateinit var webText:EditText
    lateinit var dialText:EditText
    lateinit var mapText:EditText
    lateinit var shareText:EditText
    lateinit var shareButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        text1=findViewById(R.id.text_in_main_activity2_id)
        webText=findViewById(R.id.website_text_id)
        dialText=findViewById(R.id.dial_pad_text_id)
        mapText=findViewById(R.id.map_text_id)
        shareText=findViewById(R.id.share_text_id)
        shareButton=findViewById(R.id.share_button_id)
        backButton=findViewById(R.id.back_button_id)
        webButton=findViewById(R.id.web_button_id)
        dialButton=findViewById(R.id.dial_button_id)
        mapButton=findViewById(R.id.map_button_id)

        msg=intent.getStringExtra("TEXT").toString()
        text1.text=msg

        backButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        webButton.setOnClickListener {
            val uri:Uri=Uri.parse(webText.text.toString())
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }
        dialButton.setOnClickListener {
            val uri:Uri=Uri.parse("tel:"+dialText.text.toString())
            startActivity(Intent(Intent.ACTION_DIAL,uri))
        }
        mapButton.setOnClickListener {
            val uri:Uri=Uri.parse("geo:0,0?q="+mapText.text.toString())
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }
        shareButton.setOnClickListener {
            ShareCompat.IntentBuilder.from(this)
                .setText(shareText.text.toString())
                .setChooserTitle("Share this text")
                .setType("text/plain")
                .startChooser()
        }

    }
}