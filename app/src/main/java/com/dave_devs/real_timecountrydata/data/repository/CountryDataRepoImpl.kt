package com.dave_devs.real_timecountrydata.data.repository

import com.dave_devs.real_timecountrydata.data.local.CountryDataDao
import com.dave_devs.real_timecountrydata.data.remote.CountryApi
import com.dave_devs.real_timecountrydata.domain.model.CountryData
import com.dave_devs.real_timecountrydata.domain.repository.CountryDataRepository
import com.dave_devs.real_timecountrydata.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CountryDataRepoImpl @Inject constructor(
    private val api: CountryApi,
    private val dao: CountryDataDao
): CountryDataRepository {
    override suspend fun searchCountryData(name: String): Flow<Resource<List<CountryData>>> = flow {

        emit(Resource.Loading())

        val localCountryData = dao.getCountryData(name).map { it.toCountryData() }

        emit(Resource.Loading(localCountryData))

        try {
            val remoteCountryData = api.searchCountryData(name)
            dao.deleteCountryData(remoteCountryData.map {it.name})
            dao.insertCountryData(remoteCountryData.map { it.toCountryDataEntity() })

        } catch(_: HttpException) {
            emit(Resource.Error(
                message = "The server could not process the request due to invalid " +
                    "request parameters or invalid format of the parameters.",
                data = localCountryData
            ))
        } catch(_: IOException) {
            emit(Resource.Error(
                message = "An unexpected server error has occurred.",
                data = localCountryData
            ))
        }
        
        val newCountryData = dao.getCountryData(name).map { it.toCountryData() }
        emit(Resource.Success(newCountryData))
    }
}