package com.example.ncraftmedia

import android.widget.ImageButton
import android.widget.TextView

class SharedByMe(post: Post, shareBtn: ImageButton, counterS: TextView, contentTv: TextView) {
    init {
        if (!post.sharedByMe){
            post.sharedByMe = true
            post.shareCounter++
            shareBtn.setImageResource(R.drawable.ic_share_black_24dp)
            counterS.text = "${post.shareCounter}"
            contentTv.text = post.content
        } else {
            post.sharedByMe = false
            post.shareCounter--
            shareBtn.setImageResource(R.drawable.ic_share_grey_24dp)
            counterS.text = "${post.shareCounter}"
            if (post.shareCounter == 0){
                contentTv.text = ""
                counterS.text=""
            }
        }
    }
}
