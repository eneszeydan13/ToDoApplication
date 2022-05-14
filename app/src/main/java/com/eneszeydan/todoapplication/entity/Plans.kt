package com.eneszeydan.todoapplication.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "plans")
data class Plans(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "plan_id") @NotNull var planId:Int,
    @ColumnInfo(name = "plan_caption") @NotNull var toDoCaption: String
): Serializable {
}