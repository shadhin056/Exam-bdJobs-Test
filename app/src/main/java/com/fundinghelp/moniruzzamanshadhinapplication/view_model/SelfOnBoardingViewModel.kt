package com.fundinghelp.moniruzzamanshadhinapplication.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fundinghelp.moniruzzamanshadhinapplication.model.ApiResponse
import com.haqueit.question.app.retrofit.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class SelfOnViewModel : ViewModel() {

    private val apiService = ApiService()
    private val disposable = CompositeDisposable()

    var reqForOTPResponse = MutableLiveData<ApiResponse>();
    var response_error = MutableLiveData<Boolean>();

    fun reqForOtp() {

        disposable.add(
            apiService.reqForMobileOtp()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ApiResponse>() {
                    override fun onSuccess(model: ApiResponse) {
                        model?.let {
                            reqForOTPResponse.value = model
                        }

                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                        Log.e("XXX", e.toString())
                        response_error.value = true

                    }

                })
        )
    }
}
