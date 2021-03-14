package com.softsuit.aad.codelab.util

import android.view.View
import android.view.animation.Animation

fun View.startAnimation(anim: Animation, onEnd: () -> Unit){
    anim.setAnimationListener(object : Animation.AnimationListener{
        override fun onAnimationEnd(anim: Animation?) = onEnd()
        override fun onAnimationRepeat(anim: Animation?) = Unit
        override fun onAnimationStart(anim: Animation?) = Unit
    })
    this.startAnimation(anim)
}