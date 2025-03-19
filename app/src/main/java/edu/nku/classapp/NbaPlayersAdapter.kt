package edu.nku.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NbaPlayersAdapter(private val players: List<NbaPlayers>) :
    RecyclerView.Adapter<NbaPlayersAdapter.NbaPlayersViewHolder>() {

        private fun onPlayerClick(adapterPosition: Int) : Unit{
            players[adapterPosition]
        }

    class NbaPlayersViewHolder(
        itemView: View,
        private val onPlayerClicked: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(itemView) {

            init{
                itemView.setOnClickListener{
                    onPlayerClicked(adapterPosition)
                }
            }



        val playerImage: ImageView = itemView.findViewById(R.id.player_image)
        val playerName: TextView = itemView.findViewById(R.id.player_name)
        val playerAge: TextView = itemView.findViewById(R.id.player_age)
        val playerTeam: TextView = itemView.findViewById(R.id.player_team)
        val playerPosition: TextView = itemView.findViewById(R.id.player_position)
        val playerSignatureMove: TextView = itemView.findViewById(R.id.player_signature_moves)
        val playerBrandDeal: TextView = itemView.findViewById(R.id.player_brand_deals)
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NbaPlayersViewHolder(
//        LayoutInflater.from(parent.context).inflate(
//            R.layout.players_card_view,
//            parent,
//            false
//        ),
//
//    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NbaPlayersViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.players_card_view,
            parent,
            false
        )

        return NbaPlayersViewHolder(view) { position->
            val player = players[position]

            val bundle = bundleOf(
                "picture" to player.picture,
                "name" to player.name,
                "age" to player.age,
                "team" to player.team,
                "position" to player.position,
                "signature" to player.signatureMove,
                "brand" to player.brandDeal,
                "description" to player.description

                //this is the assignment just add more in the bundle
            )

            val detailFragment = NbaPlayersDetailFragment()

            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = players.size

    override fun onBindViewHolder(holder: NbaPlayersViewHolder, position: Int) {
        val player = players[position]

        holder.playerName.text = holder.itemView.context.getString(R.string.name, player.name)
        holder.playerAge.text = holder.itemView.context.getString(R.string.age, player.age)

        holder.playerTeam.text = holder.itemView.context.getString(R.string.team, player.team)
        holder.playerPosition.text = holder.itemView.context.getString(R.string.position, player.position)
        //holder.playerImage.setImageResource(player.picture)


        Glide.with(holder.itemView.context)
            .load(player.picture)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.playerImage)

        holder.playerSignatureMove.text = holder.itemView.context.getString(R.string.signature_moves, player.signatureMove)
        holder.playerBrandDeal.text = holder.itemView.context.getString(R.string.brand_deals, player.brandDeal)
    }
}