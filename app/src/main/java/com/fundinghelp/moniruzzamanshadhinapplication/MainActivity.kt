package com.fundinghelp.moniruzzamanshadhinapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.SelfOnViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var selfOnViewModel: SelfOnViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selfOnViewModel = ViewModelProvider(this).get(SelfOnViewModel::class.java)
        requestForOtp()
        observeViewModel()
    }

    private fun requestForOtp() {
        this?.let { it1 -> selfOnViewModel.reqForOtp() };
    }

    private fun observeViewModel() {
        selfOnViewModel.response_error.observe(this, androidx.lifecycle.Observer {
            it?.let {
                Log.e("XXX", "Error")
            }
        })
        selfOnViewModel.reqForOTPResponse.observe(
            this,
            androidx.lifecycle.Observer {
                it?.let {
                    Log.e("XXX", it.toString())
                    Log.e("XXX", it.message)
                }
            })
    }
}