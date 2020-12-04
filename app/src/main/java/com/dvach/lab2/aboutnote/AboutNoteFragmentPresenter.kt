package com.dvach.lab2.aboutnote

import com.dvach.lab2.pojo.Task


class AboutNoteFragmentPresenter(var view: AboutNoteFragmentView?) {

    fun onViewCreated(note: Task) {
        view?.setText(note!!)
    }

    fun onDestroy() {
        view = null
    }

    fun onGoBack(){
        view?.goBack()
    }

    fun changeImageView(note: Task){
        view?.navigateToCreateNoteFragment(note!!)
    }
}