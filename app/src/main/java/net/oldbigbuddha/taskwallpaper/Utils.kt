package net.oldbigbuddha.taskwallpaper

import android.app.Activity
import android.content.Context
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.OnSystemUiVisibilityChangeListener
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY



// Source Disabling of EditText in android - Stack Overflow - http://bit.ly/2OcqYqe

fun disableEditText(editText: EditText) {
    editText.isFocusable = false
    editText.isEnabled = false
    editText.isCursorVisible = false
    editText.inputType = InputType.TYPE_NULL
}

fun disableImageButton(imageButton: ImageButton) {
    imageButton.isEnabled = false
    imageButton.isClickable = false

}

fun enableEditText(editText: EditText) {
    editText.isEnabled = true
    editText.inputType = InputType.TYPE_CLASS_TEXT
    editText.isCursorVisible = true
    editText.isFocusable = true
    editText.isFocusableInTouchMode = true
}

fun enableImageButton(imageButton: ImageButton) {
    imageButton.isEnabled = true
    imageButton.isClickable = true
}

// Source: [Android] アプリのタイトルバーを非表示、全画面表示にする - https://akira-watson.com/android/theme-notitlebar.html

fun hideSystemUI(activity: Activity) {
    val decorView = activity.window.decorView
    decorView.run {
        systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }

    decorView.setOnSystemUiVisibilityChangeListener { visibility ->
        // Note that system bars will only be "visible" if none of the
        // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
        if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
            Log.d("debug", "The system bars are visible")
        } else {
            Log.d("debug", "The system bars are NOT visible")
        }
    }
}

fun parseToArray(content: String): List<String> {
    val array = content.replace("[", "")
                    .replace("]", "")
    return array.split(Regex(",")).map {
        it.replaceFirst(" ", "")
    }
}