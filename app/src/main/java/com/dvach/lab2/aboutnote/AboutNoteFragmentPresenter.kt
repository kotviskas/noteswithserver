package com.dvach.lab2.aboutnote

import com.dvach.lab2.pojo.Task


class AboutNoteFragmentPresenter(var view: AboutNoteFragmentInterface.View?) : AboutNoteFragmentInterface.Presenter {

    override fun onViewCreated(note: Task) {
        view?.setText(note!!)
    }

    override fun onDestroy() {
        view = null
    }

    override fun onGoBack(){
        view?.goBack()
    }

    override fun changeImageView(note: Task){
        view?.navigateToCreateNoteFragment(note!!)
    }
}