package orllewin.kontrol.crapdata

import kotlinx.coroutines.flow.Flow
import orllewin.kontrol.crapmodel.Group
import orllewin.kontrol.crapmodel.Shortcut

class ShortcutsRepositoryImpl (private val shortcutsDao: ShortcutsDao) : ShortcutsRepository {
    override fun getGroups(): Flow<Groups>  = shortcutsDao.getGroups()
    override fun getShortcuts(): Flow<Shortcuts>  = shortcutsDao.getShortcuts()

    override suspend fun getGroup(id: Int): Group = shortcutsDao.getGroup(id)
    override suspend fun addGroup(group: Group) = shortcutsDao.addGroup(group)
    override suspend fun updateGroup(group: Group) = shortcutsDao.updateGroup(group)
    override suspend fun deleteGroup(group: Group) = shortcutsDao.deleteGroup(group)

    override suspend fun getShortcut(id: Int): Shortcut = shortcutsDao.getShortcut(id)
    override suspend fun addShortcut(shortcut: Shortcut) = shortcutsDao.addShortcut(shortcut)
    override suspend fun updateShortcut(shortcut: Shortcut) = shortcutsDao.updateShortcut(shortcut)
    override suspend fun deleteShortcut(shortcut: Shortcut) = shortcutsDao.deleteShortcut(shortcut)
}