package com.example.exerciciex3

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var number = 0
    private var number2 = 24f
    private var textColor = Color.BLACK
    private var backgroundColor = Color.WHITE
    private var isTextViewVisible = true
    private var TAG = "Filtra"
    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate")
        Toast.makeText(this, "on Create", Toast.LENGTH_SHORT).show()

        constraintLayout = findViewById(R.id.main)

        savedInstanceState?.let {
            number = it.getInt("number", 0)
            number2 = it.getFloat("textSize", 24f)
            textColor = it.getInt("textColor", Color.BLACK)
            backgroundColor = it.getInt("backgroundColor", Color.WHITE)
            isTextViewVisible = it.getBoolean("isTextViewVisible", true) // Restaurar visibilidad
        }

        val textView = findViewById<TextView>(R.id.textView3)
        textView.text = "$number"
        textView.textSize = number2
        textView.setTextColor(textColor)
        constraintLayout.setBackgroundColor(backgroundColor)
        textView.visibility = if (isTextViewVisible) View.VISIBLE else View.GONE

        SUMAR()
        RESTAR()
        AMAGAR()
        MOSTRAT()
        AUGMENTAR()
        DISMINUIR()
        COLORFONS()
        COLORTEXT()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("number", number)
        outState.putFloat("textSize", number2)
        outState.putInt("textColor", textColor)
        outState.putInt("backgroundColor", backgroundColor)
        outState.putBoolean("isTextViewVisible", isTextViewVisible) // Guardar visibilidad
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        Toast.makeText(this, "on pause", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        Toast.makeText(this, "on Start", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        Toast.makeText(this, "on Resume", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        Toast.makeText(this, "on Stop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        Toast.makeText(this, "on Destroy", Toast.LENGTH_SHORT).show()
    }

    fun SUMAR() {
        val button = findViewById<Button>(R.id.button9)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            number++
            textView.text = "$number"
        }
    }

    fun RESTAR() {
        val button = findViewById<Button>(R.id.button8)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            number--
            textView.text = "$number"
        }
    }

    fun AMAGAR() {
        val button = findViewById<Button>(R.id.button13)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            textView.visibility = View.GONE
            isTextViewVisible = false
        }
    }

    fun MOSTRAT() {
        val button = findViewById<Button>(R.id.button12)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            textView.visibility = View.VISIBLE
            isTextViewVisible = true
        }
    }

    fun AUGMENTAR() {
        val button = findViewById<Button>(R.id.button10)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            number2++
            textView.textSize = number2
        }
    }

    fun DISMINUIR() {
        val button = findViewById<Button>(R.id.button11)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            number2--
            textView.textSize = number2
        }
    }

    fun COLORTEXT(){
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView3)
        button.setOnClickListener {
            textColor = getRandomColor()
            textView.setTextColor(textColor)
        }
    }

    fun COLORFONS(){
        val button = findViewById<Button>(R.id.button2)
        constraintLayout = findViewById(R.id.main)
        button.setOnClickListener {
            backgroundColor = getRandomColor()
            constraintLayout.setBackgroundColor(backgroundColor)
        }
    }

    private fun getRandomColor(): Int {
        return Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    }
}
