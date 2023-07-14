package com.example.roomdbdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbdemo.databinding.FragmentUserDetailBinding


class UserDetailFragment(private val data: UserDataClass) : Fragment() {

    lateinit var binding: FragmentUserDetailBinding
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nameText.setText(data.name)
        binding.ageText.setText(Integer.toString(data.age))
        binding.dobText.setText(Integer.toString(data.dob))
        binding.genderText.setText(data.gender)

        binding.UpdateButton.setOnClickListener {
            val user = UserDataClass(
                data.id,
                binding.nameText.editableText.toString(),
                binding.ageText.editableText.toString().toInt(),
                binding.genderText.editableText.toString(),
                binding.dobText.editableText.toString().toInt()
            )
            viewModel.updateUserInfo(user)

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, TabFragment())
                addToBackStack(null)
                commit()
            }
        }
    }
}