package rteam.project.mainproject.BaseViewModel

import android.app.Application
import android.content.Context
import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import rteam.project.mainproject.Helpers.SingleLiveEvent
import rteam.project.mainproject.Retrofit.NetworkService
import rteam.project.mainproject.RoomDatabase.RoomDataAccesObject
import rteam.project.mainproject.RoomDatabase.RoomDatabase
import javax.inject.Inject
/**
 *    handle failure function going to used by viewmodels when case is NOT success!
 *    onFailure Livedata needs to be observed by MainView(Base Activity or Base Fragment)
 *    MutableLiveData replaced with SingleLiveEvent. SingleLiveEvent should have only 1 observer!
 * */
@HiltViewModel
 open class BaseViewModel @Inject constructor():ViewModel(){
  //@Inject protected lateinit var context: Context
    @Inject protected lateinit var retrofitService: NetworkService
    @Inject protected lateinit var database: RoomDataAccesObject


    private val _onFailure = SingleLiveEvent<Failure>()
    val onFailure: LiveData<Failure> = _onFailure

    protected fun handleFailure(failure: Failure) {_onFailure.value = failure}


}


