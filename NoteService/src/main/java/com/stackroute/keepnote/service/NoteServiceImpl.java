package com.stackroute.keepnote.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.keepnote.exception.NoteNotFoundExeption;
import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.model.NoteUser;
import com.stackroute.keepnote.repository.NoteRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service
public class NoteServiceImpl implements NoteService {

	/*
	 * Autowiring should be implemented for the NoteRepository and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	private NoteRepository noteRepository;

	@Autowired
	public NoteServiceImpl(NoteRepository noteRepository) {
		super();
		this.noteRepository = noteRepository;
	}

	/*
	 * This method should be used to save a new note.
	 */
	public boolean createNote(Note note) {
		List<Note> notes = new ArrayList<>();
		NoteUser noteUser = new NoteUser();
		notes.add(note);
		noteUser.setUserId(note.getNoteCreatedBy());
		noteUser.setNotes(notes);
		if (noteRepository.insert(noteUser) != null) {
			return true;
		} else {
			return false;
		}
	}

	/* This method should be used to delete an existing note. */

	public boolean deleteNote(String userId, int noteId) {
//		return noteRepository.findById(userId).get().getNotes().removeIf(n->n.getNoteId()==noteId);
		boolean flag = false;
		List<Note> notes = new ArrayList<>();
		NoteUser noteUser = new NoteUser();
		noteUser = noteRepository.findById(userId).get();
		notes = noteUser.getNotes();
		if (!notes.isEmpty()) {
			Iterator iterator = notes.listIterator();
			while (iterator.hasNext()) {
				Note note = (Note) iterator.next();
				if (note.getNoteId() == noteId) {
					iterator.remove();
					flag = true;
				}
			}
			noteUser.setUserId(userId);
			noteUser.setNotes(notes);
			noteRepository.save(noteUser);
		}
		return flag;
	}

	/* This method should be used to delete all notes with specific userId. */

	public boolean deleteAllNotes(String userId) throws NoteNotFoundExeption {
		boolean status = false;
		List<Note> notes = new ArrayList<>();
		NoteUser noteUser = new NoteUser();
		try {
			notes = noteRepository.findById(userId).get().getNotes();
			if (notes != null) {
				Iterator iterator = notes.listIterator();
				while (iterator.hasNext()) {
					iterator.next();
					iterator.remove();
				}
				noteUser.setUserId(userId);
				noteUser.setNotes(notes);
				noteRepository.save(noteUser);
				status = true;
			}
		} catch (NoSuchElementException e) {
			throw new NoteNotFoundExeption("NoteNotFoundExeption");

		}
		return status;
	}

	/*
	 * This method should be used to update a existing note.
	 */
	public Note updateNote(Note note, int id, String userId) throws NoteNotFoundExeption {
		List<Note> notes = new ArrayList<>();
		NoteUser noteUser = new NoteUser();
		try {
			noteUser = noteRepository.findById(userId).get();
			notes = noteRepository.findById(userId).get().getNotes();
			if (notes != null) {
				Iterator iterator = notes.listIterator();
				while (iterator.hasNext()) {
					Note updateNote = (Note) iterator.next();
					if (note.getNoteId() == id) {
						updateNote.setNoteId(id);
						updateNote.setNoteTitle(note.getNoteTitle());
						updateNote.setNoteContent(note.getNoteContent());
						updateNote.setNoteCreationDate(new Date());
						updateNote.setNoteCreatedBy(userId);
						updateNote.setCategory(note.getCategory());
						updateNote.setReminders(note.getReminders());
						break;
					}
				}
				noteUser.setUserId(userId);
				noteUser.setNotes(notes);
				noteRepository.save(noteUser);
			}
		} catch (NoSuchElementException e) {
			throw new NoteNotFoundExeption("NoteNotFoundExeption");
		}
		return note;
	}

	/*
	 * This method should be used to get a note by noteId created by specific user
	 */
	public Note getNoteByNoteId(String userId, int noteId) throws NoteNotFoundExeption {
		List<Note> notes = new ArrayList<>();
		Note note = new Note();
		try {
			notes = getAllNoteByUserId(userId);
			Iterator iterator = notes.listIterator();
			while (iterator.hasNext()) {
				note = (Note) iterator.next();
				if (note.getNoteId() == noteId) {
					break;
				}
			}
		} catch (NoSuchElementException e) {
			throw new NoteNotFoundExeption("NoteNotFoundExeption");
		}
		return note;
	}

	/*
	 * This method should be used to get all notes with specific userId.
	 */
	public List<Note> getAllNoteByUserId(String userId) {
		NoteUser noteUser = noteRepository.findById(userId).get();
		if(noteUser!=null) {
			return noteUser.getNotes();
		}
		return null;
	}
}
