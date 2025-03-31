package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterDetailBinding
import edu.nku.classapp.viewmodel.AttackOnTitanCharacterViewModel

class AttackOnTitanDetailFragment : Fragment(){
    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding
        get() = _binding!!

    private val attackOnTitanViewModel: AttackOnTitanCharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)


        if(arguments != null){


//            val character = attackOnTitanViewModel.fetchById(
//                requireArguments().getInt(BUNDLE_ID)
//            )
//            Glide.with(binding.root).load(character.picture).into(binding.playerImageDetail)
//            binding.playerNameDetail.text = binding.root.context.getString(R.string.name, character.name)
//            binding.playerAgeDetail.text = binding.root.context.getString(R.string.age, character.age)
//            binding.playerTeamDetail.text = binding.root.context.getString(R.string.team, character.team)
//            binding.playerPositionDetail.text = binding.root.context.getString(R.string.position, character.position)
//            binding.playerSignatureDetail.text = binding.root.context.getString(R.string.signature_moves, character.signatureMove)
//            binding.playerBrandDealsDetail.text = binding.root.context.getString(R.string.brand_deals, character.brandDeal)
//            binding.playerDescriptionDetail.text = binding.root.context.getString(R.string.description, character.description)


        }



        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "player_id"

        fun newInstance(id: Int) = AttackOnTitanDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }

}