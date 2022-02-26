package com.telda.presentation.response.success

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.telda.presentation.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.telda.R
import com.telda.databinding.LayoutSuccessBinding

class SuccessDialog : BottomSheetDialogFragment() {
    private lateinit var successBinding: LayoutSuccessBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        successBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_success, container, false)
        getBundleMessage()
        successBinding.lifecycleOwner = this

        Handler(Looper.getMainLooper()).postDelayed({
            dismiss()
        }, Constants.DELAY_BIG.toLong())

        return successBinding.root
    }

    private fun getBundleMessage(){
        if(arguments?.containsKey(Constants.MESSAGE) == true){
            successBinding.tvMessage.text = requireArguments().getString(Constants.MESSAGE)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

}

