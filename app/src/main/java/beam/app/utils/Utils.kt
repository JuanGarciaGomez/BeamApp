package beam.app.utils

class Utils {

    fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return emailRegex.toRegex().matches(email)
    }

    fun isPasswordValid(password: String?): Boolean {
        val validPassword = password?.length
        return validPassword == 4
    }
}