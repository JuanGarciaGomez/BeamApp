package beam.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData

class LoginViewModel : BaseViewModel() {

    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val version: MutableLiveData<String> = MutableLiveData()

    fun login() {
        val emailLogin = email.value ?: ""
        val passwordLogin = password.value ?: ""

        try {
            if (emailLogin.isEmpty() || passwordLogin.isEmpty()) {
                error.value = ERROR.EMPTY_FIELDS
            } else {
                navigation.value = NAVIGATION.GO_MAIN_VIEW
                success.value = SUCCESS.LOGIN_SUCCESS
                //val model = LoginModel(emailLogin,passwordLogin)

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun register() {
        navigation.value = NAVIGATION.GO_REGISTER_VIEW
    }


}