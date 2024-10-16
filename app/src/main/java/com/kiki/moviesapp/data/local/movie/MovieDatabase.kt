package com.kiki.moviesapp.data.local.movie

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kiki.moviesapp.util.Converter

@Database(
    entities = [MovieEntity::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}