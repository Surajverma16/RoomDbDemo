package com.example.roomdbdemo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbdemo.databinding.FragmentAllUserBinding


class AllUserFragment : Fragment(), UserRecyclerViewAdapter.onClicked {

    lateinit var binding: FragmentAllUserBinding
    lateinit var viewModel: UserViewModel
    lateinit var recyclerViewAdapter: UserRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllUserBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.allUserRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val adapterS = AppDatabase.getDatabase(requireContext()).userDao().getALL()
            recyclerViewAdapter = UserRecyclerViewAdapter( this@AllUserFragment)
            adapter = recyclerViewAdapter
            recyclerViewAdapter.setData(adapterS as ArrayList<UserDataClass>)
        }

        viewModel.getUserObserver().observe(requireActivity()) {
            recyclerViewAdapter.setData(ArrayList(it))
        }

        binding.floatingButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, AddUserFragment())
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onDeleteData(data: UserDataClass) {
            viewModel.deleteUserInfo(data)
    }

    override fun onItemClicked(data: UserDataClass) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, UserDetailFragment(data))
            commit()
        }
    }
}