package com.spr.spacerace.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import com.spr.spacerace.`interface`.GameTask
import com.spr.spacerace.R
import com.spr.spacerace.model.Constants

class MainActivity: AppCompatActivity(), GameTask {

    private lateinit var rootLayout : LinearLayout
    private lateinit var startBtn : Button
    private lateinit var etName: EditText
    private lateinit var mGameView : GameView
    private lateinit var score: TextView

    private lateinit var tv_title:TextView
    private lateinit var tv_app_name:TextView
    private lateinit var tv_description:TextView
    private lateinit var et_name:AppCompatEditText
    private lateinit var cv_main:CardView

    private var mUserName: String? = null

    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_title = findViewById(R.id.tv_title)
        tv_app_name = findViewById(R.id.tv_app_name)
        tv_description = findViewById(R.id.tv_description)
        et_name = findViewById(R.id.et_name)
        cv_main = findViewById(R.id.cv_main)

        score = findViewById(R.id.score)
        etName = findViewById(R.id.et_name)
        startBtn  = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        mGameView = GameView(this,this)

        // View OFF
        score.visibility = View.GONE

        // Start GameView
        startBtn.setOnClickListener {
            if (etName.text?.isEmpty() == true) {
                Toast.makeText(this@MainActivity, "Пожалуйста, введите Ваше имя", Toast.LENGTH_SHORT).show()
            } else {
                mGameView.setBackgroundResource(R.drawable.ic_space)
                rootLayout.addView(mGameView)

                // Off Visibility of View
                startBtn.visibility = View.GONE
                tv_title.visibility = View.GONE
                tv_app_name.visibility = View.GONE
                tv_description.visibility = View.GONE
                et_name.visibility = View.GONE
                cv_main.visibility = View.GONE
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(mGameView)

        val intent = Intent(this@MainActivity, ResultActivity::class.java)
        // Save Name
        intent.putExtra(Constants.USER_NAME, etName.text.toString())
        intent.putExtra(Constants.TOTAL_SCORE,score.text.toString())
        startActivity(intent)
        finish()
    }

//    override fun saveName(mName: String) {
//        // name.text = "Name : $mName"
//    }
}