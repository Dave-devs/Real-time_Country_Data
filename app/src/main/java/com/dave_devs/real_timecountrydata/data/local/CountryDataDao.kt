package com.dave_devs.real_timecountrydata.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryData(countryDataEntity: List<CountryDataEntity>)

    @Query("DELETE FROM COUNTRY_DATA_ENTITY WHERE name IN (:name)")
    suspend fun deleteCountryData(name: List<String>)

    @Query("SELECT * FROM COUNTRY_DATA_ENTITY WHERE name LIKE '%' || :name || '%'")
    fun getCountryData(name: String): List<CountryDataEntity>
}