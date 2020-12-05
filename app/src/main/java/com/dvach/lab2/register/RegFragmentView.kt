package com.dvach.lab2.register

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.MainActivity
import com.dvach.lab2.R
import com.dvach.lab2.recyclerAdapter.InputValidation
import com.dvach.lab2.pojo.UserRegistrationForm
import kotlinx.android.synthetic.main.fragment_reg.*

class RegFragmentView : Fragment(), RegInteface.View {
    lateinit var sPref: SharedPreferences
    lateinit var presenter:RegInteface.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reg, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegFragmentPresenter(this@RegFragmentView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addUserBtn.setOnClickListener {
            presenter.onAddUserBtn()
        }

        loginTextView.setOnClickListener {
            presenter.onLoginTextView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun startMainActivity() {
        val i = Intent(requireContext(), MainActivity::class.java)
        startActivity(i)
    }

    override fun getEmail(): String {
        return emailText.text.toString()
    }

    override fun showError() {
        Toast.makeText(requireContext(), "Повторите позднее", Toast.LENGTH_SHORT).show()
    }

    override fun showEmailError() {
        Toast.makeText(requireContext(), "Пользователь с таким email уже существует", Toast.LENGTH_SHORT).show()
    }
    override fun getContext(): Context {
        return requireContext()
    }

    override fun getActivityF(): FragmentActivity {
        return requireActivity()
    }

    override fun createRegForm(): UserRegistrationForm {
        return UserRegistrationForm(
            emailText.text.toString(),
            nameText.text.toString(),
            passwordText.text.toString()
        )
    }

    override fun validation(): Boolean {
        var validation = InputValidation(requireContext())
        return (validation.isInputEditTextEmail(
            emailText,
            emaiInputLayout,
            "Неправильный e-mail"
        ) && validation.isInputEditTextFilled(
            nameText,
            textInputLayout2,
            "Введите свое имя"
        )
                && validation.isInputEditTextFilled(
            passwordText,
            textInputLayout3,
            "Введите пароль"
        ) && validation.isInputEditTextFilled(
            repasswordEditText,
            textInputLayout4,
            "Повторите пароль"
        )
                && validation.isInputEditTextMatches(
            passwordText,
            repasswordEditText,
            textInputLayout4,
            "Пароли не совпадают"
        ))
    }

    override fun navigateToLoginFragment() {
        val action = RegFragmentViewDirections.actionRegToLogin()
        findNavController().navigate(action)
    }


}
