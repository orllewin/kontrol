package orllewin.kontrol.repository

import kotlinx.coroutines.flow.Flow
import orllewin.kontrol.datastore.GroupWithShortcut
import orllewin.kontrol.datastore.Shortcut

typealias Shortcuts = List<Shortcut>
typealias Groups = List<GroupWithShortcut>

interface ShortcutsRepository {
    suspend fun getGroups(): Flow<Groups>
    suspend fun insertShortcuts(vararg shortcuts: Shortcut)
}