package orllewin.kontrol.ogdatasource

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeDown
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import orllewin.kontrol.crapmodel.OGGroup
import orllewin.kontrol.crapmodel.OGShortcut

import androidx.compose.material.icons.filled.Stop

class ShortcutDatasource {

    val shortcuts: Flow<List<OGGroup>> = flowOf(demoShortcuts())

    private fun demoShortcuts(): List<OGGroup>{

        return listOf(
            OGGroup("AXN10",
                listOf(
                    OGShortcut.Get("001", "Amb. Sleeping Pill", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=Netil&url=http://radio.stereoscenic.com/asp-h"),
                    OGShortcut.Get("002", "Netil", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=Netil&url=https://netilradio.out.airtime.pro/netilradio_a"),
                    OGShortcut.Get("003", "NTS 1", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=NTS1&url=http://stream-relay-geo.ntslive.net/stream"),
                    OGShortcut.Get("004", "NTS 2", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=NTS2&url=http://stream-relay-geo.ntslive.net/stream2"),
                    OGShortcut.Get("005", "Do you world!", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=DoYouWorld&url=https://doyouworld.out.airtime.pro/doyouworld_a"),
                    OGShortcut.Get("006", "UK Bass", null, "http://192.168.86.25/smoip/stream/radio?zone=ZONE1&name=UKBass&url=https://www.ukbassradio.com/stream"),
                    OGShortcut.Get("007", "Volume down", Icons.AutoMirrored.Filled.VolumeDown, "http://192.168.86.25/smoip/zone/state?zone=ZONE1&volume_percent_change=-5"),
                    OGShortcut.Get("008", "Volume up", Icons.AutoMirrored.Filled.VolumeUp, "http://192.168.86.25/smoip/zone/state?zone=ZONE1&volume_percent_change=5"),
                    OGShortcut.Get("009", "Stop", Icons.Filled.Stop, "http://192.168.86.25/smoip/zone/play_control?zone=ZONE1&action=stop"),

                )
             )
        )
    }
}