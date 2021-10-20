package edu.temple.desserrtapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.AdapterView



private const val ARG_PARAM1 = "param1"

class SelectionFragment : Fragment() {

    private lateinit var items: Array<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            items = it.getArray<Item>(ARG_PARAM1)!!

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_selection, container, false)

        val recyclerView  = layout.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = ImageAdapter(items)

        val dessertViewModel = ViewModelProvider(requireActivity())
            .get(DessertViewModel::class.java)

        recyclerView.setOnClickListener {
            dessertViewModel.setSelectedDessertImage()
        }

        return layout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Array<Item>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putArray<Item>(ARG_PARAM1, param1)

                }
            }
    }
}