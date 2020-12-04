package com.dvach.lab2.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.dvach.lab2.MainActivity
import com.dvach.lab2.models.objRetrofit
import com.dvach.lab2.pojo.UserLoginForm
import com.dvach.lab2.recyclerAdapter.InputValidation
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragmentModel {
    lateinit var sPref: SharedPreferences

    suspend fun login(context: Context, activity: Activity, form: UserLoginForm): Boolean {

        val user = withContext(Dispatchers.IO) {
            try {
                objRetrofit.createRetrofit(context, activity)
                    .loginUser(form)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }
        return if (user != null) {
            saveText(user.api_token, activity)
            true
        } else false

    }

    private fun saveText(token: String, activity: Activity) {
        sPref = activity.getSharedPreferences("kek", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString("token", token)
        ed.apply()
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }
}