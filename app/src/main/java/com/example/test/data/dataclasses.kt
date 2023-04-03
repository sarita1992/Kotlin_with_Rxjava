package com.example.test.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinates(
    @SerializedName("latitude")
    var latitude: String,
    @SerializedName("longitude")
    var longitude: String
) : Parcelable

@Parcelize
data class Dob(
    @SerializedName("date")
    var date: String,
    @SerializedName("age")
    var age: Int
) : Parcelable

@Parcelize
data class Id(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("value")
    var value: String? = null
) : Parcelable

@Parcelize
data class Info(
    @SerializedName("seed")
    var seed: String? = null,

    @SerializedName("results")
    var results: Int? = null,

    @SerializedName("page")
    var page: Int? = null,

    @SerializedName("version")
    var version: String? = null
) : Parcelable

@Parcelize
data class Location(
    @SerializedName("street")
    var street: Street? = null,

    @SerializedName("city")
    var city: String? = null,

    @SerializedName("state")
    var state: String? = null,

    @SerializedName("country")
    var country: String? = null,

    @SerializedName("postcode")
    var postcode: String? = null,

    @SerializedName("coordinates")
    var coordinates: Coordinates? = null,

    @SerializedName("timezone")
    var timezone: Timezone? = null
) : Parcelable

@Parcelize
data class Login(
    @SerializedName("uuid")
    var uuid: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("password")
    var password: String? = null,

    @SerializedName("salt")
    var salt: String? = null,

    @SerializedName("md5")
    var md5: String? = null,

    @SerializedName("sha1")
    var sha1: String? = null,

    @SerializedName("sha256")
    var sha256: String? = null
) : Parcelable

@Parcelize
data class Name(
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("first")
    var first: String? = null,

    @SerializedName("last")
    var last: String? = null
) : Parcelable

@Parcelize
data class Picture(
    @SerializedName("large")
    var large: String? = null,

    @SerializedName("medium")
    var medium: String? = null,

    @SerializedName("thumbnail")
    var thumbnail: String? = null
) : Parcelable

@Parcelize
data class Registered(
    @SerializedName("date")
    var date: String? = null,

    @SerializedName("age")
    var age: Int? = null
) : Parcelable

@Parcelize
data class Result(
    @SerializedName("gender")
    var gender: String? = null,

    @SerializedName("name")
    var name: Name? = null,

    @SerializedName("location")
    var location: Location? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("login")
    var login: Login? = null,

    @SerializedName("dob")
    var dob: Dob? = null,

    @SerializedName("registered")
    var registered: Registered? = null,

    @SerializedName("phone")
    var phone: String? = null,

    @SerializedName("cell")
    var cell: String? = null,

    @SerializedName("id")
    var id: Id? = null,

    @SerializedName("picture")
    var picture: Picture? = null,

    @SerializedName("nat")
    var nat: String? = null
) : Parcelable

@Parcelize
data class Street(
    @SerializedName("number")
    var number: Int? = null,

    @SerializedName("name")
    var name: String? = null
) : Parcelable

@Parcelize
data class Timezone(
    @SerializedName("offset")
    var offset: String? = null,

    @SerializedName("description")
    var description: String? = null
) : Parcelable

@Parcelize
data class Users(
    var results: List<Result?>? = null,
    var info: Info? = null,
) : Parcelable