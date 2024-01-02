package orllewin.kontrol

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import orllewin.kontrol.model.Group
import orllewin.kontrol.model.Shortcut
import orllewin.kontrol.repository.ShortcutRepository
import java.io.IOException


class KontrolViewModel(private val repository: ShortcutRepository): ViewModel() {

    fun execute(shortcut: Shortcut) {
        viewModelScope.launch {
            if (shortcut is Shortcut.Get){

                val client = OkHttpClient()

                val request: Request = Request.Builder()
                    .url(shortcut.url)
                    .build()

                val call: Call = client.newCall(request)
                call.enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("Kontrol", "onFailure: ${e.toString()}")
                    }

                    override fun onResponse(call: Call, response: Response) {
                        Log.d("Kontrol", "onResponse: ${response.toString()}")
                    }
                })
            }

        }
    }

    val shortcuts: Flow<List<Group>> = repository.shortcuts


}