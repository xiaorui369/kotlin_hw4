package com.example.ncraftmedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    val loc = Location(22.33,123.00, "Somewhere near")
    var myActions = MyActions(10,1,2,false, false)
    var post = Post(1, "Netology", "First post from the future", "20.09.2019", false)
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
        if (myActions.likeCounter >= 1 || myActions.shareCounter >= 1 || myActions.commentCounter >= 1){
            contentTv.text = post.content
        } else {
            contentTv.text = ""
        }
        val counterV = findViewById<TextView>(R.id.counter)
        val counterM = findViewById<TextView>(R.id.counterMsg)
        val counterS = findViewById<TextView>(R.id.counterShare)
        val address = findViewById<TextView>(R.id.address)
        counterM.text = myActions.commentCounter.toString()
        counterV.text = myActions.likeCounter.toString()
        counterS.text = myActions.shareCounter.toString()
        address.text = loc.address

        if (myActions.likeCounter == 0 || myActions.shareCounter == 0 || myActions.commentCounter == 0){
            counterM.text = ""
            counterV.text = ""
            counterS.text = ""
        }

        likeBtn.setOnClickListener {
            if (!post.likedByMe) {
                post.likedByMe = true
                if (post.likedByMe) {
                    likeBtn.setImageResource(R.drawable.ic_favorite_black_24dp)
                    myActions.likeCounter++
                    counterV.text = "${myActions.likeCounter}"
                    contentTv.text = post.content

                }
            } else {
                post.likedByMe = false
                likeBtn.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                myActions.likeCounter --
                counterV.text = "${myActions.likeCounter}"
                if (myActions.likeCounter == 0){
                    contentTv.text = ""
                    counterV.text = ""
                }

                }
            }


        messageBtn.setOnClickListener {
            if (!myActions.commentedByMe){
                myActions.commentedByMe = true
                myActions.commentCounter++
                messageBtn.setImageResource(R.drawable.ic_mode_comment_red_24dp)
                counterM.text = "${myActions.commentCounter}"
                contentTv.text = post.content
            } else {
                myActions.commentedByMe = false
                myActions.commentCounter--
                messageBtn.setImageResource(R.drawable.ic_mode_comment_gray_24dp)
                counterM.text = "${myActions.commentCounter}"
                if (myActions.commentCounter == 0){
                    contentTv.text = ""
                    counterM.text = ""
                }
                }
            }

            shareBtn.setOnClickListener{
                if (!myActions.sharedByMe){
                    myActions.sharedByMe = true
                    myActions.shareCounter++
                    shareBtn.setImageResource(R.drawable.ic_share_black_24dp)
                    counterS.text = "${myActions.shareCounter}"
                    contentTv.text = post.content
                } else {
                    myActions.sharedByMe = false
                    myActions.shareCounter--
                    shareBtn.setImageResource(R.drawable.ic_share_grey_24dp)
                    counterS.text = "${myActions.shareCounter}"
                    if (myActions.shareCounter == 0){
                        contentTv.text = ""
                        counterS.text=""
                    }
                }

            }

            locationButton.setOnClickListener{
             val intent  = Intent().apply {
                     action = Intent.ACTION_VIEW
                     data = Uri.parse("geo:${loc.lat},${loc.lon}") }
                startActivity(intent)
            }


    } 
}


