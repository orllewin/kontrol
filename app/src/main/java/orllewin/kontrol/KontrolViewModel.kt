package orllewin.kontrol

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import orllewin.kontrol.datastore.GroupWithShortcut
import orllewin.kontrol.datastore.Shortcut
import orllewin.kontrol.repository.ShortcutsRepository
import javax.inject.Inject


@HiltViewModel
class KontrolViewModel @Inject constructor(private val repository: ShortcutsRepository): ViewModel() {

    val groupsFlow: MutableStateFlow<List<GroupWithShortcut>?> = MutableStateFlow(null)
    init {
        viewModelScope.launch {
            repository.getGroups().collect { groups ->
                groupsFlow.emit(groups)
            }
        }
    }

    fun execute(shortcut: Shortcut) {
        viewModelScope.launch {
//            if (shortcut is OGShortcut.Get){
//
//                val client = OkHttpClient()
//
//                val request: Request = Request.Builder()
//                    .url(shortcut.url)
//                    .build()
//
//                val call: Call = client.newCall(request)
//                call.enqueue(object : Callback {
//                    override fun onFailure(call: Call, e: IOException) {
//                        Log.d("Kontrol", "onFailure: ${e.toString()}")
//                    }
//
//                    override fun onResponse(call: Call, response: Response) {
//                        Log.d("Kontrol", "onResponse: ${response.toString()}")
//                    }
//                })
//            }

        }
    }
}