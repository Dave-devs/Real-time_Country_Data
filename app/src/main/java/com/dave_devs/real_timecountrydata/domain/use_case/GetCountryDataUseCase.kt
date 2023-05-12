package com.dave_devs.real_timecountrydata.domain.use_case

import com.dave_devs.real_timecountrydata.data.remote.CountryDataResponse
import com.dave_devs.real_timecountrydata.domain.repository.CountryDataRepository
import com.dave_devs.real_timecountrydata.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountryDataUseCase @Inject constructor(
    private val repository: CountryDataRepository
) {
    operator fun invoke(name: String): Flow<Resource<List<CountryDataResponse>>> = flow {
        try{
            emit(Resource.Loading())
            val countryData = repository.searchCountryData(name)
            emit(Resource.Success(countryData))
        } catch(_: HttpException) {
            emit(Resource.Error("The server could not process the request due to invalid " +
                    "request parameters or invalid format of the parameters.", null))
        } catch(_: IOException) {
            emit(Resource.Error("An unexpected server error has occurred.", null))
        }
    }
}