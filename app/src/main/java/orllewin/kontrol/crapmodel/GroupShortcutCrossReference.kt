package orllewin.kontrol.crapmodel

import androidx.room.Entity

@Entity(primaryKeys = ["groupId", "shortcutId"])
data class GroupShortcutCrossReference(
    val groupId: Int,
    val shortcutId: Int
)