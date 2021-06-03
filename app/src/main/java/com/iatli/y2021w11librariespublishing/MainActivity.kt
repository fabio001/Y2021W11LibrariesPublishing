package com.iatli.y2021w11librariespublishing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.koushikdutta.ion.Ion
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getImage(view: View) {

        //animation
        val btn_get= findViewById<Button>(R.id.btn_get)
        YoYo.with(Techniques.Wobble)
            .duration(2000)
            .playOn(btn_get)

        val textTitle =findViewById<TextView>(R.id.txt_title)
        YoYo.with(Techniques.Shake)
            .duration(1000)
            .repeat(2)
            .playOn(textTitle)

        //using picasso get the image and show it
        val imageView = findViewById<ImageView>(R.id.img_picasso)
        //get url from user
        val user_url = findViewById<EditText>(R.id.edit_url).getText().toString()

        if (user_url==null || user_url.length < 10){
            return
        }

        Picasso.get()
            .load(user_url)
            .placeholder(R.drawable.ic_baseline_not_interested_24)
            .resize(500, 500)
            .rotate(180f)
            .into(imageView)

    }

    fun btnCheckVersion(view: View) {
        //url to check version from website
        //this url will be destroyed later. You can change it if removed
        val url_version = "https://bit.ly/3wU0ZWl"

        Ion.with(this)
            .load(url_version)
            .asString()
            .setCallback{ _, result ->
                //code to proceed with result
                //I will just show the content in toast message
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()

            }
    }


}