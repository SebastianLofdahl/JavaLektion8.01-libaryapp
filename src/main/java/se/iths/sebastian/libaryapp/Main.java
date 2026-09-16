package se.iths.sebastian.libaryapp;

import se.iths.sebastian.libaryapp.model.Author;
import se.iths.sebastian.libaryapp.model.Book;

public class Main {
    static void main() {
        Author author = new Author("HP.Lovecraft");
        Book book = new Book("Call of Cuthulu", 123, author);
        IO.println(book);

    }
}
