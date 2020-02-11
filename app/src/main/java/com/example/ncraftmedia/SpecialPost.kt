package com.example.ncraftmedia

class SpecialPost(
    override var id: Long,
    override var author: String,
    override var content: String,
    override var created: String,
    override var likedByMe: Boolean,
    val lat: Double,
    val lon: Double,
    val address: String
): Post(
    id,
    author,
    content,
    created,
    likedByMe
)