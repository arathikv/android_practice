package com.example.newapp.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.newapp.R
import com.example.newapp.databinding.ActivityCalculatorMainBinding
import com.example.newapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorMainBinding

    private var lastNumeric = false
    private var lastDot = false
    var isStateError = false
    private lateinit var expression: Expression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onDigitClick(view: View) {
        if (isStateError) {
            binding.dataTextView.text = (view as Button).text
            isStateError = false
        } else {
            binding.dataTextView.append((view as Button).text)
        }
        lastNumeric = true
        onEqual()
    }

    fun onOperatorClick(view: View) {
        if (!isStateError && lastNumeric) {
            binding.dataTextView.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqual()
        }
    }

    fun onEqualClick(view: View) {

        onEqual()
        binding.dataTextView.text = binding.resultTextView.text.toString().drop(1)
    }

    fun onClearClick(view: View) {
        binding.dataTextView.text = ""
        lastNumeric = false
    }

    fun onBackClick(view: View) {
        binding.dataTextView.text = binding.dataTextView.text.toString().dropLast(1)
        try {
            val lastChar = binding.dataTextView.text.toString().last()
            if (lastChar.isDigit()) {
                onEqual()
            }
        } catch (e: Exception) {
            binding.resultTextView.text = ""
            binding.resultTextView.visibility = View.GONE
            Log.e("last character error", e.toString())
        }
    }

    fun onAllClearClick(view: View) {
        binding.dataTextView.text = ""
        binding.resultTextView.text = ""
        isStateError = false
        lastDot = false
        lastNumeric = false
        binding.resultTextView.visibility = View.GONE
    }

    fun onEqual() {
        if (lastNumeric && !isStateError) {
            val text = binding.dataTextView.text.toString()
            expression = ExpressionBuilder(text).build()
            try {
                val result = expression.evaluate()
                binding.resultTextView.visibility = View.VISIBLE
                binding.resultTextView.text = "=" + result.toString()
            } catch (e: ArithmeticException) {
                Log.e("Evaluate Error", e.toString())
                binding.resultTextView.text = "Error"
                isStateError = true
                lastNumeric = false
            }
        }
    }

}
