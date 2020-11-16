package com.dvach.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.adapter.InputValidation
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.MD5Hash
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {
    lateinit var sPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        loginBtn.setOnClickListener {
            var validation = InputValidation(requireContext())

            if (validation.isInputEditTextEmail(
                    emailText,
                    emaiInputLayout,
                    "Введите e-mail"
                ) && validation.isInputEditTextFilled(
                    passwordText,
                    textInputLayout3,
                    "Введите пароль"
                )
            ) {
                var user = AppDatabase.getDatabase(requireContext()).userDao()
                    .getUser(
                        emailText.text.toString(),
                        MD5Hash.toMD5Hash(passwordText.text.toString())
                    )
                if (user != null
                ) {
                    saveText()
                    val i = Intent(requireContext(), MainActivity::class.java)
                    i.putExtra("user", user)
                    startActivity(i)
                }
            }

        }
        goToCreateText.setOnClickListener {
            findNavController().navigate(R.id.regFragment)
        }
    }

    fun saveText() {
        sPref = requireActivity().getSharedPreferences("kek", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString("userEmail", emailText.text.toString())
        ed.putString("userPassword", MD5Hash.toMD5Hash(passwordText.text.toString()))
        ed.apply()
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }
}
