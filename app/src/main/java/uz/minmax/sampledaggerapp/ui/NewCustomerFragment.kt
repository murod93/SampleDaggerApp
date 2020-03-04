package uz.minmax.sampledaggerapp.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

import uz.minmax.sampledaggerapp.R
import uz.minmax.sampledaggerapp.ui.viewmodel.NewCustomerViewModel
import androidx.annotation.Nullable
import androidx.navigation.fragment.findNavController
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class NewCustomerFragment : Fragment() {

    @Inject lateinit var newCustomerViewModel: NewCustomerViewModel

    private lateinit var nameView:TextInputEditText
    private lateinit var passwordView:TextInputEditText
    private lateinit var jobView:TextInputEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as MainActivity).customerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_customer, container, false)

        nameView = view.findViewById(R.id.name_input_view)
        passwordView = view.findViewById(R.id.password_input_view)
        jobView = view.findViewById(R.id.job_input_view)

        view.findViewById<Button>(R.id.btn_save).setOnClickListener {
            newCustomerViewModel.saveClick(nameView.text.toString(),passwordView.text.toString(),jobView.text.toString())
        }

        newCustomerViewModel.backClick.observe(viewLifecycleOwner, Observer {

        })

        newCustomerViewModel.saveClick.observe(viewLifecycleOwner, Observer {
            findNavController().popBackStack()
        })

        return view
    }
}
