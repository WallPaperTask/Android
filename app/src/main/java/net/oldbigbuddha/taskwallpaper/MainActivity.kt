package net.oldbigbuddha.taskwallpaper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArrayList<String>())

        bt_add_task.setOnClickListener {
            val task: String? = et_task.text.toString()
            if ( !TextUtils.isEmpty(task) ) {
                adapter.add(task!!)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Empty Task", Toast.LENGTH_SHORT).show()
            }
            et_task.setText("")
        }

        lv_task.adapter = adapter
    }
}
