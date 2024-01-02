package orllewin.kontrol

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import orllewin.kontrol.datasource.ShortcutDatasource
import orllewin.kontrol.model.Shortcut
import orllewin.kontrol.repository.ShortcutRepository
import orllewin.kontrol.ui.theme.KontrolTheme

class MainActivity : ComponentActivity() {

    val viewModel: KontrolViewModel = KontrolViewModel(ShortcutRepository(ShortcutDatasource()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KontrolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Shortcuts(viewModel)
                    //Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Shortcuts(viewModel: KontrolViewModel){
    val shortcutsState by remember(viewModel) {
        viewModel.shortcuts
    }.collectAsState(listOf())

    LazyVerticalGrid(
        modifier = Modifier.padding(top = 4.dp, start = 4.dp, end = 4.dp),
        columns = GridCells.Fixed(2)
    ) {
        shortcutsState.forEach { group ->
            item(span = { GridItemSpan(2) }){
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 16.dp),
                        text = group.title)
                    IconButton(
                        onClick = {}
                    ){
                        Icon(Icons.Filled.MoreVert, stringResource(id = R.string.edit_group))
                    }
                }
            }
            items(group.shortcuts.size) { shortcutIndex ->
                ShortcutTile(group.shortcuts[shortcutIndex]) { shortcut ->
                    viewModel.execute(shortcut)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortcutTile(shortcut: Shortcut, onClick:(shortCut: Shortcut) -> Unit){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(6.dp)
    ){
        Box(modifier = Modifier
            .aspectRatio(1.5f)
            .clip(RoundedCornerShape(12))
            .background(MaterialTheme.colorScheme.primary)
            .padding(6.dp)
            .combinedClickable(
                onClick = {
                    onClick(shortcut)
                    Toast
                        .makeText(context, "Execute: ${shortcut.title}", Toast.LENGTH_SHORT)
                        .show()
                },
                onLongClick = {
                    Toast
                        .makeText(context, "Edit: ${shortcut.title} (not implemented)", Toast.LENGTH_SHORT)
                        .show()
                },
                onLongClickLabel = stringResource(R.string.edit_shortcut)
            ),

            ) {
        }
        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(16.dp),
            text = shortcut.title,
            color = MaterialTheme.colorScheme.onPrimary
        )
        shortcut.icon?.let { imageVector ->
            Icon(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
                imageVector = imageVector,
                contentDescription = stringResource(id = R.string.shortcut_icon),
            tint = MaterialTheme.colorScheme.onPrimary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShortcutTilePreview() {
    KontrolTheme {
        //ShortcutTile(Shortcut.Get("Hello, World", "#ff00cc", ""))
    }
}