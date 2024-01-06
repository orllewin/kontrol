package orllewin.kontrol.datastore

import androidx.room.Dao
import androidx.room.Insert
import orllewin.kontrol.datastore.Shortcut

@Dao
interface ShortcutDao {
    @Insert
    suspend fun insertShortcuts(vararg shortcuts: Shortcut)
}