package orllewin.kontrol.crapmodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shortcuts_table")
data class Shortcut(
    @PrimaryKey(autoGenerate = true) val shortcutId: Int,
    val title: String,
    val iconReference: String,
    val url: String,
    val type: Int,
    val body: String
)