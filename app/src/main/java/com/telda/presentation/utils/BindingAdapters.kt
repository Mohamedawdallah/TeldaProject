package com.telda.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.telda.BuildConfig
import com.telda.R

@BindingAdapter("imageUrl")
fun ImageView.bindImage( imgUrl: String?) {
        imgUrl?.let {
            val fullImageUrl = BuildConfig.IMAGE_URL + imgUrl
            Glide.with(this.context)
                .load(fullImageUrl)
                .apply(
                    RequestOptions()
                        .error(R.drawable.ic_broken_image)
                )
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(this)

    }
}

