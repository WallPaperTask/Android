package net.oldbigbuddha.taskwallpaper.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import net.oldbigbuddha.taskwallpaper.Adapters.TaskAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = "TASKS"
    }

    private lateinit var adapter: TaskAdapter
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        toolbar_main.inflateMenu(R.menu.menu_main)

        preferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        enableEditText(et_task)
        recycler_tasks.layoutManager = LinearLayoutManager(this)

        adapter = TaskAdapter(ArrayList(), this)
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
            saveTasks()
            startActivity( Intent( this, CheckActivity::class.java ) )
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onPause() {
        saveTasks()
        super.onPause()
    }

    override fun onDestroy() {
        saveTasks()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        adapter.mTasks = loadTasks()
    }

    private fun saveTasks() {
        editor = preferences.edit()
        editor.putString(MainActivity.KEY, adapter.mTasks.toString())
        editor.apply()
    }

    private fun loadTasks(): ArrayList<String> {
        val array = ArrayList<String>()
        array.addAll(parseToArray( preferences.getString(KEY, "[No Task]") ))
        return array
    }
}

