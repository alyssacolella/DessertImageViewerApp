package edu.temple.desserrtapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class DisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val layout = inflater.inflate(R.layout.fragment_display, container, false)

        ViewModelProvider(requireActivity())
            .get(DessertViewModel::class.java)
            .getDessert()
            .observe(requireActivity(),{
                updateDisplay()
            })

    }

    private fun updateDisplay(description: String, image: Int){
        view?.findViewById<TextView>(R.id.textView)?.text = description
        view?.findViewById<ImageView>(R.id.imageView)?.setImageResource(image)
    }



}