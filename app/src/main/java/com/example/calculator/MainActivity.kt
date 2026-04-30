package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val operand1EditText = findViewById<EditText>(R.id.operand1EditText)
        val operand2EditText = findViewById<EditText>(R.id.operand2EditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val operationRadioGroup = findViewById<RadioGroup>(R.id.operationRadioGroup)
        val equalButton = findViewById<Button>(R.id.equalButton)

        equalButton.setOnClickListener {
            val op1String = operand1EditText.text.toString()
            val op2String = operand2EditText.text.toString()

            if (op1String.isNotEmpty() && op2String.isNotEmpty()) {
                val op1 = op1String.toDouble()
                val op2 = op2String.toDouble()

                val operation = when (operationRadioGroup.checkedRadioButtonId) {
                    R.id.addRadioButton -> Operations.ADD
                    R.id.subtractRadioButton -> Operations.SUBTRACT
                    R.id.multiplyRadioButton -> Operations.MULTIPLY
                    R.id.divideRadioButton -> Operations.DIVIDE
                    else -> null
                }

                if (operation != null) {
                    val calculator = Calculator(op1, op2)
                    val result = calculator.calculate(operation)

                    if (result.isNaN()) {
                        resultTextView.text = getString(R.string.error_division_by_zero)
                    } else {
                        // Display the result formatted to avoid trailing zeros if it's an integer
                        val formattedResult = if (result == result.toLong().toDouble()) {
                            result.toLong().toString()
                        } else {
                            result.toString()
                        }
                        resultTextView.text = getString(R.string.result_text, formattedResult)
                    }
                } else {
                    Toast.makeText(this, getString(R.string.error_select_operation), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
