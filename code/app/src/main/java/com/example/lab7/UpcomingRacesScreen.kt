package com.example.lab7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UpcomingRacesScreen(navController: NavController) {
    var location by remember { mutableStateOf("") }
    val races = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.testTag("backButton")) { Text("Back") }

        Spacer(Modifier.height(16.dp))
        Text("Upcoming Races", fontSize = 30.sp)
        Spacer(Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Race Location") },
                modifier = Modifier.weight(1f).testTag("locationInput")
            )

            Spacer(Modifier.width(8.dp))

            Button(
                onClick = {
                    if (location.isNotBlank()) {
                        races.add(location)
                        location = ""
                    }
                },
                modifier = Modifier.testTag("addRaceButton")
            ) { Text("Add") }
        }

        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {
            items(races) { race ->
                Spacer(Modifier.height(12.dp))
                Text(race, fontSize = 24.sp)
            }
        }
    }
}

