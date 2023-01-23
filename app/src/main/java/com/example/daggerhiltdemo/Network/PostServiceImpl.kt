package com.example.daggerhiltdemo.Network

import com.example.daggerhiltdemo.Model.Post
import javax.inject.Inject

class PostServiceImpl  @Inject constructor(private val postApiService: PostApiService) {
     suspend fun getPost():List<Post> = postApiService.getPost()

}