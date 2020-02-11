package com.example.ncraftmedia

import android.widget.ImageButton
import android.widget.TextView


class CommentedByMe(post: Post, counters:Counters,messageBtn:ImageButton,counterM:TextView,contentTv:TextView) {
    init
        {if (!counters.commentedByMe){
            counters.commentedByMe = true
            counters.commentCounter++
            messageBtn.setImageResource(R.drawable.ic_mode_comment_red_24dp)
            counterM.text = "${counters.commentCounter}"
            contentTv.text = post.content
        }   else  {
            counters.commentedByMe = false
            counters.commentCounter--
            messageBtn.setImageResource(R.drawable.ic_mode_comment_gray_24dp)
            counterM.text = "${counters.commentCounter}"
            if (counters.commentCounter == 0){
                contentTv.text = ""
                counterM.text = ""
            }
        }
    }
}