package uz.minmax.sampledaggerapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import uz.minmax.sampledaggerapp.R
import uz.minmax.sampledaggerapp.app.App
import uz.minmax.sampledaggerapp.di.component.LoginComponent
import uz.minmax.sampledaggerapp.ui.viewmodel.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject lateinit var loginVM: LoginViewModel
    lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginComponent = (application as App).appComponent.loginComponent().create()
        loginComponent.inject(this)

        loginVM.signInLiveData.observe(this, Observer {
            Toast.makeText(this, "SignIn", Toast.LENGTH_SHORT).show()
        })
        loginVM.signUpLiveData.observe(this, Observer {
            Toast.makeText(this, "SignUp", Toast.LENGTH_SHORT).show()
        })
        loginVM.forgotPasswordLiveData.observe(this, Observer {
            Toast.makeText(this, "ForgotPassword", Toast.LENGTH_SHORT).show()
        })
        //add this to github

        //https://medium.com/swlh/basic-form-validation-in-android-with-live-data-and-data-binding-cb6b1d073717
        //https://github.com/alphamu/android-MVVM-DataBinding-FormExample/blob/master/app/src/main/java/com/alimuzaffar/testproject/ui/login/model/LoginForm.java
    }
}
