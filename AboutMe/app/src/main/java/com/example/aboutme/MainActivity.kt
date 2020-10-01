package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editText :EditText
    private lateinit var nicknameTextView :TextView
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.nickname_edit)
        nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        doneButton = findViewById<Button>(R.id.done_button)
        doneButton.setOnClickListener {
            addNickname(it)
        }
        nicknameTextView.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        nicknameTextView.text = editText.text
        nicknameTextView.visibility = View.VISIBLE
        editText.visibility = View.GONE
        view.visibility = View.GONE
    }

    private fun updateNickname (view: View) {
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}