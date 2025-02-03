package com.example.githubusersandroid.modules.userlist

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.githubusersandroid.modules.userlist.placeholder.PlaceholderContent.PlaceholderItem
import com.example.githubusersandroid.databinding.FragmentItemBinding
import com.example.githubusersandroid.models.User
import java.util.concurrent.Executors

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyUserRecyclerViewAdapter(
    private val values: List<User>
) : RecyclerView.Adapter<MyUserRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.login
        holder.contentView.text = item.htmlUrl.toString()
        holder.avatarImageView.scaleType = ImageView.ScaleType.CENTER

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap?
        executor.execute {
            val imageURL = item.avatarUrl.toString()

            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                handler.post {
                    holder.avatarImageView.setImageBitmap(image)
                }
            }

            catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.loginName
        val contentView: TextView = binding.htmlUrl
        val avatarImageView: ImageView = binding.userAvatar

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}