package edu.nku.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NbaPlayersAdapter(private val players: List<NbaPlayers>) :
    RecyclerView.Adapter<NbaPlayersAdapter.NbaPlayersViewHolder>() {

    class NbaPlayersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val playerImage: ImageView = itemView.findViewById(R.id.player_image)
        val playerName: TextView = itemView.findViewById(R.id.player_name)
        val playerAge: TextView = itemView.findViewById(R.id.player_age)
        val playerTeam: TextView = itemView.findViewById(R.id.player_team)
        val playerPosition: TextView = itemView.findViewById(R.id.player_position)
        val playerSignatureMove: TextView = itemView.findViewById(R.id.player_signature_moves)
        val playerBrandDeal: TextView = itemView.findViewById(R.id.player_brand_deals)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NbaPlayersViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.players_card_view,
            parent,
            false
        )
    )

    override fun getItemCount() = players.size

    override fun onBindViewHolder(holder: NbaPlayersViewHolder, position: Int) {
        val player = players[position]
        holder.playerName.text = player.name
        holder.playerAge.text = player.age.toString()
        holder.playerTeam.text = player.team
        holder.playerPosition.text = player.position
        holder.playerImage.setImageResource(player.picture)
        holder.playerSignatureMove.text = player.signatureMove
        holder.playerBrandDeal.text = player.brandDeal
    }
}