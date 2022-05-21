package com.swancodes.foodish.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.foodish.FoodDetailsActivity
import com.swancodes.foodish.R
import com.swancodes.foodish.model.Food

class FoodListAdapter(private val dataset: List<Food>) :
    RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>() {

    class FoodListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.item_food_image)
        val textView: TextView = view.findViewById(R.id.item_food_title)
        val textView2: TextView = view.findViewById(R.id.item_food_price)
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return FoodListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.textView.text = item.name
        holder.textView2.text = item.price
        holder.button.text


        holder.button.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, FoodDetailsActivity::class.java)
            intent.putExtra(FoodDetailsActivity.nameKey, item.name)
            intent.putExtra(FoodDetailsActivity.priceKey, item.price)
            intent.putExtra(FoodDetailsActivity.imageKey, item.imageResourceId)
            intent.putExtra(FoodDetailsActivity.detailsKey, item.details)

            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size
}
