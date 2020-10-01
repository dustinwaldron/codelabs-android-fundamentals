package com.dwaldron.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var diceOneNumber: Int? = null
    private var diceTwoNumber: Int? = null

    private lateinit var diceOneImage: ImageView
    private lateinit var diceTwoImage: ImageView
    private lateinit var rollButton: Button
    private lateinit var resetButton: Button
    private lateinit var countUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRollButton()
        setupCountUpButton()
        setupResetButton()
    }

    private fun randomNumber(): Int {
        return (1..6).random()
    }

    private fun determineDiceImage(num: Int?): Int {
        return when(num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }

    private fun setupDiceImageViews() {
        diceOneImage = findViewById(R.id.dice_image_one)
        diceOneImage.setImageResource(determineDiceImage(diceOneNumber))
        diceTwoImage = findViewById(R.id.dice_image_two)
        diceTwoImage.setImageResource(determineDiceImage(diceTwoNumber))
    }

    private fun setupRollButton() {
        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            diceOneNumber = randomNumber()
            diceTwoNumber = randomNumber()
            setupDiceImageViews()
        }
    }

    private fun setupResetButton() {
        resetButton = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {
            diceOneNumber = null
            diceTwoNumber = null
            setupDiceImageViews()
        }
    }

    private fun incrementNumber(num: Int?): Int {
        return when (num) {
            null -> 1
            6 -> 6
            else -> {
                num!! + 1
            }
        }
    }

    private fun setupCountUpButton() {
        countUpButton = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener {
            // Count Up until 6. If not set, default to 1
            diceOneNumber = incrementNumber(diceOneNumber)
            diceTwoNumber = incrementNumber(diceOneNumber)
            setupDiceImageViews()
        }
    }

//    private fun rollDice() {
//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT)
//            .show()
//    }
}