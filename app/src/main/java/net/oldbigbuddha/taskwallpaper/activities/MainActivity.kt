package net.oldbigbuddha.taskwallpaper.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.oldbigbuddha.taskwallpaper.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        toolbar_main.inflateMenu(R.menu.menu_main)

        enableEditText(et_task)
        recycler_tasks.layoutManager = LinearLayoutManager(this)
        val adapter = TaskAdapter(ArrayList(), this)
        adapter.onItemRemoveListener = View.OnClickListener {
            if (!bt_add_task.isEnabled) {
                cover.visibility = View.INVISIBLE
                enableEditText(et_task)
                enableImageButton(bt_add_task)
                et_task.requestFocus()
            }
        }

        bt_add_task.setOnClickListener {
            if ( !TextUtils.isEmpty( et_task.text.toString() ) ) {

                val task = et_task.text.toString()
                adapter.addTask(task)

                if (adapter.itemCount >= 5) {
                    disableEditText(et_task)
                    disableImageButton(bt_add_task)
                    cover.visibility = View.VISIBLE
                }

            } else {

                Snackbar.make(container_main, "Task is empty", Snackbar.LENGTH_SHORT).show();

            }

            et_task.setText("")

        }

        recycler_tasks.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_next -> {
            startActivity( Intent( this, CheckActivity::class.java ) )
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
