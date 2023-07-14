package com.example.roomdbdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbdemo.databinding.FragmentAddUserBinding

class AddUserFragment : Fragment() {

    lateinit var binding: FragmentAddUserBinding
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddUserBinding.inflate(layoutInflater,container,false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addUserButton.setOnClickListener {
            val name = binding.nameTxt.text.toString()
            val age = binding.ageTxt.text.toString()
            val gender = binding.genderTxt.text.toString()
            val dob = binding.dobTxt.text.toString()

            val user = UserDataClass(0,name,age.toInt(),gender,dob.toInt())
            viewModel.insertUserInfo(user)
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, TabFragment())
                commit()
            }
        }
    }
}