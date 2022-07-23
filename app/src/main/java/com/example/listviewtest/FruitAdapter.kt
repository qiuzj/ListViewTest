package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fruit_item.view.*

// 定义了一个主构造函数，用于将Activity的实例、ListView子项布局的id和数据源传递进来
class FruitAdapter(activity: Activity, private val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    /**
     * 使用inner class关键字来定义内部类
     */
    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

    // 这个方法在每个子项被滚动到屏幕内的时候会被调用
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 使用LayoutInflater来为这个子项加载我们传入的布局
        // 第三个参数指定成false，表示只让我们在父布局中声明的layout属性生效，但不会为这个View添加父布局。
        // 因为一旦View有了父布局之后，它就不能再添加到ListView中了。
        val view: View // 布局
        val viewHold: ViewHolder // 布局中到组件
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.fruitImage
            val fruitName: TextView = view.fruitName
            viewHold = ViewHolder(fruitImage, fruitName)
            // 缓存到View中
            view.tag = viewHold
        } else { // 这个参数用于将之前加载好的布局进行缓存，以便之后进行重用，我们可以借助这个参数来进行性能优化
            view = convertView
            viewHold = view.tag as ViewHolder
        }
        // List<Fruit>在position索引对应的数据
        val fruit = getItem(position) // 获取当前项的Fruit实例
        if (fruit != null) {
            viewHold.fruitImage.setImageResource(fruit.imageId)
            viewHold.fruitName.text = fruit.name
        }
        return view
    }

    // 这个方法在每个子项被滚动到屏幕内的时候会被调用
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        // 使用LayoutInflater来为这个子项加载我们传入的布局
//        // 第三个参数指定成false，表示只让我们在父布局中声明的layout属性生效，但不会为这个View添加父布局。
//        // 因为一旦View有了父布局之后，它就不能再添加到ListView中了。
//        val view: View
//        if (convertView == null) {
//            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        } else { // 这个参数用于将之前加载好的布局进行缓存，以便之后进行重用，我们可以借助这个参数来进行性能优化
//            view = convertView
//        }
//        val fruitImage: ImageView = view.fruitImage
//        val fruitName: TextView = view.fruitName
//        // List<Fruit>在position索引对应的数据
//        val fruit = getItem(position)
//        if (fruit != null) {
//            fruitImage.setImageResource(fruit.imageId)
//            fruitName.text = fruit.name
//        }
//        return view
//    }

    // 这个方法在每个子项被滚动到屏幕内的时候会被调用
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        // 使用LayoutInflater来为这个子项加载我们传入的布局
//        // 第三个参数指定成false，表示只让我们在父布局中声明的layout属性生效，但不会为这个View添加父布局。
//        // 因为一旦View有了父布局之后，它就不能再添加到ListView中了。
//        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        val fruitImage: ImageView = view.fruitImage
//        val fruitName: TextView = view.fruitName
//        // List<Fruit>在position索引对应的数据
//        val fruit = getItem(position)
//        if (fruit != null) {
//            fruitImage.setImageResource(fruit.imageId)
//            fruitName.text = fruit.name
//        }
//        return view
//    }
}