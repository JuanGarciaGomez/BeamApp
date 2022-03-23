package beam.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import beam.app.ui.model.LoginModel
import beam.app.utils.Utils
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {

    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val version: MutableLiveData<String> = MutableLiveData()

    fun login() {
        viewModelScope.launch {
            val emailLogin = email.value ?: ""
            val passwordLogin = password.value ?: ""
            val utils = Utils()
            try {
                if (emailLogin.isEmpty() && passwordLogin.isEmpty()) error.value = ERROR.EMPTY_FORM
                else if (passwordLogin.isEmpty()) error.value = ERROR.EMPTY_PASSWORD
                else if (emailLogin.isEmpty()) error.value = ERROR.EMPTY_EMAIL
                else if (!utils.isEmailValid(emailLogin)) error.value = ERROR.ERROR_EMAIL
                else {
                    navigation.value = NAVIGATION.GO_MAIN_VIEW
                    success.value = SUCCESS.LOGIN_SUCCESS
                    val model = LoginModel(emailLogin, passwordLogin)
                    model.auth({
                        success.value = SUCCESS.LOGIN_SUCCESS
                    }, {
                        error.value = ERROR.WRONG_CREDENTIALS
                    })
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun register() {
        navigation.value = NAVIGATION.GO_REGISTER_VIEW
    }


}