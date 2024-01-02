package orllewin.kontrol.repository

import kotlinx.coroutines.flow.Flow
import orllewin.kontrol.datasource.ShortcutDatasource
import orllewin.kontrol.model.Group

class ShortcutRepository(private val datasource: ShortcutDatasource) {

    val shortcuts: Flow<List<Group>> = datasource.shortcuts
}