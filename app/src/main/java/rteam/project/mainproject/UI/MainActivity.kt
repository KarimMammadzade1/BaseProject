package rteam.project.mainproject.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import rteam.project.mainproject.TestViewModel
import rteam.project.baseproject.R

@AndroidEntryPoint()
class MainActivity : AppCompatActivity() {
    private val viewmodel: TestViewModel by viewModels()
    //lateinit var viewmodel: TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  viewmodel=ViewModelProvider(this)[TestViewModel::class.java]

        viewmodel.getThings()
    }
}
