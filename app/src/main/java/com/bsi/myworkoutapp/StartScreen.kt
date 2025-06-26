package com.bsi.myworkoutapp

import Endscreen
import Workout1Screen
import Workout2Screen
import Workout3Screen
import Workout4Screen
import Workout5Screen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color


@Composable
fun MyApp() {
    val navController = rememberNavController()
    var completedWorkouts by remember { mutableStateOf(0) }
    NavHost(navController, startDestination = "start") {
        composable("start") {
            StartScreen(
                onWorkoutClick = { workoutNumber ->
                    navController.navigate("workout$workoutNumber")
                },
                completedWorkouts = completedWorkouts
            )
        }
        composable("workout1") {
            Workout1Screen(onFinish = {
                navController.navigate("end") })
        }
        composable("workout2") {
            Workout2Screen(onFinish = {
                navController.navigate("end") })
        }
        composable("workout3") {
            Workout3Screen(onFinish = {
                navController.navigate("end") })
        }
        composable("workout4") {
            Workout4Screen(onFinish = {
                navController.navigate("end") })
        }
        composable("workout5") {
            Workout5Screen(onFinish = {
                navController.navigate("end") })
        }
        composable("end") {
            Endscreen(onRestart = {
                completedWorkouts ++
                navController.navigate("start") {
                    popUpTo("start") { inclusive = true }
                }
            })
        }
    }
}

@Composable
fun StartScreen(onWorkoutClick: (Int) -> Unit,
                completedWorkouts: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to the Workout Zone!",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .align(Alignment.CenterHorizontally)
        )
        CustomProgressBar(
            progress = completedWorkouts / 5f,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "$completedWorkouts von 5 Workouts abgeschlossen",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(48.dp))
        for (i in 1..5) {
            Button(
                onClick = { onWorkoutClick(i) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Workout $i")
            }
        }
    }
}




