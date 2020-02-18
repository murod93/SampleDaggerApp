package uz.minmax.sampledaggerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.minmax.sampledaggerapp.data.local.repository.CustomerRepository
import uz.minmax.sampledaggerapp.data.models.Customer
import javax.inject.Inject

class CustomerListViewModel @Inject constructor(customerRepository: CustomerRepository):ViewModel(){

    private val _addClick = MutableLiveData<Unit>()
    var users:MutableLiveData<List<Customer>> = MutableLiveData()
    lateinit var customers:LiveData<List<Customer>>

    val addClick:LiveData<Unit> = _addClick

    init {
        viewModelScope.launch(Dispatchers.IO) {
            customers = customerRepository.getAll()
        }
    }

    fun addClick(){
        _addClick.postValue(Unit)
    }
}