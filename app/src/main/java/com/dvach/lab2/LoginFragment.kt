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
import com.dvach.lab2.models.UserLoginForm
import com.dvach.lab2.models.objRetrofit
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

                var form=UserLoginForm(emailText.text.toString(),passwordText.text.toString())

                GlobalScope.launch(Dispatchers.Main) {
                    val user = withContext(Dispatchers.IO) {
                        try {
                            objRetrofit.createRetrofit().loginUser(form)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            null
                        }

                    }
                    if (user!=null) {
                        saveText(user.api_token)
                        val i = Intent(requireContext(), MainActivity::class.java)
                        startActivity(i)
                    }
                    else return@launch
                }
            }

        }
        goToCreateText.setOnClickListener {
            findNavController().navigate(R.id.regFragment)
        }
    }

    fun saveText(token: String) {
        sPref = requireActivity().getSharedPreferences("kek", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString("token", token)
        ed.apply()
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }
}
