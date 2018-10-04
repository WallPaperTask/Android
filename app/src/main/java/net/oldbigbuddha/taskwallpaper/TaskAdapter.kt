package net.oldbigbuddha.taskwallpaper

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.task_item.view.*

class TaskAdapter(
        private val mTasks: ArrayList<Task>,
        private val mContext: Context
): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun getItemCount(): Int = mTasks.size

    fun addTask(task: Task) {
        mTasks.add(0, task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.task_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTask.text = mTasks[position].mTaskName
        holder.btRemoveItem.setOnClickListener {
            mTasks.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTask: TextView = view.tv_task
        val btRemoveItem: ImageButton = view.bt_remove_item
    }
}