package se.iths.sebastian.libaryapp;

import se.iths.sebastian.libaryapp.model.Author;
import se.iths.sebastian.libaryapp.model.Book;
import se.iths.sebastian.libaryapp.model.Borrower;
import se.iths.sebastian.libaryapp.model.Loan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        Author author1 = new Author("Margareta");
        Author author2 = new Author("LIlly");

        List<Borrower> borrowers = new ArrayList<>();
        borrowers.add(new Borrower("Gamer 23", "Lösenord12345!", "Kalle"));
        borrowers.add(new Borrower("Fizen", "grabben123", "Sebbe"));
        List<Book> books = new ArrayList<>();
        books.add(new Book("Hopp", 56745855, author1));
        books.add(new Book("Tro", 48655855, author1));
        books.add(new Book("Frihet", 78955655, author2));
        List<Loan> loans = new ArrayList<>();

        boolean appRunner = true;
        while (appRunner){

            Borrower currentBorrower = login(borrowers );
            if (currentBorrower == null ){

                appRunner = false;
            }
        }

    }



        public static Borrower login (List<Borrower> borrowers) {

        IO.println("Skriv in inlogg");

        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");
        Borrower currentBorrower = null;

        for(Borrower borrower:borrowers){

            if (borrower.getUsername().equals(username) && borrower.getPassword().equals(password));
            currentBorrower = borrower;
        }


            return currentBorrower;
        }
}
