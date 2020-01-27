package uz.minmax.sampledaggerapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.minmax.sampledaggerapp.data.UserModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {
    private val _signInLiveData = MutableLiveData<Unit>()
    private val _forgotPasswordLiveData = MutableLiveData<Unit>()
    private val _signUpLiveData = MutableLiveData<Unit>()
    private val _userModel = MutableLiveData<UserModel>()

    val userModel: LiveData<UserModel> = _userModel
    val signInLiveData: LiveData<Unit> = _signInLiveData
    val forgotPasswordLiveData: LiveData<Unit> = _forgotPasswordLiveData
    val signUpLiveData: LiveData<Unit> = _signUpLiveData

    fun signInClick() {
        _signInLiveData.postValue(Unit)
    }

    fun forgotPasswordClick() {
        _forgotPasswordLiveData.postValue(Unit)
    }

    fun signUpClick() {
        _signUpLiveData.postValue(Unit)
    }

}