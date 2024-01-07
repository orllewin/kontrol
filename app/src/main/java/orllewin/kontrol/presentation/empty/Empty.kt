package orllewin.kontrol.presentation.empty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import orllewin.kontrol.R

@Composable
fun Empty(navController: NavHostController){
    Box(
        modifier= Modifier.fillMaxSize()
    ){
        Text(stringResource(id = R.string.no_shortcuts))
    }
}