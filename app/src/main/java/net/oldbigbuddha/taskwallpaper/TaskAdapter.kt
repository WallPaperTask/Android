package net.oldbigbuddha.taskwallpaper

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(
        private val myTasks: ArrayList<Task>,
        private val mContext: Context
): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun getItemCount(): Int = myTasks.size

    fun addTask(task: Task) {
        myTasks.add(0, task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTask.text = myTasks[position].mTaskName
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTask = view.tv_task!!
        val btRemoveItem = view.bt_remove_item
    }
}