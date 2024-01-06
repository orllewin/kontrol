package orllewin.kontrol.datastore

import androidx.room.Embedded
import androidx.room.Relation

data class GroupWithShortcut(
    @Embedded val shortcutGroup: ShortcutGroup,
    @Relation(
        parentColumn = "shortcut_group_id",
        entityColumn = "shortcut_group_id"
    )
    val shortcuts: List<Shortcut>
)
