package com.abhi.model_view_presenter

// View (UI):
// The view represents the UI components of the application and is responsible for displaying data and receiving user input.
// It should not contain any business logic.

interface LoginView {
    fun showLoading()
    fun hideLoading()
    fun showLoginSuccessMessage()
    fun showLoginErrorMessage()
}