package com.example.retrofit.Models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class UrlModels {
    @SerializedName("file")
    @Expose
    var file: String? = null
}
