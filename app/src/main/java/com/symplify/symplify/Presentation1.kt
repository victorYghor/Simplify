package com.simplify.symplify

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [Presentation1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Presentation1 : Fragment() {

    init {
        Log.d("codeReach", "the Presentation1 was initialized")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("codeReach", "presentation1 onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}