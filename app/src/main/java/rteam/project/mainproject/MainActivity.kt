package rteam.project.mainproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import rteam.project.baseproject.R

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel:TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel=ViewModelProvider(this)[TestViewModel::class.java]

        viewmodel.getThings()
    }
}
