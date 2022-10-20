package com.example.makeupapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makeupapi.api.RestfulApi
import com.example.makeupapi.model.MakeUpItem
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MakeUpViewModel @Inject constructor(private val api : RestfulApi) :ViewModel(){

    private val getAllMakeUp : MutableLiveData<MutableList<MakeUpItem>> = MutableLiveData()

    fun getAllMakeUpObserve(): LiveData<MutableList<MakeUpItem>> = getAllMakeUp


    fun getAllMakeUpConfig(){
        api.getAllMakeUp().enqueue(object : Callback<MutableList<MakeUpItem>>{
            override fun onResponse(
                call: Call<MutableList<MakeUpItem>>,
                response: Response<MutableList<MakeUpItem>>
            ) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        getAllMakeUp.postValue(body)
                    }else{
                        getAllMakeUp.postValue(null)
                    }
                }else{
                    getAllMakeUp.postValue(null)
                }
            }

            override fun onFailure(call: Call<MutableList<MakeUpItem>>, t: Throwable) {
                getAllMakeUp.postValue(null)
            }

        })
    }
}