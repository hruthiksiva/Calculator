package com.hruthik.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Number Buttons*/
        one.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        two.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        three.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        four.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        five.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        six.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        seven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        eight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        nine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        zero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /* Operators*/

        add.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        minus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        multiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        divide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        dot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        clear.setOnClickListener {
            expression.text = ""
            result.text = ""
        }
        equals.setOnClickListener {
            val text = expression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val results = expression.evaluate()
            val longResult = results.toLong()
            if (results == longResult.toDouble()) {
                result.text = longResult.toString()
            } else {
                result.text = result.toString()
            }
        }

        delete.setOnClickListener {
            val text = expression.text.toString()
            if(text.isNotEmpty()) {
                expression.text = text.drop(1)
            }

            result.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }

    }