package orllewin.kontrol.crapdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import orllewin.kontrol.crapmodel.Group
import orllewin.kontrol.crapmodel.GroupShortcutCrossReference
import orllewin.kontrol.crapmodel.GroupWithShortcuts
import orllewin.kontrol.crapmodel.Shortcut


//@Dao
//interface ShortcutsDao {
//
//    @Transaction
//    @Query("SELECT * FROM shortcuts_table")
//    fun getGroupsWithShortcuts(): List<GroupWithShortcuts>
//
//    //Cross refs
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertCrossReference(crossRefs: Array<GroupShortcutCrossReference>): List<Long?>?
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertCrossReference(crossReference: GroupShortcutCrossReference): Long
//
//    @Update
//    fun updateCrossReference(crossReference: GroupShortcutCrossReference): Int
//
//    @Delete
//    fun deleteCrossReference(crossReference: GroupShortcutCrossReference): Int
//
//
//    //Groups
//    @Query("SELECT * FROM groups_table ORDER BY groupId ASC")
//    fun getGroups(): Flow<Groups>
//
//    @Query("SELECT * FROM groups_table WHERE groupId = :id")
//    suspend fun getGroup(id: Int): Group
//
//    @Insert(onConflict = IGNORE)
//    suspend fun addGroup(group: Group)
//
//    @Update
//    suspend fun updateGroup(group: Group)
//
//    @Delete
//    suspend fun deleteGroup(group: Group)
//
//    //Shortcuts
//    @Query("SELECT * FROM shortcuts_table ORDER BY shortcutId ASC")
//    fun getShortcuts(): Flow<Shortcuts>
//
//    @Query("SELECT * FROM shortcuts_table WHERE shortcutId = :id")
//    suspend fun getShortcut(id: Int): Shortcut
//
//    @Insert(onConflict = IGNORE)
//    suspend fun addShortcut(shortcut: Shortcut)
//
//    @Update
//    suspend fun updateShortcut(shortcut: Shortcut)
//
//    @Delete
//    suspend fun deleteShortcut(shortcut: Shortcut)
//}