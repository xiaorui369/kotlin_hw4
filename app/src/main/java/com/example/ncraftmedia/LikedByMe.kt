package com.example.ncraftmedia


import android.widget.ImageButton
import android.widget.TextView


class LikedByMe(post:Post,counters:Counters,likeBtn: ImageButton, counterV:TextView, contentTv:TextView) {
       init {
            if (!post.likedByMe) {
            post.likedByMe = true
            if (post.likedByMe) {
                likeBtn.setImageResource(R.drawable.ic_favorite_black_24dp)
                counters.likeCounter++
                counterV.text = "${counters.likeCounter}"
                contentTv.text = post.content
            }
            } else {
                post.likedByMe = false
                likeBtn.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                counters.likeCounter--
                counterV.text = "${counters.likeCounter}"
            if (counters.likeCounter == 0) {
                    contentTv.text = ""
                    counterV.text = ""
                }
            }
        }
    }