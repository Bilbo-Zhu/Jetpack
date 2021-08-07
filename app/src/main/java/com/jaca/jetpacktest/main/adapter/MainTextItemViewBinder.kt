package com.jaca.jetpacktest.main.adapter

import me.drakeet.multitype.ItemViewBinder
import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.jaca.jetpacktest.databinding.ItemMainTextBinding
import com.jaca.jetpacktest.main.bean.MainTextData
import com.jaca.jetpacktest.main.provider.MainNavigatorProvider

class MainTextItemViewBinder(private val mainNavigatorProvider: MainNavigatorProvider) :
    ItemViewBinder<MainTextData, TextHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TextHolder {
        return TextHolder(
            ItemMainTextBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            mainNavigatorProvider
        )
    }

    override fun onBindViewHolder(holder: TextHolder, item: MainTextData) {
        holder.bind(item)
    }
}

class TextHolder(
    @NonNull private val binding: ItemMainTextBinding,
    private val mainNavigatorProvider: MainNavigatorProvider
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.navigatorProvider = mainNavigatorProvider
    }

    fun bind(item: MainTextData) {
        binding.tvText.text = item.content
    }
}