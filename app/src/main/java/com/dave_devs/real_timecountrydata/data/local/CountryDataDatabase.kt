package com.dave_devs.real_timecountrydata.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CountryDataEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CountryDataDatabase: RoomDatabase() {
    abstract fun dao(): CountryDataDao
}