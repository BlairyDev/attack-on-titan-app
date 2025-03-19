package edu.nku.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class NbaPlayersDetailFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_players_detail, container, false)


        if(arguments != null){
            val image = requireArguments().getString("picture")
            val imageView = view.findViewById<ImageView>(R.id.player_image_detail)

            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val team = requireArguments().getString("team")
            val position = requireArguments().getString("position")
            val signature = requireArguments().getString("signature")
            val brand = requireArguments().getString("brand")
            val description = requireArguments().getString("description")

            Glide.with(view)
                .load(image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

            view.findViewById<TextView>(R.id.player_name_detail).text = getString(R.string.name, name)
            view.findViewById<TextView>(R.id.player_age_detail).text = getString(R.string.age, age)
            view.findViewById<TextView>(R.id.player_team_detail).text = getString(R.string.team, team)
            view.findViewById<TextView>(R.id.player_position_detail).text = getString(R.string.position, position)
            view.findViewById<TextView>(R.id.player_signature_detail).text = getString(R.string.signature_moves, signature)
            view.findViewById<TextView>(R.id.player_brand_deals_detail).text = getString(R.string.brand_deals, brand)
            view.findViewById<TextView>(R.id.player_description_detail).text = getString(R.string.description, description)

            //add more example: val name
        }



        return view
    }

//    companion object {
//        const val BUNDLE_NAME = "NAME"
//    }

    //Next class we will learn view binding to fix the bad practice of if(arguments != null)
}