package orllewin.kontrol.crapdata

import androidx.room.Database
import androidx.room.RoomDatabase
import orllewin.kontrol.crapmodel.Group
import orllewin.kontrol.crapmodel.GroupShortcutCrossReference
import orllewin.kontrol.crapmodel.Shortcut

@Database(entities = [Shortcut::class, Group::class, GroupShortcutCrossReference::class], version = 1, exportSchema = false)
abstract class ShortcutsDatabase: RoomDatabase() {
    abstract val shortcutDao: ShortcutsDao
}