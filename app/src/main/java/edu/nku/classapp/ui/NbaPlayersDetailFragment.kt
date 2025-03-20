package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentPlayerListBinding
import edu.nku.classapp.databinding.FragmentPlayersDetailBinding
import edu.nku.classapp.viewmodel.NbaPlayersViewModel

class NbaPlayersDetailFragment : Fragment(){
    private var _binding: FragmentPlayersDetailBinding? = null
    private val binding
        get() = _binding!!

    private val nbaPlayersViewModel: NbaPlayersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlayersDetailBinding.inflate(inflater, container, false)


        if(arguments != null){


            val player = nbaPlayersViewModel.fetchById(
                requireArguments().getInt(BUNDLE_ID)
            )
            Glide.with(binding.root).load(player.picture).into(binding.playerImageDetail)
            binding.playerNameDetail.text = binding.root.context.getString(R.string.name, player.name)
            binding.playerAgeDetail.text = binding.root.context.getString(R.string.age, player.age)
            binding.playerTeamDetail.text = binding.root.context.getString(R.string.team, player.team)
            binding.playerPositionDetail.text = binding.root.context.getString(R.string.position, player.position)
            binding.playerSignatureDetail.text = binding.root.context.getString(R.string.signature_moves, player.signatureMove)
            binding.playerBrandDealsDetail.text = binding.root.context.getString(R.string.brand_deals, player.brandDeal)
            binding.playerDescriptionDetail.text = binding.root.context.getString(R.string.description, player.description)


        }



        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "player_id"

        fun newInstance(id: Int) = NbaPlayersDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }

}