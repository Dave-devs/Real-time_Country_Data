package com.dave_devs.real_timecountrydata.domain.use_case

import com.dave_devs.real_timecountrydata.domain.model.CountryData
import com.dave_devs.real_timecountrydata.domain.repository.CountryDataRepository
import com.dave_devs.real_timecountrydata.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCountryDataUseCase @Inject constructor(
    private val repository: CountryDataRepository
) {
    suspend operator fun invoke(name: String): Flow<Resource<List<CountryData>>> {
        if(name.isBlank()) {
            return flow {  }
        }
        return repository.searchCountryData(name)
    }
}