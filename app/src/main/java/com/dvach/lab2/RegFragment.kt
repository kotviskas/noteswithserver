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
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.MD5Hash
import com.dvach.lab2.models.User
import kotlinx.android.synthetic.main.fragment_reg.*

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
        var user = User()

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

                    user.email = emailText.text.toString();
                    user.userName = nameText.text.toString();

                    user.password = MD5Hash.toMD5Hash(passwordText.text.toString())
                    AppDatabase.getDatabase(requireContext()).userDao().insert(user)
                    user = AppDatabase.getDatabase(requireContext()).userDao().getUserByEmail(user.email!!)!!
                    saveText()
                    val i = Intent(requireContext(), MainActivity::class.java)
                    i.putExtra("user", user)
                    startActivity(i)
                }
            }
        }

        loginTextView.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }

    fun saveText() {
        sPref = requireActivity().getSharedPreferences("kek", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString("userEmail", emailText.text.toString())
        ed.putString("userPassword", passwordText.text.toString())
        ed.apply()
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }
}
