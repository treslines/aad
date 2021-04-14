package br.com.programadordeelite.gdc.codelab.util

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navTo(@IdRes dest: Int) = findNavController().navigate(dest)
fun Fragment.navTo(@IdRes dest: Int, args: Bundle) = findNavController().navigate(dest, args)
fun Fragment.toast(msg: String) = Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
