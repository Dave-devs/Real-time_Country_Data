package com.dave_devs.real_timecountrydata.di

import com.dave_devs.real_timecountrydata.core.Constants.BASE_URL
import com.dave_devs.real_timecountrydata.data.remote.CountryApi
import com.dave_devs.real_timecountrydata.data.repository.CountryDataRepoImpl
import com.dave_devs.real_timecountrydata.domain.repository.CountryDataRepository
import com.dave_devs.real_timecountrydata.domain.use_case.GetCountryDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryApi(): CountryApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryDataRepository(api: CountryApi): CountryDataRepository {
        return CountryDataRepoImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(repository: CountryDataRepository): GetCountryDataUseCase {
        return GetCountryDataUseCase(repository)
    }
}