package com.ondev.wallpapers

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class WallpaperAdapter(

    private var wallpaperItems: List<WallpaperItem>

) : RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder>() {
    inner class WallpaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageWallpaper: ImageView = itemView.findViewById(R.id.image_view_parallax_effect)

        val backWallpaper: ImageView = itemView.findViewById(R.id.back_wallpaper)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WallpaperViewHolder {

        return WallpaperViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_wallpaper_screen, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        val currentWallpaperItem = wallpaperItems[position]

        holder.backWallpaper.setOnClickListener(View.OnClickListener {
            Log.d("BACK_WALLPAPER", "Clicked!!")
        })

        Glide.with(holder.imageWallpaper.context)
            .load(Uri.parse("$ASSETS_FOLDER${currentWallpaperItem.WallpaperFileName}"))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.imageWallpaper)
    }

    override fun getItemCount(): Int {
        return wallpaperItems.size
    }
}