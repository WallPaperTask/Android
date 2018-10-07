package net.oldbigbuddha.taskwallpaper

import android.text.InputType
import android.widget.EditText
import android.widget.ImageButton

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