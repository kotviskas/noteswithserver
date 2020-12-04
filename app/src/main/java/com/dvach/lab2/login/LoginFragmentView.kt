package com.dvach.lab2.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.MainActivity
import com.dvach.lab2.R
import com.dvach.lab2.recyclerAdapter.InputValidation
import com.dvach.lab2.pojo.UserLoginForm
import com.dvach.lab2.register.RegFragmentViewDirections
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragmentView : Fragment() {
    lateinit var presenter: LoginFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginFragmentPresenter(this@LoginFragmentView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBtn.setOnClickListener {

                presenter.tryToLogin()

        }

        goToCreateText.setOnClickListener {
            presenter.onRegisterText()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    fun navigateToRegFragment() {
        val action = LoginFragmentViewDirections.actionLoginFragmentToRegFragment()
        findNavController().navigate(action)
    }

    fun createLoginForm(): UserLoginForm {
        return UserLoginForm(
            emailText.text.toString(),
            passwordText.text.toString()
        )
    }

    fun startMainActivity() {
        val i = Intent(requireContext(), MainActivity::class.java)
        startActivity(i)
        requireActivity().finish()
    }

    fun showError() {
        Toast.makeText(requireContext(), "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
    }

    fun isValidate(): Boolean {
        val validation = InputValidation(requireContext())
        return validation.isInputEditTextEmail(
            emailText,
            emaiInputLayout,
            "Введите e-mail"
        ) && validation.isInputEditTextFilled(
            passwordText,
            textInputLayout3,
            "Введите пароль"
        )
    }


}
