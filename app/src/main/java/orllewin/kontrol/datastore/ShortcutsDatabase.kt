package orllewin.kontrol.datastore

import androidx.room.Database
import androidx.room.RoomDatabase
import orllewin.kontrol.datastore.Shortcut
import orllewin.kontrol.datastore.ShortcutDao
import orllewin.kontrol.datastore.ShortcutGroup
import orllewin.kontrol.datastore.ShortcutGroupDao

@Database(entities = [ShortcutGroup::class, Shortcut::class], version = 2)
abstract class ShortcutsDatabase: RoomDatabase() {
    abstract fun shortcutGroupDao(): ShortcutGroupDao
    abstract fun shortcutDao(): ShortcutDao
}
