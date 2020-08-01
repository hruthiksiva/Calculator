package com.hruthik.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var countsign: Int = 0
        var dotcount: Int = 0
        var dividesign: Int = 0
        /*Number Buttons*/
        one.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("1", clear = true)
        }

        two.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("2", clear = true)
        }

        three.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("3", clear = true)
        }
        four.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("4", clear = true)
        }

        five.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("5", clear = true)
        }

        six.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("6", clear = true)
        }

        seven.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("7", clear = true)
        }

        eight.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("8", clear = true)
        }

        nine.setOnClickListener {
            countsign = 0
            dividesign = 0
            evaluateExpression("9", clear = true)
        }

        zero.setOnClickListener {
            countsign = 0
            if(dividesign==0)
                 evaluateExpression("0", clear = true)
        }

        /* Operators*/

        add.setOnClickListener {
            countsign++
            if (countsign == 1)
                evaluateExpression("+", clear = true)
        }

        minus.setOnClickListener {
            countsign++
            if (countsign == 1)
                evaluateExpression("-", clear = true)
        }

        multiply.setOnClickListener {
            countsign++
            if (countsign == 1)
                evaluateExpression("*", clear = true)
        }

        divide.setOnClickListener {
            countsign++
            dividesign++
            if (countsign == 1)
                evaluateExpression("/", clear = true)
        }

        dot.setOnClickListener {
            countsign++
            dotcount++
            if (countsign == 1 && dotcount==1)
                evaluateExpression(".", clear = true)
        }

        clear.setOnClickListener {
            expression.text = ""
            result.text = ""
        }
        equals.setOnClickListener {
            if(countsign==0 && expression.text.toString()!="") {
                val texts = expression.text.toString()
                if(texts.takeLast(1)=="*"||texts.takeLast(1)=="/"||texts.takeLast(1)=="+"||texts.takeLast(1)=="-"||texts.takeLast(1)==".")
                   expression.text.dropLast(1)

                val expressions = ExpressionBuilder(texts).build()
                val results = expressions.evaluate()
                val longResult = results.toLong()
                if (results == longResult.toDouble()) {
                    result.text = longResult.toString()
                } else {
                    result.text = results.toString()
                }
            }
        }

        delete.setOnClickListener {
            val texts = expression.text.toString()
            if (texts.isNotEmpty()) {
                expression.text = texts.dropLast(1)
               // if(expression.text.toString().takeLast(1)=="*"||expression.text.takeLast(1)=="/"||expression.text.takeLast(1)=="+"||expression.text.takeLast(1)=="-"||expression.text.takeLast(1)==".")
                 //   expression.text.dropLast(1)

            }

            result.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}