package com.mg.assignment.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null

    @SerializedName("comments")
    @Expose
    var comments: Int? = null

    @SerializedName("likes")
    @Expose
    var likes: Int? = null

    @SerializedName("media")
    @Expose
    var media: List<Medium>? = null

    @SerializedName("user")
    @Expose
    var user: List<User>? = null
}