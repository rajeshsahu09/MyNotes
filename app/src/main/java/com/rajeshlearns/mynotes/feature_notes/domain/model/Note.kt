package com.rajeshlearns.mynotes.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rajeshlearns.mynotes.ui.theme.*

@Entity
data class Note(
    val title : String,
    val content : String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
