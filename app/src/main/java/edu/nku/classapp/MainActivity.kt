package edu.nku.classapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val players = mutableListOf<NbaPlayers>();

        for (i in 0..30) {
            players.add(createPlayers(i))
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NbaPlayersAdapter(players)
    }

    private fun createPlayers(id: Int) = NbaPlayers(
        age = Random.nextInt(1, 40),
        id = id,
        name = names.random() + " " + lastNames.random(),
        team = teams.random(),
        position = positions.random(),
        picture = R.drawable.ic_launcher_background,
        signatureMove = signatureMoves.random(),
        brandDeal = brandDeals.random(),
    )
}