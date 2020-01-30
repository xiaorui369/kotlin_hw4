package com.example.ncraftmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.WindowManager



class MainActivity : AppCompatActivity() {
    var post = Post(1, "Netology", "First post from the future", "20.09.2019", false)
    fun postContent() {
        createdTv.text = post.created
        authorTv.text = post.author
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        postContent()
        var counter: Int = 0
        likeBtn.setOnClickListener {
            counter++
            likeBtn.setImageResource(R.drawable.ic_favorite_black_24dp)
            if (counter > 0){
                contentTv.text = post.content
            }
        }
        messageBtn.setOnClickListener{
            counter++
            messageBtn.setImageResource(R.drawable.ic_mode_comment_red_24dp)
            if (counter > 0){
                contentTv.text = post.content
            }
        }
        shareBtn.setOnClickListener{
            counter ++
            shareBtn.setImageResource(R.drawable.ic_share_black_24dp)
            if (counter > 0){
                contentTv.text = post.content
            }
        }

    }
}


