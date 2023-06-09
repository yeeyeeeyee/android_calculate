package com.example.basic_calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/*
欠缺功能:
    設置 % 取餘數
    修改架構
 */

data class Display(var num1Value: String, var operation: String, var num2Value: String)

@Composable
fun CalculatorUi() {
    val number by remember {
        mutableStateOf(Display(num1Value = "", operation = "", num2Value = ""))
    }
    var display by remember {
        mutableStateOf("=")
    }
    val isFirstValueStored = remember { mutableStateOf(true) }


    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {//背景黑色 &&填滿畫面
        //位置
        Column(verticalArrangement = Arrangement.Bottom) {
            //顯示已輸入的數字

            //數字1: 運算符號前
            DisplayText(text = number.num1Value)
            //運算符號
            DisplayText(text = number.operation)
            //數字2: 運算符號後
            DisplayText(text = number.num2Value)

            //顯示輸入文字
            Text(
                text = display,
                textAlign = TextAlign.End,
                color = Color.White,
                fontSize = 50.sp,
                modifier = Modifier
                    .padding(10.dp, 0.dp)
                    .fillMaxWidth()
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            //按鈕
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                //當沒有選擇符號為顯示百分位數,否則取餘數
                ButtonStyle("%") {
                    if (display != "=") {
                        if (isFirstValueStored.value) {
                            number.num1Value = display.substring(1)
                            number.operation = "%"
                            display = "="
                            isFirstValueStored.value = false

                        }
                    }
                }
                //當value1還有值,就清除value2,否則全部清空
                ButtonStyle("CE") {
                        display = if (number.num1Value != "") {
                            "="
                    } else {

                        clearAllValues(number,isFirstValueStored)
                        "="
                    }
                }
                ButtonStyle("C") {
                    clearAllValues(number, isFirstValueStored)
                    display = "="
                }
                ButtonStyle("←") {
                    if (display.length > 1) {
                        display = display.dropLast(1)
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("⅟x") {}
                ButtonStyle("x²") {}
                ButtonStyle("√x") {}
                ButtonStyle("÷") {
                    if (display != "=") {
                        if (isFirstValueStored.value) {
                            number.num1Value = display.substring(1)
                            number.operation = "÷"
                            display = "="
                            isFirstValueStored.value = false
                        }
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("7", onclick = { display += "7" })
                ButtonStyle("8", onclick = { display += "8" })
                ButtonStyle("9", onclick = { display += "9" })
                ButtonStyle("x") {
                    if (display != "=") {
                        if (isFirstValueStored.value) {
                            number.num1Value = display.substring(1)
                            number.operation = "x"
                            display = "="
                            isFirstValueStored.value = false

                        }
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("4", onclick = { display += "4" })
                ButtonStyle("5", onclick = { display += "5" })
                ButtonStyle("6", onclick = { display += "6" })
                ButtonStyle("-") {
                    if (display != "=") {
                        if (isFirstValueStored.value) {
                            number.num1Value = display.substring(1)
                            number.operation = "-"
                            display = "="
                            isFirstValueStored.value = false

                        }
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("1", onclick = { display += "1" })
                ButtonStyle("2", onclick = { display += "2" })
                ButtonStyle("3", onclick = { display += "3" })
                //如果display 沒有數字無法啟用,當有數字時同時設定number.value的值跟operation為"+"
                ButtonStyle("+") {
                    if (display != "=") {
                        if (isFirstValueStored.value) {
                            number.num1Value = display.substring(1)
                            number.operation = "+"
                            display = "="
                            isFirstValueStored.value = false

                        }
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp, 10.dp, 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ButtonStyle("+/-"){}
                ButtonStyle("0", onclick = { display += "0" })
                //沒有小數點就加上小數點
                ButtonStyle(".") {
                    if (!display.contains(".")) {
                        display += "."
                    }
                }
                //需要先把文字轉成數字才能運算
                ButtonStyle("=") {
                    //防止啥都不按,只按'='
                    if (number.operation != "") {
                        //要做出計算機的連續加法
                        //一個參數的
                        if (display == "=") {
                            val answer = Operation().operation(
                                num1 = number.num1Value.toDouble(),
                                operation=number.operation
                            )
                            display = "=$answer"
                            clearAllValues(number,isFirstValueStored)

                        //兩個參數的
                        } else {
                            number.num2Value = display.substring(1)
                            val answer = Operation().operation(
                                num1 = number.num1Value.toDouble(),
                                num2 = number.num2Value.toDouble(),
                                operation = number.operation
                            )
                            display = "=$answer"
                            clearAllValues(number,isFirstValueStored)

                        }
                    }


                }
            }
        }
    }
}
//清除
private fun clearAllValues(number: Display, isFirstValueStored: MutableState<Boolean>) {
    number.num1Value = ""
    number.num2Value = ""
    number.operation = ""
    isFirstValueStored.value = true
}



@Preview(showBackground = false)
@Composable
fun Basic_CalculatorTheme() {
    CalculatorUi()

}


