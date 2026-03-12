package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container1, ImageDisplayFragment.newInstance(imageArray))
                .add(R.id.container2, ImageDisplayFragment.newInstance(imageArray))
                .commit()
        }
    }
}