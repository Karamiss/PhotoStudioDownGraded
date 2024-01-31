package com.example.alena6.magazine.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alena6.R
import com.example.alena6.databinding.FragmentMagazineBinding
import com.example.alena6.magazine.ui.adapter.MagazineFragmentAdapter


class MagazineFragment : Fragment() {
    private lateinit var binding: FragmentMagazineBinding
    private var isLinearLayoutManager = true
    private lateinit var adapter: MagazineFragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMagazineBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.replaceButton.setOnClickListener{
            isLinearLayoutManager = !isLinearLayoutManager
            updateLayoutManager()
        }
        binding.toolbarText.text = "Магазин"
        initial()
    }
    fun initial(){
        val recyclerView = binding.recyclerview
        adapter = MagazineFragmentAdapter(clickListener = { photo ->
            val bundle = Bundle()
            bundle.putParcelable("photo", photo)
            when(photo.title){
                "Фотопечать" -> findNavController().navigate(R.id.action_magazineFragment_to_photoFragment,bundle)
                "Печать на сувенирах" -> findNavController().navigate(R.id.action_magazineFragment_to_photoFragment,bundle)
                "Печать полиграфии" -> findNavController().navigate(R.id.action_magazineFragment_to_photoFragment,bundle)
                "Печать документов" -> findNavController().navigate(R.id.action_magazineFragment_to_poligraphyFragment,bundle)
                "Произвольный заказ" -> findNavController().navigate(R.id.action_magazineFragment_to_photoFragment,bundle)
                //TODO: Дописать остальные категории
                else ->  Toast.makeText(context, "Неизвестная категория", Toast.LENGTH_SHORT).show()
            }

        })
        recyclerView.adapter = adapter
        updateLayoutManager()
        adapter.notifyDataSetChanged()
    }
    private fun updateLayoutManager() {
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = if (isLinearLayoutManager) {
            LinearLayoutManager(requireContext())
        } else {
            GridLayoutManager(requireContext(), 2)
        }
    }

}