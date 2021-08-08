package com.jaca.jetpacktest.main.adapter

import me.drakeet.multitype.ItemViewBinder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.jaca.jetpacktest.databinding.ItemMainTextBinding
import com.jaca.jetpacktest.main.bean.MainTextData
import com.jaca.jetpacktest.main.presenter.MainTextActionType
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

    private var item: MainTextData? = null

    init {
        binding.holder = this
    }

    fun bind(item: MainTextData) {
        this.item = item
        binding.tvText.text = item.content
    }

    fun onClick() {
        item?.let {
            when (it.actionType) {
                MainTextActionType.GO_TO_SHARE_DATA_DEMO.value -> mainNavigatorProvider.navigator2ShareDataFrag()
                MainTextActionType.GO_TO_LIVE_DATA_DEMO.value -> mainNavigatorProvider.navigator2LiveDataFrag()
                MainTextActionType.GO_TO_DATA_BINDING_DEMO.value -> mainNavigatorProvider.navigator2DataBindingFrag()
            }
        }
    }
}