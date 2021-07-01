package com.fundinghelp.moniruzzamanshadhinapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.fundinghelp.moniruzzamanshadhinapplication.adapter.JobsAdapter
import com.fundinghelp.moniruzzamanshadhinapplication.view_model.SelfOnViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mAdapter: JobsAdapter? = null
    private lateinit var selfOnViewModel: SelfOnViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewJobs.visibility= View.GONE
        txtOutPut.visibility= View.VISIBLE
        selfOnViewModel = ViewModelProvider(this).get(SelfOnViewModel::class.java)
        requestForJobs()
        observeViewModel()

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewJobs!!.setLayoutManager(mLayoutManager)
        recyclerViewJobs!!.setItemAnimator(DefaultItemAnimator())
    }

    private fun requestForJobs() {
        this?.let { it1 -> selfOnViewModel.reqForJobs() };
    }

    private fun observeViewModel() {
        selfOnViewModel.response_error.observe(this, androidx.lifecycle.Observer {
            it?.let {
                Log.e("XXX", "Error")
                txtOutPut.text="Error Occurs"
            }
        })
        selfOnViewModel.jobsResponse.observe(
            this,
            androidx.lifecycle.Observer {
                it?.let {
                    recyclerViewJobs.visibility= View.VISIBLE
                    txtOutPut.visibility= View.GONE

                    Log.e("XXX", it.toString())
                    Log.e("XXX", it.message)

                    mAdapter = JobsAdapter( this,it.jobs)
                    recyclerViewJobs!!.setAdapter(mAdapter)
                    mAdapter?.notifyDataSetChanged();
                }
            })
    }
}