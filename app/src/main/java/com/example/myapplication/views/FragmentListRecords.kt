package com.example.myapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.RepositoryAffirmations
import com.example.myapplication.databinding.FragmentListRecordsBinding
import com.example.myapplication.viewmodels.ListRecordsViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentListRecords : Fragment() {

    private var _binding: FragmentListRecordsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val viewModel by lazy { ViewModelProvider(this).get(ListRecordsViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListRecordsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val listAffirmations = RepositoryAffirmations.loadAffirmations()
        binding.recyclerView.adapter = AdapterAffirmations(requireActivity(), listAffirmations)
        binding.recyclerView.setHasFixedSize(true)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}