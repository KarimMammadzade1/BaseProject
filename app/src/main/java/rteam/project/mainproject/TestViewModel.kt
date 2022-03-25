package rteam.project.mainproject

import android.content.Context
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import rteam.project.mainproject.BaseViewModel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor():BaseViewModel() {

    fun getThings(){
        retrofitService
        database

    }
}