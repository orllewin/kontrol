package orllewin.kontrol.datasource

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeDown
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import orllewin.kontrol.model.Group
import orllewin.kontrol.model.Shortcut

import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeDown

class ShortcutDatasource {

    val shortcuts: Flow<List<Group>> = flowOf(demoShortcuts())

    private fun demoShortcuts(): List<Group>{

        return listOf(
            Group("AXN10",
                listOf(
                    Shortcut.Get("Amb. Sleeping Pill", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=Netil&url=http://radio.stereoscenic.com/asp-h"),
                    Shortcut.Get("Netil", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=Netil&url=https://netilradio.out.airtime.pro/netilradio_a"),
                    Shortcut.Get("NTS 1", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=NTS1&url=http://stream-relay-geo.ntslive.net/stream"),
                    Shortcut.Get("NTS 2", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=NTS2&url=http://stream-relay-geo.ntslive.net/stream2"),
                    Shortcut.Get("Do you world!", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=DoYouWorld&url=https://doyouworld.out.airtime.pro/doyouworld_a"),
                    Shortcut.Get("UK Bass", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=UKBass&url=https://www.ukbassradio.com/stream"),
                    Shortcut.Get("Volume down", Icons.AutoMirrored.Filled.VolumeDown, "http://192.168.86.25/smoip/zone/state?zone=ZONE1&volume_percent_change=-5"),
                    Shortcut.Get("Volume up", Icons.AutoMirrored.Filled.VolumeUp, "http://192.168.86.25/smoip/zone/state?zone=ZONE1&volume_percent_change=5"),
                    Shortcut.Get("Stop", Icons.Filled.Stop, "http://192.168.86.25/smoip/zone/play_control?zone=ZONE1&action=stop"),

                )
             )
        )
    }
}