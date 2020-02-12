package com.example.ncraftmedia

class SpecialPost(
    override var id: Long,
    override var author: String,
    override var content: String,
    override var created: String,
    override var likedByMe: Boolean,
    override var likeCounter: Int,
    override var shareCounter: Int,
    override var commentCounter: Int,
    override var commentedByMe: Boolean,
    override var sharedByMe: Boolean,
    val lat: Double,
    val lon: Double,
    val address: String
): Post(
    id,
    author,
    content,
    created,
    likedByMe,
    likeCounter,
    shareCounter,
    commentCounter,
    commentedByMe,
    sharedByMe
)
