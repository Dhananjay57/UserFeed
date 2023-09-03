package com.dhananjay.userfeedapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.dhananjay.userfeedapp.data.mappers.toUserFeed
import com.dhananjay.userfeedapp.data.models.UserFeedEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pager: Pager<Int, UserFeedEntity>) : ViewModel() {

    //    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
    val userFeedPagingFlow = pager.flow.map { pagingData ->
        pagingData.map { it.toUserFeed() }
    }.cachedIn(viewModelScope)

}