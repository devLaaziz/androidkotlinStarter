package com.app.androidkotlinStarter.data.model

import com.google.gson.annotations.SerializedName

class Statistic {
    var stat: NamedResource? = null
    @SerializedName("base_stat")
    var baseStat: Int = 0
}
