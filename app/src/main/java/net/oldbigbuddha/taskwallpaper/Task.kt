package net.oldbigbuddha.taskwallpaper

import io.realm.annotations.PrimaryKey
import java.util.*

open class Task(
        @PrimaryKey open val mId: String = UUID.randomUUID().toString(),
        open var mTaskName: String,
        open var createdAt: Date = Date()
)