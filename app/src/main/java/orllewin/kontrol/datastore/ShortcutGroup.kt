package orllewin.kontrol.datastore

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shortcut_groups")
data class ShortcutGroup(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "shortcut_group_id")
    val shortcutGroupId: Long = 0,
    val title: String
)
