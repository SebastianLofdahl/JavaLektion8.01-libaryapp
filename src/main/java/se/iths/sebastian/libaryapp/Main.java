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
        books.add(new Book("Hopp", "56745855", author1));
        books.add(new Book("Tro", "48655855", author1));
        books.add(new Book("Frihet", "78955655", author2));
        List<Loan> loans = new ArrayList<>();

        boolean appIsRunning = true;
        while (appIsRunning) {

            Borrower currentBorrower = login(borrowers);
            if (currentBorrower == null) {

                appIsRunning = false;
                continue;
            }

            boolean loggedIn = true;

            while (loggedIn) {
                IO.println("-- Meny --");
                IO.println("1. Lista av alla böcker");
                IO.println("2. Låna bok");
                IO.println("3. Lista alla lån");
                IO.println("4. Logga ut");
                IO.println("5. Avsluta");

                String choice = IO.readln("Välj mellan 1-5: ");

                switch (choice) {
                    case "1" -> listBooks(books);
                    case "2" -> borrowBook(books, loans, currentBorrower);
                    case "3" -> listLoans(loans);
                    case "4" -> {
                        IO.println("Loggas ut");
                        loggedIn = false;
                    }
                    case "5" -> {
                        loggedIn = false;
                        appIsRunning = false;
                    }
                    default -> IO.println("Error! Väl endast 1 eller 2.");
                }
            }

        }

        IO.println("Programet avslutas");
    }

    private static void listBooks(List<Book> books) {
        for (Book book : books) {
            IO.println(book);
        }
    }

    private static Borrower login(List<Borrower> borrowers) {
        IO.println("-- Logga in --");
        String username = IO.readln("Username: ");
        String password = IO.readln("Password: ");

        Borrower currentBorrower = null;

        for (Borrower borrower : borrowers) {
            if (borrower.getUsername().equals(username) && borrower.getPassword().equals(password)) {
                currentBorrower = borrower;
                break;
            }
        }

        if (currentBorrower != null) {
            IO.println("Inloggad som: " + currentBorrower);
        } else {
            IO.println("Error! Fel användarnamn eller lösenord");
        }

        return currentBorrower;
    }

    private static void listLoans(List<Loan> loans) {
        if (loans.isEmpty()) {
            IO.println("Finns inga lån att se här än");
            return;
        }

        for (Loan loan : loans) {
            IO.println(loan);
        }
    }

    private static void borrowBook(List<Book> books, List<Loan> loans, Borrower currentBorrower) {
        String isbn = IO.readln("ISBN: ");

        Book foundBook = null;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                foundBook = book;
                break;
            }
        }

        if (foundBook == null) {
            IO.println("Finns ingen bok med det ISBN nummret");
            return;
        }

        boolean alreadyLoaned = false;

        for (Loan loan : loans) {
            if (loan.getBook() == foundBook) {
                alreadyLoaned = true;
                break;
            }
        }

        if (alreadyLoaned) {
            IO.println("Booken är redan utlånad");
            return;
        }

        Loan newLoan = new Loan(currentBorrower, foundBook);
        loans.add(newLoan);
        IO.println("Du har lånat: " + foundBook.getTitle());
    }

}
