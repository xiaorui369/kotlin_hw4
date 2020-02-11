package com.example.ncraftmedia


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val specialPost = SpecialPost(2, "Netology", "Post from the future", "20.09.2019",false,123.0, 122.0,"Somewhere")
    var counters = Counters(10,1,2,false, false)
    var post = Post(1, "Netology", "First post from the future", "20.09.2019",false)
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
        counterM.text = counters.commentCounter.toString()
        counterV.text = counters.likeCounter.toString()
        counterS.text = counters.shareCounter.toString()
        address.text = specialPost.address

        likeBtn.setOnClickListener{LikedByMe(post,counters,likeBtn,counterV,contentTv)}
        messageBtn.setOnClickListener {CommentedByMe(post,counters,messageBtn,counterM,contentTv)}
        shareBtn.setOnClickListener{SharedByMe(post,counters,shareBtn,counterS,contentTv)}

        locationButton.setOnClickListener{
            val intent  = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo:${specialPost.lat},${specialPost.lon}") }
            startActivity(intent)
        }
    } 
}


