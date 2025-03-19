package edu.nku.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class NbaPlayerListFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_player_list, container, false)

        val players = mutableListOf<NbaPlayers>()
        for (i in 0..30) {
            players.add(createPlayer(i))
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = NbaPlayersAdapter(players)

        return view
    }


    private fun createPlayer(id: Int) = NbaPlayers(
        age = Random.nextInt(1, 40),
        id = id,
        name = names.random() + " " + lastNames.random(),
        team = teams.random(),
        position = positions.random(),
        picture = "https://cdn.nba.com/headshots/nba/latest/1040x760/${playerImages.random()}.png",
        //picture = "https://rickandmortyapi.com/api/character/avatar/${Random.nextInt(1, 100)}.jpeg",
        signatureMove = signatureMoves.random(),
        brandDeal = brandDeals.random(),
        description = description.random()
    )

}