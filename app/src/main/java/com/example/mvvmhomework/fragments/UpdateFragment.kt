package com.example.mvvmhomework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.mvvmhomework.R
import com.example.mvvmhomework.databinding.FragmentUpdateBinding
import com.example.mvvmhomework.viewmodel.UpdateViewModel
import com.example.mvvmhomework.viewmodel.factory.UpdateViewModelFactory

class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: UpdateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update, container, false)

        binding.updateFragment = this
        binding.updateToolbarTitle = "Update Task"

        val args: UpdateFragmentArgs by navArgs()
        val task = args.task
        binding.task = task

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: UpdateViewModel by viewModels() {
            UpdateViewModelFactory(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonUpdateClick(id: Int, title: String, description: String, view: View) {
        viewModel.update(id, title, description)
        navigateToHome(view)
    }

    fun navigateToHome(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_updateFragment_to_homeFragment)
    }
}
