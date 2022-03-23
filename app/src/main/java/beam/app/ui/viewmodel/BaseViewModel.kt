package beam.app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * This open class is the base for all project because inside there are
 * variables with live data*
 */
open class BaseViewModel : ViewModel() {
    val error : MutableLiveData<ERROR> = MutableLiveData(null)
    val success : MutableLiveData<SUCCESS> = MutableLiveData(null)
    val navigation : MutableLiveData<NAVIGATION> = MutableLiveData(null)
    //val firebaseController = FireBaseController()
}

enum class ERROR{
    EMPTY_FORM,
    WRONG_CREDENTIALS,
    EMPTY_PASSWORD,
    ERROR_EMAIL,
    EMPTY_EMAIL

}

enum class SUCCESS{
    LOGIN_SUCCESS,
    FINGER_ACCESS,
    REGISTER_SUCCESS,
    CLOSE_SUCCESS,
    DATE_PICKER,
    ADD_SUCCESS
}

enum class NAVIGATION{
    GO_MAIN_VIEW,
    GO_REGISTER_VIEW,
    GO_LOGIN_VIEW,
    GO_ADD_TAP_SUCCESS,
    GO_LOGOUT_VIEW
}