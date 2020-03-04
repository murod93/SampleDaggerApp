package uz.minmax.sampledaggerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.minmax.sampledaggerapp.data.local.repository.CustomerRepository
import uz.minmax.sampledaggerapp.data.models.Customer
import javax.inject.Inject

class NewCustomerViewModel @Inject constructor(private val repository: CustomerRepository) : ViewModel(){
    private val _backClick = MutableLiveData<Unit>()
    private val _saveClick = MutableLiveData<Unit>()

    val nameLiveData= MutableLiveData<String>("")
    val passwordLiveData = MutableLiveData<String>("")
    val jobLiveData = MutableLiveData<String>("")

    val backClick:LiveData<Unit> = _backClick
    val saveClick:LiveData<Unit> = _saveClick

    private fun formValid(): Boolean {
//        val valid = MediatorLiveData<Boolean>().apply {
//            addSource(emailAddress) {
//                value = isFormValid(it)
//            }
//        }

        nameLiveData.combineWith(passwordLiveData, jobLiveData){ s, s2, s3 -> {
                Log.e("TTT", "$s $s2 $s3")
            }
        }

        return false
    }

    fun saveClick(name:String, password:String, job:String){
        formValid()
        viewModelScope.launch(Dispatchers.IO) {
            val customer = Customer()
            customer.name = name
            customer.password = password
            customer.job = job
            
            repository.insert(customer)
            _saveClick.postValue(Unit)
        }
    }


    fun backClick(){
        _backClick.postValue(Unit)
    }

    fun <T1, T2, T3,R> LiveData<T1>.combineWith(
        liveData: LiveData<T2>,
        liveData2:LiveData<T3>,
        block: (T1?, T2?, T3?) -> R
    ): LiveData<R> {
        val result = MediatorLiveData<R>()
        result.addSource(this) {
            result.value = block.invoke(this.value, liveData.value, liveData2.value)
        }
        result.addSource(liveData) {
            result.value = block.invoke(this.value, liveData.value, liveData2.value)
        }
        result.addSource(liveData2){
            result.value = block.invoke(this.value, liveData.value, liveData2.value)
        }
        return result
    }
}