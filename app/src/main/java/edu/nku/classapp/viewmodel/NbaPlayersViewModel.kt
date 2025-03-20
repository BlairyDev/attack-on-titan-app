package edu.nku.classapp.viewmodel

import android.R
import android.R.attr.description
import android.R.attr.name
import android.util.Log.i
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.model.NbaPlayers
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class NbaPlayersViewModel @Inject constructor(): ViewModel() {

    val players = mutableListOf<NbaPlayers>()


    private val names = listOf("Stephen", "Anthony", "Lebron", "Klay", "Kyrie");
    private val lastNames = listOf("Curry", "Edwards", "James", "Thompson", "Irving");
    private val teams = listOf(
        "Golden States Warriors",
        "Minnesota Timberwolves",
        "Los Angeles Lakers",
        "Dallas Mavericks"
    );

    private val positions =
        listOf("Shooting Guard", "Point Guard", "Small Forward", "Power Forward", "Center");

    private val signatureMoves = listOf(
        "Catch and Shoot",
        "Fadeaway",
        "Crossover",
        "Step-back",
        "Eurostep",
        "Pull-up Jumper"
    )

    private val brandDeals = listOf("Nike", "Adidas", "Reebok", "Anta", "Puma")

    private val description = listOf(
        "A versatile forward known for their athleticism, strong defense, and ability to score both inside and from beyond the arc.",
        "An explosive guard with exceptional speed, ball-handling skills, and the ability to finish at the rim under pressure.",
        "A dominant center with a powerful presence in the paint, excelling at rebounding, shot-blocking, and rim protection.",
        "A sharpshooting guard who can score from anywhere on the floor, particularly known for their deadly three-point shooting and clutch performances.",
        "A skilled point guard with elite passing vision, court awareness, and the ability to control the game with smart decision-making and leadership.")

    private val playerImages = listOf("2544","203507", "1628366", "201939", "201142", "1629029", "202681", "202691", "1641705", "1626164", "1628983")

    init {
        createPlayer()
    }

    fun fillData() = players.toList()

    fun fetchById(id: Int) = players.first { it.id == id }

    private fun createPlayer() = (0..30).map {id ->
        players.add(
            NbaPlayers (
                age = Random.Default.nextInt(1, 40),
                id = id,
                name = names.random() + " " + lastNames.random(),
                team = teams.random(),
                position = positions.random(),
                picture = "https://cdn.nba.com/headshots/nba/latest/1040x760/${playerImages.random()}.png",
                signatureMove = signatureMoves.random(),
                brandDeal = brandDeals.random(),
                description = description.random()
            )
        )
    }

}

