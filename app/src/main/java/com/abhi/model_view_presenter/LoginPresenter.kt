package com.abhi.model_view_presenter

// Presenter (Bridge):
// The presenter acts as an intermediary between the model and the view.
// It contains the business logic and orchestrates interactions between the model and the view.

class LoginPresenter(private val view: LoginView) {
    private var model: UserModel? = null

    fun login(username: String, password: String) {
        // Simulate network call or business logic
        view.showLoading()
        model = UserModel(username, password)
        if (model?.username == "admin" && model?.password == "password") {
            view.showLoginSuccessMessage()
        } else {
            view.showLoginErrorMessage()
        }
        view.hideLoading()
    }
}
