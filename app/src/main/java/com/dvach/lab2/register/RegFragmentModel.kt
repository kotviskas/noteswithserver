package com.dvach.lab2.register

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.objRetrofit
import com.dvach.lab2.pojo.User
import com.dvach.lab2.pojo.UserRegistrationForm
import kotlinx.android.synthetic.main.fragment_reg.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegFragmentModel {
    lateinit var sPref: SharedPreferences

    private fun saveText(token: String, activity: Activity) {
        sPref = activity.getSharedPreferences("kek", Context.MODE_PRIVATE)
        val ed: SharedPreferences.Editor = sPref.edit()
        ed.putString("token", token)
        ed.apply()
    }

    suspend fun registration(form: UserRegistrationForm, context: Context, activity: Activity): Boolean {
        val user = withContext(Dispatchers.IO) {
            try {
                objRetrofit.createRetrofit(context, activity)
                    .registerUser(form)
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

    fun getUserFromDB(context: Context, emailText: String): User? {
        return AppDatabase.getDatabase(context).userDao()
            .getUserByEmail(emailText)
    }
}