package se.iths.sebastian.libaryapp;

import se.iths.sebastian.libaryapp.model.Author;
import se.iths.sebastian.libaryapp.model.Book;
import se.iths.sebastian.libaryapp.model.Borrower;
import se.iths.sebastian.libaryapp.model.Loan;

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

        boolean appIsRunning = true;
        while (appIsRunning) {

            Borrower currentBorrower = login(borrowers);
            if (currentBorrower == null) {

                appIsRunning = false;
            }

            boolean loggedIn = true;

            while (loggedIn) {
                IO.println("-- Meny --");
                IO.println("1. Lista av alla böcker");
                IO.println("2. Låna bok");
                IO.println("3. Avsluta");

                String choice = IO.readln("Välj mellan 1-2: ");

                switch (choice) {
                    case "1" -> listBooks(books);
                    case "2" -> borrowBook(books);
                    case "3" -> {
                        loggedIn = false;
                        appIsRunning = false;
                    }
                    default -> IO.println("Error! Väl endast 1 eller 2.");
                }
            }

        }

    }

    private static void listBooks(List<Book> books) {
        for (Book book : books) {
            IO.println(book);
        }
    }

    private static void borrowBook(List<Book> books) {
        String isbn = IO.readln("ISBN: ");

        Book foundBook = null;
        for (Book book : books) {
            foundBook = book;
            break;
        }
        if (foundBook == null) {
            IO.println("Ingen bok med det nummret hittades");
        }

    }


    public static Borrower login(List<Borrower> borrowers) {

        IO.println("Skriv in inlogg");

        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");
        Borrower currentBorrower = null;

        for (Borrower borrower : borrowers) {

            if (borrower.getUsername().equals(username) && borrower.getPassword().equals(password)) ;
            currentBorrower = borrower;
        }
        if (currentBorrower != null) {
            System.out.println("Inloggad som " + currentBorrower);
        } else {
            System.out.println("Fel username eller password.");
        }


        return currentBorrower;
    }
}
