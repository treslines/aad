package com.softsuit.aad.codelab.util

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navTo(@IdRes destination: Int) = findNavController().navigate(destination)