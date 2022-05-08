package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.doneButton.setOnClickListener{
            clickDoneButton(it)
        }
    }

    private fun clickDoneButton(view: View){
        binding.apply {
            nicknameText.text=binding.nicknameEdit.text;
            invalidateAll()
            nicknameEdit.visibility=View.GONE;
            doneButton.visibility=View.GONE;
            nicknameText.visibility=View.VISIBLE;
        }

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
        imm.hideSoftInputFromWindow(view.windowToken,0);
    }
}