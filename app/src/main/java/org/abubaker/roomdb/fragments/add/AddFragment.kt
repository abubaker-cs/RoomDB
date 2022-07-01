package org.abubaker.roomdb.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.abubaker.roomdb.databinding.FragmentAddBinding
import org.abubaker.roomdb.model.User
import org.abubaker.roomdb.viewmodel.UserViewModel


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnAdd.setOnClickListener {

            insertDataToDatabase()

        }

    }

    private fun insertDataToDatabase() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = binding.etAge.text

        if (inputCheck(firstName, lastName, age)) {

            // Create user object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))

            // Add user to the Database
            mUserViewModel.addUser(user)

            // Confirmation
            Toast.makeText(requireContext(), "Successfully new record added", Toast.LENGTH_SHORT)
                .show()

            // Navigate back to the List view
            findNavController().navigate(
                AddFragmentDirections.actionAddItemFragmentToItemListFragment()
            )

        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(
            age
        ))
    }

}