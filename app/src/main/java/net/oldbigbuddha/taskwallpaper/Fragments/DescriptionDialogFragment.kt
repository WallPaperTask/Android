package net.oldbigbuddha.taskwallpaper.Fragments

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog

class DescriptionDialogFragment: DialogFragment() {

    lateinit var onNext: DialogInterface.OnClickListener

    companion object {
        fun newInstance() = DescriptionDialogFragment()
    }

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {

                val builder = AlertDialog.Builder(it)
                builder.setTitle("お願い")
                        .setMessage(
                                "このアプリは、あなたのロック画面にタスクをプラスするアプリです。\n" +
                                "そのために、あなたのロック画面の壁紙を変更する権限を必要とします。\n" +
                                "次にでてくるダイアログで「許可」をタップしないと、このアプリは稼働しません。")
                        .setPositiveButton("了解", onNext)
                        .setCancelable(false)


                builder.create()
            } ?: throw IllegalAccessError("Activity cannot be null")
        }
}