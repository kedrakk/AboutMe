package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener{
            clickDoneButton(it)
        }
    }

    private fun clickDoneButton(view: View){
        val editText=findViewById<EditText>(R.id.nickname_edit);
        val nicknameText=findViewById<TextView>(R.id.nickname_text);
        nicknameText.text=editText.text;
        editText.visibility= View.GONE;
        view.visibility=View.GONE;
        nicknameText.visibility=View.VISIBLE;

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        imm.hideSoftInputFromWindow(view.windowToken,0);
    }
}