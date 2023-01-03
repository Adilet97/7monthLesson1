package com.example.a7monthlesson1.data.mappers

import com.example.a7monthlesson1.data.model.NoteEntity
import com.example.a7monthlesson1.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createAt
)