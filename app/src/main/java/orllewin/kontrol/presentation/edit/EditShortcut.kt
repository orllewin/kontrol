package orllewin.kontrol.presentation.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import orllewin.kontrol.KontrolViewModel
import orllewin.kontrol.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditShortcut(viewModel: KontrolViewModel, shortcutId: String? = null){

    var urlInput by remember { mutableStateOf("http://") }
    var selectedType by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            text = stringResource(id = R.string.new_control),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = stringResource(id = R.string.url),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = urlInput,
            onValueChange = { change ->
                urlInput = change
            },
            placeholder = {
                Text(text = "http://")
          },
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.request_type),
            style = MaterialTheme.typography.bodyLarge
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            item{
                FilterChip(
                    onClick = { selectedType = 0 },
                    label = {
                        Text("GET")
                    },
                    selected = selectedType == 0,
                    leadingIcon = if (selectedType == 0) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }
            item{
                FilterChip(
                    onClick = { selectedType = 1 },
                    label = {
                        Text("PUT")
                    },
                    selected = selectedType == 1,
                    leadingIcon = if (selectedType == 1) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }
            item{
                FilterChip(
                    onClick = { selectedType = 2 },
                    label = {
                        Text("POST")
                    },
                    selected = selectedType == 2,
                    leadingIcon = if (selectedType == 2) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }
            item{
                FilterChip(
                    onClick = { selectedType = 3 },
                    label = {
                        Text("DELETE")
                    },
                    selected = selectedType == 3,
                    leadingIcon = if (selectedType == 3) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }


        }
    }
}