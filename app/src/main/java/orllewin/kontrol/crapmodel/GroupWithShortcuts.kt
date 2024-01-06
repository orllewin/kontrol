package orllewin.kontrol.crapmodel

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class GroupWithShortcuts (
    @Embedded val group: Group,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "shortcutId",
        associateBy = Junction(GroupShortcutCrossReference::class)
    )
    val shortcuts: List<Shortcut>
)