package com.entenses.sesnethsilgne.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.entenses.sesnethsilgne.R
import com.entenses.sesnethsilgne.data.LessonsData.listLessons
import com.entenses.sesnethsilgne.databinding.FragmentHomeBinding
import com.entenses.sesnethsilgne.domain.AdapterRecycler
import com.entenses.sesnethsilgne.domain.ChangeTitleActionBar
import com.entenses.sesnethsilgne.domain.models.Lesson

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val adapterRecycler by lazy {
        AdapterRecycler(listLessons, transitionToMore)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as ChangeTitleActionBar).setBackButtonVisibility(false)
        (activity as ChangeTitleActionBar).setNewTitle("All lessons")
        binding.myRecyclerView.adapter = adapterRecycler

    }

    private val transitionToMore: (Lesson) -> Unit = {
        val bundlePass = bundleOf("lesson" to it)
        findNavController().navigate(R.id.action_homeFragment_to_moreFragment, bundlePass)
    }
}