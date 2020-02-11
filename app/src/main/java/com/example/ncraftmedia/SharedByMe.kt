package com.example.ncraftmedia

import android.widget.ImageButton
import android.widget.TextView

class SharedByMe(post: Post, counters:Counters, shareBtn: ImageButton, counterS: TextView, contentTv: TextView) {
    init {
        if (!counters.sharedByMe){
            counters.sharedByMe = true
            counters.shareCounter++
            shareBtn.setImageResource(R.drawable.ic_share_black_24dp)
            counterS.text = "${counters.shareCounter}"
            contentTv.text = post.content
        } else {
            counters.sharedByMe = false
            counters.shareCounter--
            shareBtn.setImageResource(R.drawable.ic_share_grey_24dp)
            counterS.text = "${counters.shareCounter}"
            if (counters.shareCounter == 0){
                contentTv.text = ""
                counterS.text=""
            }
        }
    }
}