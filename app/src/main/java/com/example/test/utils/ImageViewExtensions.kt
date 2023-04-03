package com.cookpad.hiring.android.tools

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImage(imageUri: String?, @DrawableRes placeholder: Int) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().centerCrop().placeholder(placeholder).error(placeholder))
        //.thumbnail(0.1f)
        .into(this)
}

fun ImageView.loadImageWithoutCrop(imageUri: String?, @DrawableRes placeholder: Int) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().placeholder(placeholder).error(placeholder))
        //.thumbnail(0.1f)
        .into(this)
}

fun ImageView.loadImage(imageUri: String?) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().centerCrop())
        //.thumbnail(0.1f)
        .into(this)
}


fun ImageView.loadImageWithError(
    imageUri: String,
    @DrawableRes placeholder: Int,
    @DrawableRes error: Int
) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().centerCrop().placeholder(placeholder).error(error))
        .into(this)
}

fun ImageView.loadImageAsBitmap(imageUri: String, @DrawableRes placeholder: Int) {
    Glide.with(this.context)
        .asBitmap()
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().centerCrop().placeholder(placeholder).error(placeholder))
        .into(this)
}

fun ImageView.loadImage(resId: Int) {
    Glide.with(this.context)
        .load(resId)
        .apply(RequestOptions().centerCrop())

        .into(this)
}

fun ImageView.loadImageWithoutCrop(imageUri: String) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .into(this)
}

fun ImageView.loadCircularImage(imageUri: String?, @DrawableRes placeholder: Int) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().placeholder(placeholder).error(placeholder).circleCrop())
        .into(this)
}

fun ImageView.loadCircularOriginal(imageUri: String?, @DrawableRes placeholder: Int) {
    Glide.with(this.context)
        .load(imageUri)
        .format(DecodeFormat.PREFER_ARGB_8888)
        .dontTransform()
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().placeholder(placeholder).error(placeholder).circleCrop())
        .into(this)
}

fun ImageView.loadCircularImage(imageUri: Uri?) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().circleCrop())
        .into(this)
}

fun ImageView.loadCircularImage(imageUri: String?) {
    Glide.with(this.context)
        .load(imageUri)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().circleCrop())
        .into(this)
}

fun ImageView.loadCircularImage(resId: Int, @DrawableRes placeholder: Int) {
    Glide.with(this.context)
        .load(resId)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().placeholder(placeholder).error(placeholder).circleCrop())
        .into(this)
}

fun ImageView.loadCircularImage(resId: Int) {
    Glide.with(this.context)
        .load(resId)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
        .apply(RequestOptions().circleCrop())
        .into(this)
}



fun ImageView.setIconColor(@ColorRes color: Int) {
    context?.let { ctx ->
        this.setColorFilter(
            ContextCompat.getColor(ctx, color),
            android.graphics.PorterDuff.Mode.SRC_IN
        )
    }
}

fun ImageView.clear() {
    Glide.with(this.context)
        .clear(this)
}