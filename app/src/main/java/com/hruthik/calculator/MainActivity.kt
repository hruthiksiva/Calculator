package com.hruthik.calculator

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var countsign: Int = 0
        var dotcount: Int = 0
        var dividesign: Int = 0
        expression.movementMethod = ScrollingMovementMethod()
        result.movementMethod = ScrollingMovementMethod()

        /*Number Buttons*/
        one.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("1", clear = true)
        }

        two.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("2", clear = true)
        }

        three.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("3", clear = true)
        }
        four.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("4", clear = true)
        }

        five.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("5", clear = true)
        }

        six.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("6", clear = true)
        }

        seven.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("7", clear = true)
        }

        eight.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("8", clear = true)
        }

        nine.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            dividesign = 0
            evaluateExpression("9", clear = true)
        }

        zero.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign = 0
            if(dividesign==0)
                 evaluateExpression("0", clear = true)
        }

        /* Operators*/

        add.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign++
            if (countsign == 1)
                evaluateExpression("+", clear = true)
        }

        minus.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign++
            if (countsign == 1)
                evaluateExpression("-", clear = true)
        }

        multiply.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign++
            if (countsign == 1)
                evaluateExpression("*", clear = true)
        }

        divide.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign++
            dividesign++
            if (countsign == 1)
                evaluateExpression("/", clear = true)
        }

        dot.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            countsign++
            dotcount++
            if (countsign == 1 && dotcount==1)
                evaluateExpression(".", clear = true)
        }

        clear.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            expression.text = ""
            result.text = ""
        }
        equals.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            try {

                if (countsign == 0 && expression.text.toString() != "") {
                    val texts = expression.text.toString()
                    // if(texts.takeLast(1)=="*"||texts.takeLast(1)=="/"||texts.takeLast(1)=="+"||texts.takeLast(1)=="-"||texts.takeLast(1)==".")
                    //    expression.text.dropLast(1)

                    val expressions = ExpressionBuilder(texts).build()
                    val results = expressions.evaluate()
                    val longResult = results.toLong()
                    if (results == longResult.toDouble()) {
                        result.text = longResult.toString()
                    } else {
                        result.text = results.toString()
                    }
                    expression.text=result.text.toString()
                }
            }
            catch (e: Exception)
            {
                result.text="Invalid"
            }
        }

        delete.setOnClickListener {
            val vibratorService = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).also {
                it.vibrate(100)
            }
            val texts = expression.text.toString()
            if (texts.isNotEmpty()) {
                expression.text = texts.dropLast(1)
                if(texts.last().toString()=="*"||texts.takeLast(1)=="/"||texts.takeLast(1)=="+"||texts.takeLast(1)=="-"||texts.takeLast(1)==".")
                    expression.text.dropLast(1)

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
    /*fun Fragment.vibratePhone() {
        val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(20)
       } }*/

}