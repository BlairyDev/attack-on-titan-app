package edu.nku.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.CharacterCardViewBinding
import edu.nku.classapp.model.AttackOnTitanCharacterResponse

class AttackOnTitanCharacterAdapter(
    private val onCharacterClicked: (character:AttackOnTitanCharacterResponse.Character, position: Int) -> Unit) :
    RecyclerView.Adapter<AttackOnTitanCharacterAdapter.AttackOnTitanCharacterViewHolder>() {


    class AttackOnTitanCharacterViewHolder(
        private val binding: CharacterCardViewBinding,
        private val onCharacterClicked: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

            init{
                itemView.setOnClickListener{
                    onCharacterClicked(adapterPosition)
                }
            }

        fun bind(character: AttackOnTitanCharacterResponse.Character) {
            Glide.with(binding.root).load(character.img).into(binding.characterImage)
            binding.characterName.text = binding.root.context.getString(R.string.name, character.name)
            binding.characterAge.text = binding.root.context.getString(R.string.age, character.age)
            binding.characterGender.text = binding.root.context.getString(R.string.gender, character.gender)
            binding.characterResidence.text = binding.root.context.getString(R.string.residence, character.residence)
            //binding.characterBirthPlace.text = binding.root.context.getString(R.string.birth_place, character.birthplace)
            //binding.characterStatus.text = binding.root.context.getString(R.string.status, character.status)

        }

    }

    private val attackOnTitanCharacters = mutableListOf<AttackOnTitanCharacterResponse.Character>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(characters: List<AttackOnTitanCharacterResponse.Character>) {
        attackOnTitanCharacters.clear()
        attackOnTitanCharacters.addAll(characters)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttackOnTitanCharacterViewHolder{

        val binding =
            CharacterCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AttackOnTitanCharacterViewHolder(binding) { position ->
            onCharacterClicked(attackOnTitanCharacters[position], position)

        }


    }

    override fun getItemCount() = attackOnTitanCharacters.size

    override fun onBindViewHolder(holder: AttackOnTitanCharacterViewHolder, position: Int) {

        val player = attackOnTitanCharacters[position]
        holder.bind(player)


    }
}