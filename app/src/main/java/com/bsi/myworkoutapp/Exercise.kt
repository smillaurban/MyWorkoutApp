package com.bsi.myworkoutapp

data class Exercise(
    val name: String,
    val description: String,
    val imageRes: Int // Drawable-Ressourcen-ID
)

val exercisesWorkout1 = listOf(
    Exercise("Hampelmann", "Arme und Beine seitlich spreizen und wieder schließen", R.drawable.hampelmann),
    Exercise("Kniebeuge", "In die Hocke gehen und wieder aufrichten", R.drawable.kniebeuge),
    Exercise("Liegestütz", "Mit gestrecktem Körper absenken und hochdrücken", R.drawable.liegestuetz),
    Exercise("Ausfallschritt", "Einen großen Schritt nach vorne machen und absenken", R.drawable.ausfallschritt),
    Exercise("Plank", "Unterarmstütz halten", R.drawable.plank),
)
val exercisesWorkout2 = listOf(
    Exercise("Bergsteiger", "Im Stütz abwechselnd Knie zur Brust ziehen", R.drawable.bergsteiger),
    Exercise("Burpees", "In die Hocke, Liegestütz, dann Strecksprung", R.drawable.burpees),
    Exercise("Crunches", "Oberkörper aus Rückenlage anheben", R.drawable.crunches),
    Exercise("Seitstütz rechts", "Seitlich auf dem rechten Unterarm abstützen", R.drawable.seitstuetz),
    Exercise("Seitstütz links", "Seitlich auf dem linken Unterarm abstützen", R.drawable.seitstuetz),
)
val exercisesWorkout3 = listOf(
    Exercise("Trizeps-Dips", "Mit den Armen auf Stuhl absenken und hochdrücken", R.drawable.trizeps_dips),
    Exercise("High Knees", "Im Stand abwechselnd Knie hochziehen", R.drawable.high_knees),
    Exercise("Butt Kicks", "Im Stand Fersen zum Gesäß führen", R.drawable.butt_kicks),
    Exercise("Superman", "Bauchlage, Arme und Beine anheben", R.drawable.superman),
    Exercise("Russian Twist", "Im Sitzen Oberkörper seitlich drehen", R.drawable.russian_twist),
)
val exercisesWorkout4 = listOf(
    Exercise("Wandsitzen", "Mit dem Rücken an der Wand in Sitzposition halten", R.drawable.wandsitzen),
    Exercise("Ausfallschritt rückwärts", "Einen Schritt rückwärts machen und absenken", R.drawable.ausfallschritt_rueckwaerts),
    Exercise("Fahrrad-Crunches", "Im Liegen Beine radelnd bewegen, Ellbogen zum Knie", R.drawable.fahrrad_crunches),
    Exercise("Schulterbrücke", "Becken aus Rückenlage anheben", R.drawable.schulterbruecke),
    Exercise("Jump Squats", "Kniebeuge mit Sprung nach oben", R.drawable.jump_squats),
)
val exercisesWorkout5 = listOf(
    Exercise("Seitliche Ausfallschritte", "Abwechselnd zur Seite ausfallschreiten", R.drawable.seitliche_ausfallschritte),
    Exercise("Unterarmstütz mit Beinheben", "Im Plank abwechselnd Beine anheben", R.drawable.unterarmstuetz_beinheben),
    Exercise("Skater Jumps", "Seitlich von einem Bein aufs andere springen", R.drawable.skater_jumps),
    Exercise("Reverse Crunches", "Beine aus Rückenlage zum Oberkörper ziehen", R.drawable.reverse_crunches),
    Exercise("Flutter Kicks", "Im Liegen Beine abwechselnd auf und ab bewegen", R.drawable.flutter_kicks)
)
