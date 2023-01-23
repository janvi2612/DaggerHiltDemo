package com.example.daggerhiltdemo.REPOSITORY

import com.example.daggerhiltdemo.Model.Post
import com.example.daggerhiltdemo.Network.PostServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject

class PostRepository
@Inject
constructor(private val postApiServiceImpl: PostServiceImpl){
    fun getPost() = flow {
        val response = postApiServiceImpl.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)
}