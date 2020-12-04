package com.dvach.lab2.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragmentPresenter(var view: LoginFragmentView?) {
    var model = LoginFragmentModel()

    fun tryToLogin() {
        if (view!!.isValidate()) {
            GlobalScope.launch(Dispatchers.Main) {
                val form = view?.createLoginForm()
                if (model.login(view!!.requireContext(), view!!.requireActivity(), form!!)) {
                    view?.startMainActivity()
                } else {
                    view?.showError()
                }
            }
        }
    }

    fun onRegisterText(){
        view?.navigateToRegFragment()
    }

    fun onDestroy() {
        view = null
    }
}