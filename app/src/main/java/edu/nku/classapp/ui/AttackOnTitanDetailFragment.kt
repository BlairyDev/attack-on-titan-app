package edu.nku.classapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterDetailBinding
import edu.nku.classapp.model.AttackOnTitanCharacterResponse
import edu.nku.classapp.model.AttackOnTitanDetailResponse
import edu.nku.classapp.viewmodel.AttackOnTitanCharacterViewModel
import edu.nku.classapp.viewmodel.AttackOnTitanDetailViewModel
import kotlinx.coroutines.launch

class AttackOnTitanDetailFragment : Fragment(){
    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding
        get() = _binding!!

    private val attackOnTitanViewModel: AttackOnTitanDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)

        val attackOnTitanCharacter: AttackOnTitanDetailResponse


        if(arguments != null){

            attackOnTitanViewModel.fetchById(
                requireArguments().getInt(BUNDLE_ID)
            )

            lifecycleScope.launch {
                attackOnTitanViewModel.character.collect { event ->
                    when (event) {
                        AttackOnTitanDetailViewModel.AttackOnTitanDetailState.Failure -> {
                            binding.errorMessage.isVisible = true
                            binding.progressBar.isVisible = false
                            //binding.recyclerView.isVisible = false
                        }
                        AttackOnTitanDetailViewModel.AttackOnTitanDetailState.Loading -> {
                            binding.progressBar.isVisible = true
//                        binding.recyclerView.isVisible = false
                            binding.errorMessage.isVisible = false
                        }
                        is AttackOnTitanDetailViewModel.AttackOnTitanDetailState.Success -> {
                            Glide.with(binding.root).load(event.character.img).into(binding.characterImageDetail)
                            binding.characterNameDetail.text = binding.root.context.getString(R.string.name, event.character.name)
                            binding.characterAgeDetail.text = binding.root.context.getString(R.string.age, event.character.age)
                            binding.characterGenderDetail.text = binding.root.context.getString(R.string.gender, event.character.gender)
                            binding.characterResidenceDetail.text = binding.root.context.getString(R.string.residence, event.character.residence)
                            binding.characterHeightDetail.text = binding.root.context.getString(R.string.height, event.character.height)
                            binding.characterOccupationDetail.text = binding.root.context.getString(R.string.occupation, event.character.occupation)

                            //binding.recyclerView.isVisible = true
                            binding.progressBar.isVisible = false
                            binding.errorMessage.isVisible = false
                        }
                    }
                }
            }


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