package com.example.basiccolorselection

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private lateinit var colorView: ImageView
    private lateinit var blueSeekBar: SeekBar
    private lateinit var redSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var colorTextView: TextView

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button

    var blue:Int = 0
    var red:Int = 0
    var green:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView(){
        colorView = findViewById(R.id.ivColorView)
        blueSeekBar = findViewById(R.id.sbBlueColor)
        redSeekBar = findViewById(R.id.sbRedColor)
        greenSeekBar = findViewById(R.id.sbGreenColor)
        colorTextView = findViewById(R.id.tvColorText)

        btn1 = findViewById(R.id.btnColor1)
        btn2 = findViewById(R.id.btnColor2)
        btn3 = findViewById(R.id.btnColor3)
        btn4 = findViewById(R.id.btnColor4)
        btn5 = findViewById(R.id.btnColor5)
        btn6 = findViewById(R.id.btnColor6)
        btn7 = findViewById(R.id.btnColor7)

        blueSeekBar.max = 255
        greenSeekBar.max = 255
        redSeekBar.max = 255

        red = 39;
        green = 135;
        blue = 203;
        redSeekBar.setProgress(red);
        greenSeekBar.setProgress(green);
        blueSeekBar.setProgress(blue);
    }

    override fun onStart() {
        super.onStart()
        blueSeekBar.setOnSeekBarChangeListener(this)
        greenSeekBar.setOnSeekBarChangeListener(this)
        redSeekBar.setOnSeekBarChangeListener(this)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        when(p0!!.id){
            R.id.sbGreenColor -> green = p1
            R.id.sbRedColor -> red = p1
            R.id.sbBlueColor -> blue = p1
        }

        setupColor()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnColor1 -> {
                red = 0
                green = 0
                blue = 128
            }
            R.id.btnColor2 -> {
                red = 128
                green = 128
                blue = 128
            }
            R.id.btnColor3 -> {
                red = 128
                green = 128
                blue = 0
            }
            R.id.btnColor4 -> {
                red = 255
                green = 0
                blue = 255
            }
            R.id.btnColor5 -> {
                red = 0
                green = 255
                blue = 255
            }
            R.id.btnColor6 -> {
                red = 128
                green = 0
                blue = 0
            }
            R.id.btnColor7 -> {
                red = 255
                green = 165
                blue = 0
            }
        }

        blueSeekBar.setProgress(blue);
        greenSeekBar.setProgress(green);
        redSeekBar.setProgress(red);

    }

    fun setupColor(){
        var color: Int = Color.argb(255, red, green, blue)
        colorView.setBackgroundColor(color)

        var hex: String = String.format("#%02x%02x%02x", red, green, blue)
        colorTextView.text = "$red/$green/$blue = $hex"
    }
}