package orllewin.kontrol.crapmodel

import androidx.compose.ui.graphics.vector.ImageVector
import okhttp3.RequestBody

sealed class OGShortcut(val id: String, val title: String, val icon: ImageVector?){
    class Get(id: String, title: String, icon: ImageVector?, val url: String, val queryParameters: List<Pair<String, Any>> = listOf()): OGShortcut(id, title, icon)
    class Put(id: String, title: String, icon: ImageVector?, val url: String, val queryParameters: List<Pair<String, Any>> = listOf()): OGShortcut(id, title, icon)
    class Post(id: String, title: String, icon: ImageVector?, val url: String, val queryParameters: List<Pair<String, Any>> = listOf(), val body: RequestBody? = null): OGShortcut(id, title, icon)
}
