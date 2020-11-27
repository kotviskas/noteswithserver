package com.dvach.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dvach.lab2.adapter.InputValidation
import com.dvach.lab2.models.*
import kotlinx.android.synthetic.main.fragment_reg.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegFragment : Fragment() {
    lateinit var sPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        addUserBtn.setOnClickListener {
            if (AppDatabase.getDatabase(requireContext()).userDao()
                    .getUserByEmail(emailText.text.toString()) == null
            ) {
                var validation = InputValidation(requireContext())
                if (validation.isInputEditTextEmail(
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
                    )
                ) {
                    var form = UserRegistrationForm(
                        emailText.text.toString(),
                        nameText.text.toString(),
                        passwordText.text.toString()
                    )

                    GlobalScope.launch(Dispatchers.Main) {
                        val user = withContext(Dispatchers.IO) {
                            try {
                                objRetrofit.createRetrofit().registerUser(form)
                            } catch (e: Exception) {
                                e.printStackTrace()
                                null
                            }

                        }
                        if (user!=null) saveText(user.api_token)
                        else return@launch
                    }


                    val i = Intent(requireContext(), MainActivity::class.java)

                    startActivity(i)
                }

            }
        }

        loginTextView.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
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
