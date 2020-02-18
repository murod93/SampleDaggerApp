package uz.minmax.sampledaggerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NewCustomerViewModel : ViewModel(){
//    private var repository:CustomerRepositoryImpl
    private val _backClick = MutableLiveData<Unit>()
    private val _saveClick = MutableLiveData<Unit>()

    val nameLiveData= MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val jobLiveData = MutableLiveData<String>()

    val backClick:LiveData<Unit> = _backClick
    val saveClick:LiveData<Unit> = _saveClick

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
//        val customerDao = AppDB.getDatabase(application).customerDao()
//        repository = CustomerRepositoryImpl(customerDao)
    }

    fun formValid():Boolean{
        val valid1 = nameLiveData.combineWith(passwordLiveData, jobLiveData){s, s2, s3 -> {
            Log.e("NewViewModel", s+" "+s2+" "+s3)
        } }
        return true
    }

    fun <T, K, R> LiveData<T>.combineWith(
        liveData: LiveData<K>,
        block: (T?, K?) -> R
    ): LiveData<R> {
        val result = MediatorLiveData<R>()
        result.addSource(this) {
            result.value = block.invoke(this.value, liveData.value)
        }
        result.addSource(liveData) {
            result.value = block.invoke(this.value, liveData.value)
        }
        return result
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

    fun saveClick()=viewModelScope.launch {
//        repository.insert(Customer())
        _saveClick.postValue(Unit)
    }

    fun backClick(){
        _backClick.postValue(Unit)
    }
}