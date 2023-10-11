package com.simplify.simplify

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.simplify.simplify.databinding.FragmentApresentation1Binding

/**
 * A simple [Fragment] subclass.
 * Use the [Presentation1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Presentation1 : Fragment() {

    lateinit var b: FragmentApresentation1Binding
    init {
        Log.d("codeReach", "the Presentation1 was initialized")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentApresentation1Binding.inflate(inflater)

        Log.d("codeReach", "presentation1 onCreateView")
        // for some reason container view only work with viewBinding
        return b.root
    }

}