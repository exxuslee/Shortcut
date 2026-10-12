package com.shortcutapp.edprolauncher

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val targets = listOf(
        "com.xbh.whiteboard",
        "com.dazzle.whiteboard"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val launchIntent = targets.firstNotNullOfOrNull {
            packageManager.getLaunchIntentForPackage(it)
        }

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