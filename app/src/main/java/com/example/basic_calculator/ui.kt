package com.example.basic_calculator

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


/*
欠缺功能:
    可以把畫面變橫向
    轉成橫的也有可以呈現方式 <= 參考手機計算機
    長按顯示功能 <= 參考手機機算機
    音樂聲音功能
    從右往左滑 還原 , 從左往右滑 刪除

欠缺風格:


修改or優化:
    修改架構
    限制文字長度
    數字過大換成顯示科學符號
    導航列也要集中在StyleColor一起改顏色

已知道bug:
    可以讓num1 為0. 結束 (應該解決了
    按 c 需要按其他鍵才會有反應
    當按下"*"後反悔改按成"+" 要讓operation 的顯示要有及時變化(相同情況
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
    //抽屜動畫樣式
    ModalNavigationDrawer(
        drawerContent = {
            //整個抽屜內部樣式
            ModalDrawerSheet (modifier = Modifier.padding(end = 100.dp)){
                Text("設定標題", fontSize = 30.sp ,modifier = Modifier.padding(20.dp))
                Divider(thickness=2.dp, modifier = Modifier.padding(bottom= 5.dp))
                NavigationDrawerItem(
                    label = { Text(text = "基礎功能") },
                    icon = {Icon(Icons.Default.Add, contentDescription = "add")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "貨幣") },
                    icon = {Icon(Icons.Default.Add, contentDescription = "add")},
                    selected = false,
                    onClick = { /*TODO*/ },
                    colors = NavigationDrawerItemDefaults.colors( unselectedContainerColor = Color.Gray, unselectedIconColor = Color.Black)
                )
                NavigationDrawerItem(
                    label = { Text(text = "容積") },
                    icon = {Icon(Icons.Default.Add, contentDescription = "add")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "重量與質量") },
                    icon = {Icon(Icons.Default.Add, contentDescription = "add")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "溫度") },
                    icon = {Icon(Icons.Default.Add, contentDescription = "add")},
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    label = { Text(text = "配置設定") },
                    icon = {Icon(Icons.Default.Add, contentDescription = "add")},
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
        //打開後背景顏色
        scrimColor = StyleColor.backGroundColor
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




@Preview(showBackground = false)
@Composable
fun Basic_CalculatorTheme() {
    CalculatorUi()

}


