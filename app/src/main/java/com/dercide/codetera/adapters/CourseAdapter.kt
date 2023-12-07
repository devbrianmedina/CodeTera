package com.dercide.codetera.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dercide.codetera.R
import com.dercide.codetera.models.Course
import com.dercide.codetera.ui.course.CourseActivity
import com.dercide.codetera.ui.coursedetails.CourseDetailsActivity
import de.hdodenhof.circleimageview.CircleImageView
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

class CourseAdapter(courses:ArrayList<Course>, val context: Context, val onBtnClick: (Course) -> Unit, val onItemClick: (Course) -> Unit): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    var courses:ArrayList<Course>
    init {
        this.courses = courses
    }

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView
        val name: TextView
        val rating: TextView
        val creatorImage: CircleImageView
        val creatorName: TextView
        val topicsInf: TextView
        val price: TextView
        val btnJoin: Button
        init {
            icon = view.findViewById(R.id.ivIconCardCourse)
            name = view.findViewById(R.id.tvNameCardCourse)
            rating = view.findViewById(R.id.tvRatingCardCourse)
            creatorImage = view.findViewById(R.id.civCreatorImageCardCourse)
            creatorName = view.findViewById(R.id.tvCreatorNameCardCourse)
            topicsInf = view.findViewById(R.id.tvTopicsInfoCardCourse)
            price = view.findViewById(R.id.tvPriceCardCourse)
            btnJoin = view.findViewById(R.id.btnJoinCardCourse)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseAdapter.CourseViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
        Glide.with(holder.itemView).load(courses[position].iconUrl).into(holder.icon)
        holder.name.text = courses[position].name
        val maxStars = 5
        val rating = courses[position].qualification
        // Formatea el texto con estrellas
        val starText = "★".repeat(rating.toInt()) + "☆".repeat(maxStars - rating.toInt())
        // Asigna el texto al TextView
        holder.rating.text = "$starText (${String.format("%.1f", rating)})"
        Glide.with(holder.itemView).load(courses[position].creatorImgUrl).into(holder.creatorImage)
        holder.creatorName.text = "${courses[position].creator}\n${courses[position].creatorJob}"
        val topics = courses[position].topics
        // Calcular el total de topics y videos
        val totalTopics = topics.size
        val totalVideos = topics.sumOf { it.videos.size }
        // Crear el texto con el total de topics y videos
        val topicsInfoText = "$totalTopics Temas - $totalVideos Videos"
        // Asignar el texto al TextView
        holder.topicsInf.text = topicsInfoText
        val price = courses[position].price
        // Crear un objeto NumberFormat para el formato de moneda mexicana (MXN)
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale("es", "MX"))
        currencyFormat.currency = Currency.getInstance("MXN")
        // Formatear el precio como una cadena con formato de moneda
        val formattedPrice = currencyFormat.format(price)
        // Asignar el texto al TextView
        holder.price.text = formattedPrice
        holder.btnJoin.setOnClickListener {
            onBtnClick.invoke(courses[position])
        }
        holder.itemView.setOnClickListener {
            onItemClick.invoke(courses[position])
        }
    }

    override fun getItemCount(): Int {
        return this.courses.size
    }
}