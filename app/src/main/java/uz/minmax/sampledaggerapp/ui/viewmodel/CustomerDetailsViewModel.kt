package uz.minmax.sampledaggerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.minmax.sampledaggerapp.data.models.Customer

class CustomerDetailsViewModel : ViewModel(){
    private val _backClick=MutableLiveData<Unit>()
    val backClick:LiveData<Unit>
        get() = _backClick
    private val _editClick=MutableLiveData<Unit>()
    val editClick:LiveData<Unit>
        get() = _editClick

    private val _deleteClick = MutableLiveData<Unit>()
    val deleteClick:LiveData<Unit>
        get() = _deleteClick

    private val _customer=MutableLiveData<Customer>()
    val customer:LiveData<Customer>
        get() = _customer

    fun backClick(){
        _backClick.postValue(Unit)
    }

    fun editClick(){
        _editClick.postValue(Unit)
    }

    fun deleteClick(){
        _deleteClick.postValue(Unit)
    }
}