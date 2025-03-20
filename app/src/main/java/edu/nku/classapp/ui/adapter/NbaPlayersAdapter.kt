package edu.nku.classapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.PlayersCardViewBinding
import edu.nku.classapp.model.NbaPlayers
import edu.nku.classapp.ui.NbaPlayersDetailFragment

class NbaPlayersAdapter(
    private val players: List<NbaPlayers>,
    private val onPlayerClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<NbaPlayersAdapter.NbaPlayersViewHolder>() {


    class NbaPlayersViewHolder(
        private val binding: PlayersCardViewBinding,
        private val onPlayerClicked: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

            init{
                itemView.setOnClickListener{
                    onPlayerClicked(adapterPosition)
                }
            }

        fun bind(player: NbaPlayers) {

            Glide.with(binding.root).load(player.picture).into(binding.playerImage)
            binding.playerName.text = binding.root.context.getString(R.string.name, player.name)
            binding.playerAge.text = binding.root.context.getString(R.string.age, player.age)
            binding.playerTeam.text = binding.root.context.getString(R.string.team, player.team)
            binding.playerPosition.text = binding.root.context.getString(R.string.position, player.position)
            binding.playerSignatureMoves.text = binding.root.context.getString(R.string.signature_moves, player.signatureMove)
            binding.playerBrandDeals.text = binding.root.context.getString(R.string.brand_deals, player.brandDeal)

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NbaPlayersViewHolder{

        val binding =
            PlayersCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NbaPlayersViewHolder(binding) { position ->
            onPlayerClicked(position)

        }


    }

    override fun getItemCount() = players.size

    override fun onBindViewHolder(holder: NbaPlayersViewHolder, position: Int) {

        val player = players[position]
        holder.bind(player)


    }
}