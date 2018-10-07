package net.oldbigbuddha.taskwallpaper

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent

class DisableScroll: RecyclerView.OnItemTouchListener {

    // Source: RecyclerViewのスクロールの可・不可を制御する - Qiita - https://qiita.com/Horie1024/items/72742f76485d02bf1b90

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean = true

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

}