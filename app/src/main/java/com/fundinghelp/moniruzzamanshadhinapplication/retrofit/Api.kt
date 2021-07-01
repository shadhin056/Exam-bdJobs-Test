package com.haqueit.question.app.retrofit

import com.fundinghelp.moniruzzamanshadhinapplication.model.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET


interface Api {

    //API END POINT
    @GET("InterviewJson.json")
    fun requestForOtp(
    ): Single<ApiResponse>

}