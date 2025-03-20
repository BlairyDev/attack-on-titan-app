package edu.nku.classapp.ui

import android.R.attr.description
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.nku.classapp.ui.adapter.NbaPlayersAdapter
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentPlayerListBinding
import edu.nku.classapp.model.NbaPlayers
import edu.nku.classapp.viewmodel.NbaPlayersViewModel
import kotlin.random.Random

class NbaPlayerListFragment : Fragment() {

    private var _binding: FragmentPlayerListBinding? = null
    private val binding
            get() = _binding!!


    private val nbaPlayersViewModel: NbaPlayersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPlayerListBinding.inflate(inflater, container, false)

        val players = nbaPlayersViewModel.fillData()

        val adapter = NbaPlayersAdapter(players) { position ->
            val player = players[position]
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container_view,
                    NbaPlayersDetailFragment.newInstance(player.id)
                )
                addToBackStack(null)
            }
        }



        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }


        return binding.root
    }




}