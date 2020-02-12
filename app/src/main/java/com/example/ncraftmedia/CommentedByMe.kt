package com.example.ncraftmedia

import android.widget.ImageButton
import android.widget.TextView


class CommentedByMe(post: Post, messageBtn:ImageButton,counterM:TextView,contentTv:TextView) {
    init
        {if (!post.commentedByMe){
            post.commentedByMe = true
            post.commentCounter++
            messageBtn.setImageResource(R.drawable.ic_mode_comment_red_24dp)
            counterM.text = "${post.commentCounter}"
            contentTv.text = post.content
        }   else  {
            post.commentedByMe = false
            post.commentCounter--
            messageBtn.setImageResource(R.drawable.ic_mode_comment_gray_24dp)
            counterM.text = "${post.commentCounter}"
            if (post.commentCounter == 0){
                contentTv.text = ""
                counterM.text = ""
            }
        }
    }
}
