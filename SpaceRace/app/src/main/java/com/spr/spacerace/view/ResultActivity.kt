package com.spr.spacerace.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.spr.spacerace.databinding.ActivityResultBinding
import com.spr.spacerace.model.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }

        // Name
        val userName = intent.getStringExtra(Constants.USER_NAME)
        binding.tvName.text = userName

        // Score
        val userScore = intent.getStringExtra(Constants.TOTAL_SCORE)
        binding.tvScore.text = userScore
    }
}