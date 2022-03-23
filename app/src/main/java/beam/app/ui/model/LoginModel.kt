package beam.app.ui.model

import beam.app.data.FireBaseController

data class LoginModel(var email: String, var password: String) {

    private val firebaseController = FireBaseController()

    fun auth(success: () -> Unit, error: (String) -> Unit) {
        firebaseController.auth(this, success, error)
    }


}