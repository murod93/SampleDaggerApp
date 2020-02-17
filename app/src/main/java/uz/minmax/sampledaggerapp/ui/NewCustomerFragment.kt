package uz.minmax.sampledaggerapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

import uz.minmax.sampledaggerapp.R
import uz.minmax.sampledaggerapp.ui.viewmodel.NewCustomerViewModel

/**
 * A simple [Fragment] subclass.
 */
class NewCustomerFragment : Fragment() {

    lateinit var newCustomerViewModel: NewCustomerViewModel

    lateinit var nameView:TextInputEditText
    lateinit var passwordView:TextInputEditText
    lateinit var jobView:TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_customer, container, false)

        nameView = view.findViewById(R.id.name_input_view)
        passwordView = view.findViewById(R.id.password_input_view)
        jobView = view.findViewById(R.id.job_input_view)
        view.findViewById<Button>(R.id.btn_save).setOnClickListener {
            newCustomerViewModel.saveClick()
        }

        newCustomerViewModel = ViewModelProvider(requireActivity()).get(NewCustomerViewModel::class.java)
        newCustomerViewModel.formValid()

        newCustomerViewModel.backClick.observe(viewLifecycleOwner, Observer {

        })

        newCustomerViewModel.saveClick.observe(viewLifecycleOwner, Observer {

        })

        return view
    }
}
