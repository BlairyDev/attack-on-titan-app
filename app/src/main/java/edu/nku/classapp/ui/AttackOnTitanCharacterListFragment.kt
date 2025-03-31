package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.nku.classapp.ui.adapter.AttackOnTitanCharacterAdapter
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterListBinding
import edu.nku.classapp.viewmodel.AttackOnTitanCharacterViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AttackOnTitanCharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding
            get() = _binding!!


    private val attackOnTitanViewModel: AttackOnTitanCharacterViewModel by activityViewModels()
    private val attackOnTitanCharacterAdapter = AttackOnTitanCharacterAdapter {character, position ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, AttackOnTitanDetailFragment.newInstance(character.id))
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        setUpObservers()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = attackOnTitanCharacterAdapter
        }
        attackOnTitanViewModel.fillData()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            attackOnTitanViewModel.characters.collect { event ->
                when (event) {
                    AttackOnTitanCharacterViewModel.AttackOnTitanCharacterState.Failure -> {
                        binding.errorMessage.isVisible = true
                        binding.progressBar.isVisible = false
                        binding.recyclerView.isVisible = false
                    }
                    AttackOnTitanCharacterViewModel.AttackOnTitanCharacterState.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.recyclerView.isVisible = false
                        binding.errorMessage.isVisible = false

                    }
                    is AttackOnTitanCharacterViewModel.AttackOnTitanCharacterState.Success -> {
                        attackOnTitanCharacterAdapter.refreshData(event.characters)
                        binding.recyclerView.isVisible = true
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                    }
                }

            }
        }
    }


}