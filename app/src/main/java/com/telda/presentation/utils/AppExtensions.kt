package com.telda.presentation.utils

import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.RecyclerView
import com.telda.R

fun recyclerAnimationExtension(recyclerView: RecyclerView) {
    val resId: Int = R.anim.layout_animation
    val animation: LayoutAnimationController =
        AnimationUtils.loadLayoutAnimation(recyclerView.context, resId)
    recyclerView.layoutAnimation = animation
}
