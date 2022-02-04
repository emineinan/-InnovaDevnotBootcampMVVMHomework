package com.example.mvvmhomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mvvmhomework.R
import com.example.mvvmhomework.databinding.FragmentAddBinding
import com.example.mvvmhomework.viewmodel.AddViewModel
import com.example.mvvmhomework.viewmodel.factory.AddViewModelFactory

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)

        binding.addFragment = this
        binding.addToolbarTitle = "Add Task"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddViewModel by viewModels() {
            AddViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonAddClick(title: String, description: String, view: View) {
        viewModel.add(title, description)
        navigateToHome(view)
    }

    fun navigateToHome(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_addFragment_to_homeFragment)
    }
}