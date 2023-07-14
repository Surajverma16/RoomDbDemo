package com.example.roomdbdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbdemo.databinding.FragmentAbove50UsersBinding


class Above50Users : Fragment(), UserRecyclerViewAdapter.onClicked {

    lateinit var binding: FragmentAbove50UsersBinding
    lateinit var recyclerAdapter: UserRecyclerViewAdapter
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAbove50UsersBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.allUserAbove50RecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerAdapter = UserRecyclerViewAdapter( this@Above50Users)
            adapter = recyclerAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        val list = AppDatabase.getDatabase(requireContext()).userDao().getAgeAboveFifty()
        recyclerAdapter.setData(list as ArrayList<UserDataClass>)
    }

    override fun onDeleteData(data: UserDataClass) {
    }

    override fun onItemClicked(data: UserDataClass) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, UserDetailFragment(data))
            commit()
        }
    }

}