package com.entenses.sesnethsilgne.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.entenses.sesnethsilgne.R
import com.entenses.sesnethsilgne.databinding.FragmentMoreBinding
import com.entenses.sesnethsilgne.domain.ChangeTitleActionBar
import com.entenses.sesnethsilgne.domain.models.Lesson

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Lesson>("lesson")?.let {
            binding.textInfo.text = it.content
            (activity as ChangeTitleActionBar).setNewTitle(it.label)
            (activity as ChangeTitleActionBar).setBackButtonVisibility(true)
        }

    }
}