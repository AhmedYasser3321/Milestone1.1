package com.example.milestone1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

class MainActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

mapFragment= supportFragmentManager.findFragemntById(R.id.map) an SupportMapFragment
mapFragment.getMapAsync(ONMapReadyCallback{

})

}
