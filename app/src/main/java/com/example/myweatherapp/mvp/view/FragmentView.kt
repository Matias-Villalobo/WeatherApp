package com.example.myweatherapp.mvp.view

import android.content.Context
import androidx.fragment.app.DialogFragment
import java.lang.ref.WeakReference

open class FragmentView(fragment: DialogFragment) {

    private val fragmentRef: WeakReference<DialogFragment> = WeakReference(fragment)

    val fragment: DialogFragment?
        get() = fragmentRef.get()

    val context: Context?
        get() = fragment?.context
}
