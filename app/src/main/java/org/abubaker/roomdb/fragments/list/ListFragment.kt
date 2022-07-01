package org.abubaker.roomdb.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.abubaker.roomdb.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {

            binding.rvList.layoutManager = LinearLayoutManager(this.context)

            val action = ListFragmentDirections.actionItemListFragmentToAddItemFragment(
                // getString(R.string.add_fragment_title)
            )

            this.findNavController().navigate(action)
        }
    }

}