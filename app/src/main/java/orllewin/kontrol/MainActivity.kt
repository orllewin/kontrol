package orllewin.kontrol

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import orllewin.kontrol.datastore.Shortcut
import orllewin.kontrol.presentation.edit.EditShortcut
import orllewin.kontrol.presentation.empty.Empty
import orllewin.kontrol.ui.theme.KontrolTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: KontrolViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KontrolTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "shortcuts") {
                        composable("shortcuts") { Shortcuts(viewModel, navController) }
                        composable("edit/{shortcutId}", arguments = listOf(navArgument("shortcutId"){})){ backstackEntry ->
                            EditShortcut(viewModel, backstackEntry.arguments?.getString("shortcutId")) }
                        composable("create", arguments = listOf(navArgument("shortcutId"){})){ backstackEntry ->
                            EditShortcut(viewModel) }
                    }
                }
            }
        }
    }
}

@Composable
fun Shortcuts(viewModel: KontrolViewModel, navController: NavHostController){
    val groupsState by remember(viewModel) {
        viewModel.groupsFlow
    }.collectAsState(listOf())

    if(groupsState.isNullOrEmpty()){
        Empty(navController)
    }else {
        LazyVerticalGrid(
            modifier = Modifier.padding(top = 4.dp, start = 4.dp, end = 4.dp),
            columns = GridCells.Fixed(2)
        ) {
            groupsState?.forEach { group ->
                item(span = { GridItemSpan(2) }) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 16.dp),
                            text = group.shortcutGroup.title
                        )
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(Icons.Filled.MoreVert, stringResource(id = R.string.edit_group))
                        }
                    }
                }
                items(group.shortcuts.size) { shortcutIndex ->
                    ShortcutTile(
                        navController,
                        group.shortcuts[shortcutIndex]
                    ) { shortcut: Shortcut ->
                        viewModel.execute(shortcut)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortcutTile(
    navController: NavHostController,
    shortcut: Shortcut,
    onClick: (shortCut: Shortcut) -> Unit
){
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

                    navController.navigate("edit/${shortcut.shortcutId}")
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
//        shortcut.icon?.let { imageVector ->
//            Icon(
//                modifier = Modifier
//                    .align(Alignment.TopStart)
//                    .padding(16.dp),
//                imageVector = imageVector,
//                contentDescription = stringResource(id = R.string.shortcut_icon),
//            tint = MaterialTheme.colorScheme.onPrimary)
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShortcutTilePreview() {
    KontrolTheme {
        //ShortcutTile(Shortcut.Get("Hello, World", "#ff00cc", ""))
    }
}