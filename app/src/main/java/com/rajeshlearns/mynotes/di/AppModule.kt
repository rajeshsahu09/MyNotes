package com.rajeshlearns.mynotes.di

import android.app.Application
import androidx.room.Room
import com.rajeshlearns.mynotes.feature_notes.data.data_source.NoteDatabase
import com.rajeshlearns.mynotes.feature_notes.data.repository.NoteRepositoryImpl
import com.rajeshlearns.mynotes.feature_notes.domain.repository.NoteRepository
import com.rajeshlearns.mynotes.feature_notes.domain.use_case.AddNote
import com.rajeshlearns.mynotes.feature_notes.domain.use_case.DeleteNote
import com.rajeshlearns.mynotes.feature_notes.domain.use_case.GetNotes
import com.rajeshlearns.mynotes.feature_notes.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}