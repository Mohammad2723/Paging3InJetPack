package com.github.ebrahimi16153.paging3injetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.github.ebrahimi16153.paging3injetpack.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {
    val allImages = repository.getAllImages()
}