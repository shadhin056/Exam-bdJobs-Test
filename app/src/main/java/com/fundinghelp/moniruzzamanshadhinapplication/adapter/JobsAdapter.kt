package com.fundinghelp.moniruzzamanshadhinapplication.adapter

import android.app.Activity
import android.graphics.Typeface
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fundinghelp.moniruzzamanshadhinapplication.R
import com.fundinghelp.moniruzzamanshadhinapplication.model.JobDetails
import kotlinx.android.synthetic.main.row_jobs.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

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
    fun getFormattedDate(dateGet: String?): String? {

        var date: String? = null

        var spf = SimpleDateFormat("dd/MM/yyyy")
        var newDate: Date? = null
        try {
            newDate = spf.parse(dateGet)
           // spf = SimpleDateFormat("yyyy-MM-dd")
           // date = spf.format(newDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val cal = Calendar.getInstance()
        cal.time = newDate

        //2nd of march 2015
        val day = cal[Calendar.DATE]
        return when (day % 10) {
            1 -> SimpleDateFormat("d'st' MMMM, yyyy").format(newDate)
            2 -> SimpleDateFormat("d'nd' MMMM, yyyy").format(newDate)
            3 -> SimpleDateFormat("d'rd' MMMM, yyyy").format(newDate)
            else -> SimpleDateFormat("d'th' MMMM, yyyy").format(newDate)
        }
    }
    override fun onBindViewHolder(
        holder: JobsAdapter.MyViewHolder,
        position: Int
    ) {
        val currentItem = mainList[position]

        holder.itemView.txtJobCompanyValue.setText(currentItem.jobsDate.companyName)
        holder.itemView.txtJobTitleValue.setText(currentItem.jobTitle)
        holder.itemView.txtJobDeadlineValue.setText(getFormattedDate(currentItem.deadline))
        holder.itemView.txtJobRecruitingCompanyProfileValue.setText(currentItem.recruitingCompanySProfile)
        holder.itemView.txtLastDateValue.setText(currentItem.jobsDate.lastDate)

        holder.itemView.txtApplyInstructionValue.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(currentItem.jobsDate.applyInstruction, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(currentItem.jobsDate.applyInstruction)
        }


        Glide.with(activity).load(currentItem.logo).into(holder.itemView.ivLogo)

        if(currentItem.isFeatured){
            holder.itemView.txtJobCompanyValue.setTypeface(null, Typeface.BOLD);
            holder.itemView.txtJobCompany.setTypeface(null, Typeface.BOLD);
        }
        if(currentItem.minExperience != null){
            holder.itemView.txtMinExperienceValue.setText(currentItem.minExperience.toString() + "Year")
        }
         if(currentItem.maxExperience != null ){
             holder.itemView.txtmaxExperienceValue.setText(currentItem.maxExperience.toString()+ "Year")
         }
        if(currentItem.minSalary.toString().isNotEmpty()){
            holder.itemView.txtMinSalaryValue.setText(currentItem.minSalary.toString())
        }else{
            holder.itemView.txtMinSalaryValue.setText("Negotiable")
        }
        if(currentItem.maxSalary.toString().isNotEmpty()){
            holder.itemView.txtMaxSalaryValue.setText(currentItem.maxSalary.toString())
        }else{
            holder.itemView.txtMaxSalaryValue.setText("Negotiable")
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