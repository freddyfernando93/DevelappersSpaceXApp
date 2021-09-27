package com.develappers.spacexchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaunchAdapter(private val launchModel: MutableList<LaunchModel>): RecyclerView.Adapter<LaunchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_launch, parent, false)
        return LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        return holder.bindView(launchModel[position])
    }

    override fun getItemCount(): Int {
        return launchModel.size
    }

}

class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle:TextView = itemView.findViewById(R.id.tvTitle)
    private val tvRocketName:TextView = itemView.findViewById(R.id.tvRocketName)
    private val tvDetails:TextView = itemView.findViewById(R.id.tvDetails)

    fun bindView(launchModel: LaunchModel){
        tvTitle.text = "Mission: " + launchModel.mission_name
        tvRocketName.text = "Rocket: " + launchModel.rocket?.rocket_name
        tvDetails.text = launchModel.details
    }
}