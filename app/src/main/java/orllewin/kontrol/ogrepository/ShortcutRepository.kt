package orllewin.kontrol.ogrepository

import kotlinx.coroutines.flow.Flow
import orllewin.kontrol.ogdatasource.ShortcutDatasource
import orllewin.kontrol.crapmodel.OGGroup

class ShortcutRepository(private val datasource: ShortcutDatasource) {

    val shortcuts: Flow<List<OGGroup>> = datasource.shortcuts
}