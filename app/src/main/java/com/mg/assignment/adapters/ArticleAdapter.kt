package com.mg.assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mg.assignment.R
import com.mg.assignment.pojo.Data
import de.hdodenhof.circleimageview.CircleImageView

class ArticleAdapter(private var articleList: List<Data>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userProfileIV: CircleImageView = view.findViewById(R.id.iv_user_profile)
        val userNameTV: AppCompatTextView = view.findViewById(R.id.tv_user_name)
        val userDesignationTV: AppCompatTextView = view.findViewById(R.id.tv_user_designation)
        val timeCreatedTV: AppCompatTextView = view.findViewById(R.id.tv_time_created)
        val articleIV: AppCompatImageView = view.findViewById(R.id.iv_article_image)
        val articleDescriptionTV: AppCompatTextView = view.findViewById(R.id.tv_article_description)
        val likesTV: AppCompatTextView = view.findViewById(R.id.tv_likes)
        val commentsTV: AppCompatTextView = view.findViewById(R.id.tv_comments)
    }

     fun updateList(updatedList: List<Data>) {
        this.articleList = updatedList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article_list, parent, false) as View
        return ArticleViewHolder(
            rootView
        )
    }


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data: Data = articleList[position]
        if (data.createdAt != null) {
            holder.timeCreatedTV.text = data.createdAt!!.substring(0, 10)
        }
        if (data.content != null) {
            holder.articleDescriptionTV.text = data.content
        }
        val likes = if (data.likes != null) {
            val count: String
            val aboveThousand: Int
            val belowThousand: Int
            if (data.likes!! > 1000) {
                aboveThousand = data.likes!! / 1000
                belowThousand = data.likes!! % 1000
                val i = belowThousand / 100
                count = "$aboveThousand.${i}K Likes"
            } else {
                count = data.likes!!.toString() + " Likes"
            }
            count
        } else {
            "0 Likes"
        }
        holder.likesTV.text = likes
        val comments =
            if (data.comments != null) {
                val count: String
                val aboveThousand: Int
                val belowThousand: Int
                if (data.comments!! > 1000) {
                    aboveThousand = data.comments!! / 1000
                    belowThousand = data.comments!! % 1000
                    val i = belowThousand / 100
                    count = "$aboveThousand.${i}K Likes"
                } else {
                    count = data.comments!!.toString() + " Likes"
                }
                count
            } else {
                "0 Comments"
            }
        holder.commentsTV.text = comments
        if (data.media != null && (data.media)!!.isNotEmpty()) {
            if (data.media!![0].image != null) {
                Glide
                    .with(holder.articleIV.context)
                    .load(data.media!![0].image)
                    .centerCrop()
                    .into(holder.articleIV)
            }
        }

        if (data.user != null && (data.user)!!.isNotEmpty()) {
            if (data.user!![0].avatar != null) {
                Glide
                    .with(holder.userProfileIV.context)
                    .load(data.user!![0].avatar)
                    .centerCrop()
                    .into(holder.userProfileIV)
            }
            if (data.user!![0].name != null) {
                holder.userNameTV.text = data.user!![0].name
            }
            if (data.user!![0].designation != null) {
                holder.userDesignationTV.text = data.user!![0].designation
            }
        }
    }


    override fun getItemCount() = articleList.size
}
