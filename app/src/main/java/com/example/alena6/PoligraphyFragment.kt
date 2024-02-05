package com.example.alena6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.alena6.databinding.FragmentPolygraphyBinding
import com.example.alena6.magazine.domen.model.ItemModel
import com.example.alena6.main.MainActivity
import com.example.alena6.viewmodel.PostRequestViewModel

class PoligraphyFragment : Fragment() {
    private var _binding: FragmentPolygraphyBinding? = null
    private val binding get() = _binding!!
    private var turnColor = false

    private lateinit var viewModel: PostRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPolygraphyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (requireActivity() as MainActivity).viewModel

        binding.buttonOrder.setOnClickListener {
//            viewModel.postData(
//                binding.size.toString(), // "10x15"
//                binding.document.bindingType.toString()
//                )
            Log.d( "sfsdf", binding.size.toString())

        }
        val photo = arguments?.getParcelable<ItemModel>("photo")


        if (photo != null) {
            Glide.with(this)
                .load(photo.photoUrl)
                .transform()
                .into(binding.imageView2)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}