package uz.minmax.sampledaggerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.minmax.sampledaggerapp.data.repository.CustomerRepository
import uz.minmax.sampledaggerapp.data.models.Customer
import uz.minmax.sampledaggerapp.di.scopes.ActivityScope
import javax.inject.Inject

@ActivityScope
class CustomerListViewModel @Inject constructor(customerRepository: CustomerRepository):ViewModel(){

    private val _addClick = MutableLiveData<Unit>()
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