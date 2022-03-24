package rteam.project.mainproject

import dagger.hilt.android.qualifiers.ApplicationContext
import rteam.project.mainproject.BaseViewModel.BaseViewModel

class TestViewModel:BaseViewModel() {

    fun getThings(){
        database
        retrofitService
    }
}