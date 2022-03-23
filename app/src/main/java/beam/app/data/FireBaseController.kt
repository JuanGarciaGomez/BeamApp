package beam.app.data

import beam.app.ui.model.LoginModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireBaseController {

    private var instance = FirebaseAuth.getInstance()

    fun auth(model: LoginModel, success: () -> Unit, error: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            instance.signInWithEmailAndPassword(model.email, model.password).addOnCompleteListener {
                if (it.isSuccessful) success.invoke()
                else error.invoke("Auth Error")
            }
        }
    }

    fun hasSession(): Boolean {
        return instance.currentUser != null
    }

    fun signOut(success: () -> Unit) {
        instance.signOut()
        success.invoke()
    }
}
