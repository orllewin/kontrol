package orllewin.kontrol.model

import androidx.compose.ui.graphics.vector.ImageVector
import okhttp3.RequestBody

sealed class Shortcut(val title: String, val icon: ImageVector?){
    class Get(title: String, icon: ImageVector?, val url: String, val queryParameters: List<Pair<String, Any>> = listOf()): Shortcut(title, icon)
    class Post(title: String, icon: ImageVector?, val url: String, val queryParameters: List<Pair<String, Any>> = listOf(), val body: RequestBody? = null): Shortcut(title, icon)
}
