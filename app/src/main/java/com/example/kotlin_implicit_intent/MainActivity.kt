package com.example.kotlin_implicit_intent

/*
this exercise has been created to practice implicit intent

1) To open website using implicit intent
2) To dial the number passed in edittext
3) To pass the location to Google map
4) To share the text with other applications.
 */

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWebsite(view: View) {
        var uri = Uri.parse(etxtWebsite.text.toString())
        startActivity(Intent(Intent.ACTION_VIEW, uri))

        Log.i("dav1", uri.toString())

    }

    fun openDialPad(view: View) {

        var tnumber = Uri.parse("tel:" + etxt_phoneNumber.text.toString())
        startActivity(Intent(Intent.ACTION_DIAL, tnumber))

        Log.i("dav1", tnumber.toString())
    }

    fun openMap(view: View) {
        Log.i("dav2", "boton pulsado")
        var localizacion = Uri.parse("geo:0,0?q=" + etxt_localizacion.text.toString())
        startActivity(Intent(Intent.ACTION_VIEW, localizacion))



    }

    fun shareText(view: View) {
        ShareCompat.IntentBuilder.from(this).setText(etxt_Share.text.toString()).setChooserTitle("texto compartido").setText("text/plain")
            .startChooser()
    }

}

