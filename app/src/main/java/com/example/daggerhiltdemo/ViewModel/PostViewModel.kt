package com.example.daggerhiltdemo.ViewModel

import android.util.Log
//import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.daggerhiltdemo.Model.Post
import com.example.daggerhiltdemo.REPOSITORY.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
@Inject
constructor(private val postRepository: PostRepository):ViewModel(){
 val response:LiveData<List<Post>> = postRepository.getPost().
 catch {e->
     Log.d("main","${e.message}")

 }.asLiveData()

}