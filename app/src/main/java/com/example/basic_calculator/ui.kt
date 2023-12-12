package com.example.basic_calculator

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


/*
欠缺功能:
    按 c 需要按其他鍵才會有反應
    修改架構
    限制文字長度
    讓0.01 把 "."取消 會變成 001 改成只有 1

欠缺風格:
頂部導覽的menu配上抽屜導覽

已知道bug:
    可以讓num1 為0. 結束
 */

@Composable
fun CalculatorUi() {
    TopBar()
    }




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            //整個抽屜
            ModalDrawerSheet (modifier = Modifier.padding(end = 100.dp)){
                Text("設定標題", fontSize = 30.sp ,modifier = Modifier.padding(20.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "基礎功能") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "計算貨幣") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "計算長度") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "配置設定") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        },
        //初始狀態
        drawerState = drawerState,
        //是否可以拖移打開抽屜
        gesturesEnabled = true,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Calculator") },
                    //頂部導覽的顏色
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = StyleColor.backGroundColor,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {scope.launch{
                            drawerState.apply {
                               open()
                            }
                        }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "menu")
                        }
                    }
                )
            },
            //這是調整頂部導覽以下的顏色
            containerColor = StyleColor.backGroundColor,
            contentColor = Color.White,
        ) {
            BasicContent()
        }
    }
}



@Composable
fun BasicContent(){
    val number by remember {
        mutableStateOf(Display(num1Value = "", operation = "", num2Value = ""))
    }
    var display by remember {
        mutableStateOf("=")
    }
    val isFirstValueStored = remember { mutableStateOf(true) }

    //位置
    Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Bottom) {
        //顯示已輸入的數字

        //數字1: 運算符號前
        StyleColor.DisplayText(text = number.num1Value)
        //運算符號
        StyleColor.DisplayText(text = number.operation)
        //數字2: 運算符號後
        StyleColor.DisplayText(text = number.num2Value)

        //顯示輸入文字
        StyleColor.Text(display)

        Spacer(modifier = Modifier.height(20.dp))
        //按鈕
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround
        ) {
            //當沒有選擇符號 為顯示百分位數,否則取餘數
            StyleColor.ButtonStyle("%") {
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
            StyleColor.ButtonStyle("CE") {
                display = if (number.num1Value != "") {
                    "="
                } else {
                    clearAllValues(number,isFirstValueStored)
                    "="
                }
            }
            //全部清空
            StyleColor.ButtonStyle("C") {
                clearAllValues(number, isFirstValueStored)
                display = "="
            }
            StyleColor.ButtonStyle("←") {
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
            StyleColor.ButtonStyle("⅟x") {
                val answer = Operation().operation(
                    num1 = display.substring(1).toDouble(),
                    operation= "⅟x"
                )
                display = "=$answer"
            }
            StyleColor.ButtonStyle("x²") {
                val answer = Operation().operation(
                    num1 = display.substring(1).toDouble(),
                    operation= "x²"
                )
                display = "=$answer"
            }
            StyleColor.ButtonStyle("√x") {
                //如果 display 是正數作更號 負數則會變為0以防出錯
                display = if (display.substring(1).toDouble()>0.0){
                    val answer = Operation().operation(
                        num1 = display.substring(1).toDouble(),
                        operation= "√x"
                    )
                    "=$answer"
                }else{
                    val answer = Operation().operation(
                        num1 = 0.0,
                        operation= "√x"
                    )
                    "=$answer"
                }
            }
            StyleColor.ButtonStyle("÷") {
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
            StyleColor.ButtonStyle("7", onclick = { display += "7" })
            StyleColor.ButtonStyle("8", onclick = { display += "8" })
            StyleColor.ButtonStyle("9", onclick = { display += "9" })
            StyleColor.ButtonStyle("x") {
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
            StyleColor.ButtonStyle("4", onclick = { display += "4" })
            StyleColor.ButtonStyle("5", onclick = { display += "5" })
            StyleColor.ButtonStyle("6", onclick = { display += "6" })
            StyleColor.ButtonStyle("-") {
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
            StyleColor.ButtonStyle("1", onclick = { display += "1" })
            StyleColor.ButtonStyle("2", onclick = { display += "2" })
            StyleColor.ButtonStyle("3", onclick = { display += "3" })
            //如果display 沒有數字無法啟用,當有數字時同時設定number.value的值跟operation為"+"
            StyleColor.ButtonStyle("+") {
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
            //加入正負號
            StyleColor.ButtonStyle("+/-"){
                if (display != "=") {
                    display = if (display.contains("-")) {
                        display.replace("-", "")
                    } else {
                        "=-" + display.substring(1)
                    }
                }
            }

            StyleColor.ButtonStyle("0", onclick = { display += "0" })
            //沒有小數點就加上小數點
            StyleColor.ButtonStyle(".") {
                if (display.contains(".")) {
                    display=display.replace(".", "")
                }else{
                    display += "."
                }
            }
            //需要先把文字轉成數字才能運算
            StyleColor.ButtonStyle("=") {
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


