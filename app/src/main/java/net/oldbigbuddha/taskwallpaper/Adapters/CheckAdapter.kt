package net.oldbigbuddha.taskwallpaper.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.task_check.view.*
import net.oldbigbuddha.taskwallpaper.R

class CheckAdapter(
        private val mTasks: List<String>,
        private val mContext: Context
): RecyclerView.Adapter<CheckAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckAdapter.ViewHolder = CheckAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.task_check, parent, false))

    override fun getItemCount(): Int = mTasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTask.text = mTasks[position]
        // Bundle
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTask: TextView = view.tv_task_check
    }
}