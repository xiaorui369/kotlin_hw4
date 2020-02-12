package com.example.ncraftmedia


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val specialPost = SpecialPost(2, "Netology", "Post from the future", "20.09.2019",false, 12,12, 13, false, false, 123.0,120.0,"Somewhere")
    var post = Post(1, "Netology", "First post from the future", "20.09.2019",false, 10,10,10,false,false)
    fun postContent() {
        createdTv.text = post.created
        authorTv.text = post.author
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        postContent()

        val counterV = findViewById<TextView>(R.id.counter)
        val counterM = findViewById<TextView>(R.id.counterMsg)
        val counterS = findViewById<TextView>(R.id.counterShare)
        val address = findViewById<TextView>(R.id.address)
        counterM.text = post.commentCounter.toString()
        counterV.text = post.likeCounter.toString()
        counterS.text = post.shareCounter.toString()
        address.text = specialPost.address

        likeBtn.setOnClickListener{LikedByMe(post,likeBtn,counterV,contentTv)}
        messageBtn.setOnClickListener {CommentedByMe(post,messageBtn,counterM,contentTv)}
        shareBtn.setOnClickListener{SharedByMe(post,shareBtn,counterS,contentTv)}

        locationButton.setOnClickListener{
            val intent  = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo:${specialPost.lat},${specialPost.lon}") }
            startActivity(intent)
        }
    } 
}


