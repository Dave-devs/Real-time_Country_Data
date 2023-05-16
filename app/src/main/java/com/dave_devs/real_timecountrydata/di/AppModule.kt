package com.dave_devs.real_timecountrydata.di

import android.app.Application
import androidx.room.Room
import com.dave_devs.real_timecountrydata.core.Constants.BASE_URL
import com.dave_devs.real_timecountrydata.core.Constants.COUNTRY_DATABASE
import com.dave_devs.real_timecountrydata.data.local.CountryDataDatabase
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
    fun provideCountryDatabase(app: Application): CountryDataDatabase {
        return Room.databaseBuilder(
            app,
            CountryDataDatabase::class.java,
            COUNTRY_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideCountryDataRepository(api: CountryApi, db: CountryDataDatabase): CountryDataRepository {
        return CountryDataRepoImpl(api, db.dao())
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(repository: CountryDataRepository): GetCountryDataUseCase {
        return GetCountryDataUseCase(repository)
    }
}