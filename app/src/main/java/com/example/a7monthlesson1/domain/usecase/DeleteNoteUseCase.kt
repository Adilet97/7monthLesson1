package com.example.a7monthlesson1.domain.usecase

import com.example.a7monthlesson1.domain.model.Note
import com.example.a7monthlesson1.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}