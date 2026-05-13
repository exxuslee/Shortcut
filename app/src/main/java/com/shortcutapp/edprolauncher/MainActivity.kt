package com.shortcutapp.edprolauncher

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val target = "com.xbh.whiteboard"
        val launchIntent = packageManager.getLaunchIntentForPackage(target)
        if (launchIntent != null) {
            try {
                startActivity(launchIntent)
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(this, R.string.target_not_found, Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, R.string.target_not_installed, Toast.LENGTH_LONG).show()
        }
        finish()
    }
}
