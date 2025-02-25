package com.vimal.kinzooandroidchallenge.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vimal.kinzooandroidchallenge.util.Constant.CHARACTER_TABLE_NAME

@Entity(tableName = CHARACTER_TABLE_NAME)
data class Character(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val species: String,
    val gender: String
)
