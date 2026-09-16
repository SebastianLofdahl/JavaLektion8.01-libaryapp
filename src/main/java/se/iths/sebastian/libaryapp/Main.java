package se.iths.sebastian.libaryapp;

import se.iths.sebastian.libaryapp.model.Author;
import se.iths.sebastian.libaryapp.model.Book;
import se.iths.sebastian.libaryapp.model.Borrower;
import se.iths.sebastian.libaryapp.model.Loan;

import java.time.LocalDateTime;

public class Main {
    static void main() {
        Author author = new Author("HP.Lovecraft");
        Book book = new Book("Call of Cuthulu", 123, author);
        IO.println(book);

        Borrower borrower = new Borrower("gamer 23", "Lösrenord12345!", "Kevin");

        IO.println(borrower);

        Loan loan = new Loan(LocalDateTime.now(), borrower, book);
        IO.println(loan);


    }
}
