package orllewin.kontrol.crapmodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups_table")
data class Group(
    @PrimaryKey(autoGenerate = true) val groupId: Int,
    val title: String,
)