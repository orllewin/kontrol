package orllewin.kontrol.repository

import kotlinx.coroutines.flow.Flow
import orllewin.kontrol.datastore.Shortcut
import orllewin.kontrol.datastore.ShortcutDao
import orllewin.kontrol.datastore.ShortcutGroupDao
import javax.inject.Inject

class ShortcutsRepositoryImpl @Inject
constructor(
    private val shortcutsDao: ShortcutDao,
    private val groupsDao: ShortcutGroupDao
): ShortcutsRepository {
    override suspend fun getGroups(): Flow<Groups> {
        return groupsDao.getAllGroupsWithShortcuts()
    }

    override suspend fun insertShortcuts(vararg shortcuts: Shortcut) {
        shortcutsDao.insertShortcuts(*shortcuts)
    }
}