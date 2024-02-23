package com.abhi.model_view_presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

// Activity/Fragment (Controller):
// The activity or fragment acts as a controller and is responsible for coordinating interactions between the view
// and the presenter.

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        progressBar = findViewById(R.id.progressBar)

        presenter = LoginPresenter(this)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            presenter.login(username, password)
        }
    }


    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showLoginSuccessMessage() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
    }

    override fun showLoginErrorMessage() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
    }
}
