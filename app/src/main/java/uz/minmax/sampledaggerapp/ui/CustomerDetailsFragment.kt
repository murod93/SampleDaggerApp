package uz.minmax.sampledaggerapp.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import uz.minmax.sampledaggerapp.R
import uz.minmax.sampledaggerapp.ui.viewmodel.CustomerDetailsViewModel

/**
 * A simple [Fragment] subclass.
 */
class CustomerDetailsFragment : Fragment() {

    lateinit var viewModel:CustomerDetailsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).customerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customer_details, container, false)
        viewModel = ViewModelProvider(activity!!).get(CustomerDetailsViewModel::class.java)
        view
        return view
    }

}
