package com.fundinghelp.moniruzzamanshadhinapplication.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fundinghelp.moniruzzamanshadhinapplication.R
import com.fundinghelp.moniruzzamanshadhinapplication.model.JobDetails
import kotlinx.android.synthetic.main.row_jobs.view.*

class JobsAdapter(
    private val activity: Activity,
    private val mainRequestList: List<JobDetails>
) :
    RecyclerView.Adapter<JobsAdapter.MyViewHolder>() {

    private val mainList: List<JobDetails>

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    init {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JobsAdapter.MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_jobs, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: JobsAdapter.MyViewHolder,
        position: Int
    ) {
        val currentItem = mainList[position]

        holder.itemView.txtJobTitleValue.setText(currentItem.jobTitle)
        holder.itemView.txtJobDeadlineValue.setText(currentItem.deadline)
        holder.itemView.txtJobRecruitingCompanyProfileValue.setText(currentItem.recruitingCompanySProfile)
        holder.itemView.txtLastDateValue.setText(currentItem.jobsDate.lastDate)
        holder.itemView.txtApplyInstructionValue.setText(currentItem.jobsDate.applyInstruction)

        Glide.with(activity).load(currentItem.logo).into(holder.itemView.ivLogo)

        if(currentItem.isFeatured){
            holder.itemView.txtJobIsFeaturedValue.setText("isFeatured Yes")
        }
        if(currentItem.minExperience != null){
            holder.itemView.txtMinExperienceValue.setText(currentItem.minExperience.toString())
        }
         if(currentItem.maxExperience != null ){
             holder.itemView.txtmaxExperienceValue.setText(currentItem.maxExperience.toString())
         }
        if(currentItem.minSalary.toString().isNotEmpty()){
            holder.itemView.txtMinSalaryValue.setText(currentItem.minSalary.toString())
        }
        if(currentItem.maxSalary.toString().isNotEmpty()){
            holder.itemView.txtMaxSalaryValue.setText(currentItem.maxSalary.toString())
        }

    }

    override fun getItemCount(): Int {
        return try {
            mainList.size
        } catch (e: Exception) {
            0
        }
    }
    init {
        this.mainList = mainRequestList
    }

}