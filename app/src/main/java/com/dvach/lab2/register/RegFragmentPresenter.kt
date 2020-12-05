package com.dvach.lab2.register

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegFragmentPresenter(var view: RegInteface.View?) : RegInteface.Presenter {
    var model = RegFragmentModel()

    override fun onAddUserBtn() {
        if (model.getUserFromDB(view!!.getContext(),view!!.getEmail()) == null
        ) {
            if (view!!.validation()) {
                GlobalScope.launch(Dispatchers.Main) {
                    val form = view!!.createRegForm()
                    if (model.registration(form, view!!.getContext(), view!!.getActivityF())) {
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

    override fun onLoginTextView() {
        view!!.navigateToLoginFragment()
    }

    override fun onDestroy() {
        view = null
    }
}
