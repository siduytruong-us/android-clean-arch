package com.duyts.core.network.retrofit

import com.duyts.core.network.AppNetworkDataSource
import com.duyts.core.network.BuildConfig
import com.duyts.core.network.model.PropertyResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton


private const val NIA_BASE_URL: String = BuildConfig.BACKEND_URL


private data class NetworkResponse<T>(
    val data: T
)

private interface RetrofitAppNetworkApi {
    @GET("")
    suspend fun getProperties(): NetworkResponse<List<PropertyResponse>>
}


@Singleton
internal class RetrofitAppNetwork @Inject constructor(

) : AppNetworkDataSource {
    private val api =
        Retrofit.Builder().baseUrl(NIA_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitAppNetworkApi::class.java)

    override suspend fun getProperties(): List<PropertyResponse> =
        api.getProperties().data
}