package com.omercankoc.catchme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var score : Int = 0
    var imageViewArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AddImageViews()
        hideImages()

        object : CountDownTimer(60000,1000){
            // Sure bittiginde gerceklesecek operasyon.
            override fun onFinish() {
                //
                Time.text = "Time 0"
                // Runnable durdur.

                handler.removeCallbacks(runnable)
                // Butun ImageView'lari gorunmez yap.

                for(image in imageViewArray){
                    image.visibility = View.INVISIBLE
                }

                // Alert Operasyonu
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("YOUR SCORE : $score")
                alert.setMessage("Restart the game?")

                alert.setPositiveButton("Yes"){dialog, which ->
                    val intent = intent
                    finish() // activity tamamen sonlandirilir.
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog, which ->
                    Toast.makeText(this@MainActivity,"Your Score $score", Toast.LENGTH_LONG).show()
                    finish()
                }
                alert.show()
            }

            // Her bir birim zamanda gerceklesecek operasyon.
            override fun onTick(millisUntilFinished: Long) {
                Time.text = "" + millisUntilFinished/1000
            }
        }.start() // baslat.

    }

    // ImageViewArray icerisindeki image'lari gizle.
    // Random nesnesi ile olusturulmus 0-24 araliginde bir int degeri al.
    // Alinan degere karsilik image'ı gorunur yap.
    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {
                for(image in imageViewArray){
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomIndex = random.nextInt(24)

                imageViewArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,350)
            }
        }
        handler.post(runnable)
    }


    // Gorunur olan imageView'e tiklandiginda score degeri +1
    fun IncreaseScore(view : View){
        score++
        Score.text = "$score"
    }

    // imageView'lari Array'e ekle.
    fun AddImageViews(){
        imageViewArray.add(imageView1)
        imageViewArray.add(imageView2)
        imageViewArray.add(imageView3)
        imageViewArray.add(imageView4)
        imageViewArray.add(imageView5)
        imageViewArray.add(imageView6)
        imageViewArray.add(imageView7)
        imageViewArray.add(imageView8)
        imageViewArray.add(imageView9)
        imageViewArray.add(imageView10)
        imageViewArray.add(imageView11)
        imageViewArray.add(imageView12)
        imageViewArray.add(imageView13)
        imageViewArray.add(imageView14)
        imageViewArray.add(imageView15)
        imageViewArray.add(imageView16)
        imageViewArray.add(imageView17)
        imageViewArray.add(imageView18)
        imageViewArray.add(imageView19)
        imageViewArray.add(imageView20)
        imageViewArray.add(imageView21)
        imageViewArray.add(imageView22)
        imageViewArray.add(imageView23)
        imageViewArray.add(imageView24)
    }
}
