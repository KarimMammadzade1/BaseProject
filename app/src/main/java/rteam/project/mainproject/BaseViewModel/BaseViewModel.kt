package rteam.project.mainproject.BaseViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Retrofit
import rteam.project.mainproject.Retrofit.NetworkService
import rteam.project.mainproject.RoomDatabase.RoomDataAccesObject


abstract class BaseViewModel():ViewModel(),KoinComponent{

    protected val context:Context by inject()
    protected val roomDao:RoomDataAccesObject by inject()
    protected val retrofitService:Retrofit by inject()

    private val _onFailure = MutableLiveData<Failure>()
    val onFailure: LiveData<Failure> = _onFailure

    protected fun handleFailure(failure: Failure) = _onFailure.postValue(failure)



}


