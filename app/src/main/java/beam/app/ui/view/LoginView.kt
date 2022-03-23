package beam.app.ui.view

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import beam.app.databinding.ActivityLoginBinding
import beam.app.ui.viewmodel.ERROR
import beam.app.ui.viewmodel.LoginViewModel
import beam.app.ui.viewmodel.NAVIGATION

class LoginView : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModelLogin = loginViewModel


        /**
         * method that hide the action bar
         * this method do that action bar get black color
         * and ignore the color assigned in style.xml
         * */
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        loginViewModel.navigation.observe(this) {
            when (it) {
                NAVIGATION.GO_MAIN_VIEW -> {
                    Toast.makeText(this, "MAIN VIEW", Toast.LENGTH_SHORT).show()
                }
                NAVIGATION.GO_REGISTER_VIEW -> {
                    Toast.makeText(this, "Go Register", Toast.LENGTH_SHORT).show()
                }
            }
        }

        loginViewModel.error.observe(this) {
            if (it != null) {
                when (it) {
                    ERROR.EMPTY_FORM -> {
                        Toast.makeText(this, "Empty form", Toast.LENGTH_SHORT).show()
                    }
                    ERROR.ERROR_EMAIL -> {
                        Toast.makeText(this, "Email format is incorrect", Toast.LENGTH_SHORT).show()
                    }
                    ERROR.EMPTY_PASSWORD -> {
                        Toast.makeText(this, "Password empty", Toast.LENGTH_SHORT).show()
                    }
                    ERROR.EMPTY_EMAIL -> {
                        Toast.makeText(this, "Password empty", Toast.LENGTH_SHORT).show()
                    }
                    ERROR.WRONG_CREDENTIALS -> {
                        Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    }
}