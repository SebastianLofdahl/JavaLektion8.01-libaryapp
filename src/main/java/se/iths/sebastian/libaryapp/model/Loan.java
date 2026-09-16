package se.iths.sebastian.libaryapp.model;

import java.time.LocalDateTime;

public class Loan {

    private LocalDateTime loanDate;
    private Borrower borrower;
    private Book book;

    public Loan(LocalDateTime loanDate, Borrower borrower, Book book) {
        this.loanDate = LocalDateTime.now();
        this.borrower = borrower;
        this.book = book;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return borrower.getName() + " lånade: " + book.getTitle() + " den: " + loanDate;
    }
}
