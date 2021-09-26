package com.rajeshlearns.mynotes.feature_notes.presentation.notes

import com.rajeshlearns.mynotes.feature_notes.domain.model.Note
import com.rajeshlearns.mynotes.feature_notes.domain.util.NoteOrder
import com.rajeshlearns.mynotes.feature_notes.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible: Boolean = false
) {

}