package com.dvach.lab2.register

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegFragmentPresenter(var view: RegFragmentView?) {
    var model = RegFragmentModel()

    fun onAddUserBtn() {
        if (model.getUserFromDB(view!!.requireContext(),view!!.getEmail()) == null
        ) {
            if (view!!.validation()) {
                GlobalScope.launch(Dispatchers.Main) {
                    val form = view!!.createRegForm()
                    if (model.registration(form, view!!.requireContext(), view!!.requireActivity())) {
                        view!!.startMainActivity()
                    }
                    else{
                        view!!.showError()
                    }
                }
            }

        }
        else {
            view!!.showEmailError()
        }
    }

    fun onLoginTextView() {
        view!!.navigateToLoginFragment()
    }

    fun onDestroy() {
        view = null
    }
}
