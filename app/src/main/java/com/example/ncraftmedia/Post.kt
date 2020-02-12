package com.example.ncraftmedia

open class Post(
    open var id: Long,
    open var author: String,
    open var content: String,
    open var created: String,
    open var likedByMe: Boolean,
    open var likeCounter: Int,
    open var shareCounter: Int,
    open var commentCounter: Int,
    open var commentedByMe: Boolean,
    open var sharedByMe: Boolean
)
