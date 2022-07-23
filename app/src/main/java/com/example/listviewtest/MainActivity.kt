package com.example.listviewtest

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val data = listOf("Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
        "Pineapple", "Strawberry", "Cherry", "Mango")

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        listView.adapter = adapter

        initFruits()
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        listView.adapter = adapter
        // 行点击事件
//        listView.setOnItemClickListener {parent, view, position, id ->
        // Kotlin允许我们将没有用到的参数使用下划线来替代，因此下面这种写法也是合法且更加推荐的
        // 即使将没有用到的参数使用下划线来代替，它们之间的位置是不能改变的，position参数仍然得在第三个参数的位置。
        listView.setOnItemClickListener {_, _, position, _ ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        repeat(4) {
            fruitList.add(Fruit("Apple", R.drawable.back_bg))
            fruitList.add(Fruit("Pear", R.drawable.kotlin_bean))
            fruitList.add(Fruit("Orange", R.drawable.title_bg))
        }
    }
}