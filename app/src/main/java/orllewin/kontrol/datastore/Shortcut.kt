package orllewin.kontrol.datastore

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shortcuts")
data class Shortcut(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "shortcut_id")
    val shortcutId: Long = 0,
    val title: String,
    val url: String,
    @ColumnInfo(name = "shortcut_group_id") val shortcutGroupId: Long
)
