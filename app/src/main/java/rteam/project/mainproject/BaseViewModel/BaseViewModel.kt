package rteam.project.mainproject.BaseViewModel

import android.content.Context
import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import rteam.project.mainproject.Retrofit.NetworkService
import rteam.project.mainproject.RoomDatabase.RoomDatabase
import javax.inject.Inject

@HiltViewModel
abstract class BaseViewModel ():ViewModel(){


    @Inject protected lateinit var database: RoomDatabase
    @Inject protected lateinit var retrofitService: NetworkService
    private val _onFailure = MutableLiveData<Failure>()
    val onFailure: LiveData<Failure> = _onFailure

    protected fun handleFailure(failure: Failure) = _onFailure.postValue(failure)



}


