package klu.service;

import klu.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void issueBookToStudent(String bookName) {
        String result = bookRepository.issueBook(bookName);
        System.out.println("📘 Service Layer: " + result);
    }
}
