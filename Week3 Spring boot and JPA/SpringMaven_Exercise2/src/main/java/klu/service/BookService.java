package klu.service;

import klu.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void checkLibraryConnection() {
        if (bookRepository != null && bookRepository.isRepositoryAvailable()) {
            System.out.println("📡 Connected: BookService is linked to BookRepository.");
        } else {
            System.out.println("🔌 Disconnected: No repository available.");
        }
    }
}
