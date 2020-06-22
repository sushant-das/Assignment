package com.mg.assignment.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.mg.assignment.R

object LoaderUtil {

    private var progressDialog: Dialog? = null

    fun displayProgressDialog(context: Context) {
        dismissProgressDialog()
        try {
            progressDialog = Dialog(context)
            progressDialog?.setCancelable(false)
            progressDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            progressDialog?.setContentView(R.layout.loader)
            progressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            progressDialog?.apply {
                setTitle("loading")
                show()
            }
        } catch (e: Exception) {
        }
    }

    fun dismissProgressDialog() {
        try {
            if (progressDialog?.isShowing!!) {
                progressDialog?.dismiss()
                progressDialog = null
            }
        } catch (e: Exception) {
            progressDialog = null
        }
    }
}