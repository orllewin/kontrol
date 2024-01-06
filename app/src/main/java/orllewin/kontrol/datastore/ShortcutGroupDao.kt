package orllewin.kontrol.datastore

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface ShortcutGroupDao {
    @Insert
    suspend fun insertShortcutGroup(shortcutGroup: ShortcutGroup)

    @Transaction
    @Query("SELECT * FROM shortcut_groups")
    suspend fun getAllGroupsWithShortcuts(): Flow<List<GroupWithShortcut>>
}