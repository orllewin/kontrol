package orllewin.kontrol.presentation.empty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoCell
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import orllewin.kontrol.R
import orllewin.kontrol.ui.theme.KontrolTheme

@Composable
fun Empty(navController: NavHostController?){
    Box(
        modifier= Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.curlew),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.no_shortcuts)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    navController?.navigate("create")
                }
            ) {
                Text(
                    text = stringResource(id = R.string.create_a_shortcut)
                )
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmptyPreview(){
    KontrolTheme {
        Empty(null)
    }
}