package com.dvach.lab2.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragmentPresenter(var view: LogInterface.View?) : LogInterface.Presenter {
    var model = LoginFragmentModel()

    override fun tryToLogin() {
        if (view!!.isValidate()) {
            GlobalScope.launch(Dispatchers.Main) {
                val form = view?.createLoginForm()
                if (model.login(view!!.getContextT(), view!!.getActivityF(), form!!)) {
                    view?.startMainActivity()
                } else {
                    view?.showError()
                }
            }
        }
    }

    override fun onRegisterText(){
        view?.navigateToRegFragment()
    }

    override fun onDestroy() {
        view = null
    }
}