import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsi.myworkoutapp.R
import kotlinx.coroutines.delay
import com.bsi.myworkoutapp.exercisesWorkout3


@Composable
fun Workout3Screen(onFinish: () -> Unit) {
    var firstCountdown by remember { mutableStateOf(10) }
    var secondCountdown by remember { mutableStateOf(5) }
    var isFirstFinished by remember { mutableStateOf(false) }
    var soundPlayed by remember { mutableStateOf(false) }
    var isDone by remember { mutableStateOf(false) }
    var round by remember { mutableStateOf(1) }
    var endSoundPlayed by remember { mutableStateOf(false) }

    // Sound-Effekte
    PlaySoundEffect(
        resId = com.bsi.myworkoutapp.R.raw.start,
        play = !isFirstFinished && !soundPlayed,
        onPlayed = { soundPlayed = true }
    )
    PlaySoundEffect(
        resId = R.raw.end,
        play = isFirstFinished && !isDone && !endSoundPlayed,
        onPlayed = { endSoundPlayed = true }
    )

    // Timer-Logik
    LaunchedEffect(isFirstFinished, isDone, round) {
        if (round <= 5) {
            if (!isFirstFinished) {
                while (firstCountdown > 0) {
                    delay(1000L)
                    firstCountdown--
                }
                isFirstFinished = true
            } else if (!isDone) {
                while (secondCountdown > 0) {
                    delay(1000L)
                    secondCountdown--
                }
                isDone = true
            }
            if (isFirstFinished && isDone && round < 5) {
                // Nächste Runde vorbereiten
                firstCountdown = 10
                secondCountdown = 5
                isFirstFinished = false
                isDone = false
                soundPlayed = false
                endSoundPlayed = false
                round++
            } else if (isFirstFinished && isDone && round == 5) {
                onFinish()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        if (!isFirstFinished) {
            val exercise = exercisesWorkout3[round - 1]
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Runde $round von 5", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(80.dp))
                Text(text = "$firstCountdown",
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    fontSize = 60.sp,)
                Spacer(modifier = Modifier.height(80.dp))
                Text(text = exercise.name, fontSize = 32.sp)
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = exercise.description,
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(id = exercise.imageRes),
                    contentDescription = "Beseeching"
                )
            }
        } else if (secondCountdown > 0) {
            Text(text = "Pause: $secondCountdown Sekunden", fontSize = 24.sp)
        } else if (round > 5) {
            Text(text = "Fertig!")
        }
    }
}


