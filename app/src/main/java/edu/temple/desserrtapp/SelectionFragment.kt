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
            items = (it.getParcelableArray(ARG_PARAM1) as Array<Item>)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_selection, container, false)

        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(context, 3)


        val dessertViewModel = ViewModelProvider(requireActivity())
            .get(DessertViewModel::class.java)

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            dessertViewModel.setSelectedDessert(items[itemPosition])
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)

        return layout
    }

    companion object {

        fun newInstance(param1: Array<Item>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ARG_PARAM1, param1)

                }
            }
    }
}