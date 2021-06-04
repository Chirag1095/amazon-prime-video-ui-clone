package com.cap.amazonprimevideouiclone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cap.amazonprimevideouiclone.models.PagerItem

class MainActivityViewModel : ViewModel() {

    private var _pagerItems = MutableLiveData<ArrayList<PagerItem>>()

    val pagerItems: LiveData<ArrayList<PagerItem>> = _pagerItems

    init {
        _pagerItems.value = arrayListOf(
            PagerItem(pagerTitle = "Home", isSelected = true),
            PagerItem(pagerTitle = "TV Shows", isSelected = false),
            PagerItem(pagerTitle = "Movies", isSelected = false),
            PagerItem(pagerTitle = "Kids", isSelected = false),
        )
    }

    fun onPagerItemSelected(pagerItem: PagerItem) {

        val list = arrayListOf(
            PagerItem(pagerTitle = "Home", isSelected = false),
            PagerItem(pagerTitle = "TV Shows", isSelected = false),
            PagerItem(pagerTitle = "Movies", isSelected = false),
            PagerItem(pagerTitle = "Kids", isSelected = false),
        )

        list.forEach {
            it.isSelected = it.pagerTitle.equals(pagerItem.pagerTitle, true)
        }

        _pagerItems.value = list


    }

}