package net.oldbigbuddha.taskwallpaper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ArrayList<String>()
        )

        bt_add_task.setOnClickListener {

            if ( !TextUtils.isEmpty( et_task.text.toString() ) ) {

                adapter.add(et_task.text.toString())
                adapter.notifyDataSetChanged()

            } else {

                Snackbar.make(container, "Task is empty", Snackbar.LENGTH_SHORT).show();

            }

            et_task.setText("")

        }

        lv_task.adapter = adapter

    }
}
