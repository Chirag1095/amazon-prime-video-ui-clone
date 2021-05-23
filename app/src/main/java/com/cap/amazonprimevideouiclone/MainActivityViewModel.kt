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
            PagerItem(pagerTitle = "TVShows", isSelected = false),
            PagerItem(pagerTitle = "Movies", isSelected = false),
            PagerItem(pagerTitle = "Kids", isSelected = false),
        )
    }

    fun onPagerItemSelected(pagerItem: PagerItem) {

        val updatedList = arrayListOf<PagerItem>()

        updatedList.addAll(_pagerItems.value ?: arrayListOf())

        updatedList.forEach {
            it.isSelected = pagerItem.pagerTitle.equals(it.pagerTitle, true)
        }

        _pagerItems.value = updatedList


        val list = arrayListOf(
            PagerItem(pagerTitle = "Home", isSelected = true),
            PagerItem(pagerTitle = "TVShows", isSelected = false),
            PagerItem(pagerTitle = "Movies", isSelected = false),
            PagerItem(pagerTitle = "Kids", isSelected = false),
        )

        list.forEach {
            it.isSelected = it.pagerTitle.equals(pagerItem.pagerTitle, true)
        }

        _pagerItems.value = list


    }

}