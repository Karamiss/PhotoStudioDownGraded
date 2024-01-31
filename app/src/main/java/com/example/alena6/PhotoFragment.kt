package com.example.alena6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.alena6.databinding.FragmentOrderFormBinding
import com.example.alena6.magazine.domen.model.ItemModel

class PhotoFragment : Fragment() {
    private var _binding: FragmentOrderFormBinding? = null
    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderFormBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photo = arguments?.getParcelable<ItemModel>("photo")


        if (photo != null) {
            Glide.with(this)
                .load(photo.photoUrl)
                .transform()
                .into(binding.imageView2)
        }

    }


}