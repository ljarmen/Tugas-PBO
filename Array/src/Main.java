import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Library library = new Library();

        // Tambah beberapa buku ke perpustakaan
        library.addBook("Pemrograman Java Dasar");
        library.addBook("Struktur Data dan Algoritma");
        library.addBook("Basis Data");
        library.addBook("Jaringan Komputer");
        library.addBook("Sistem Operasi");

        System.out.println("=== Selamat Datang di Perpustakaan ===");
        System.out.print("Nama depan: ");
        String f = input.nextLine().trim();
        System.out.print("Nama belakang: ");
        String l = input.nextLine().trim();

        library.addMember(f, l);
        Member member = library.getMember(0);

        System.out.println("\nAnggota terdaftar: " + member.getFirstName() + " " + member.getLastName());

        int choice;
        do {
            printMenu();
            choice = readInt(input, "Pilih menu: ");

            switch (choice) {
                case 1:
                    System.out.println("\n--- Daftar Buku ---");
                    for (int i = 0; i < library.getNumOfBooks(); i++) {
                        Book book = library.getBook(i);
                        String status = book.isBorrowed() ? "[Dipinjam]" : "[Tersedia]";
                        System.out.println((i + 1) + ". " + book.getTitle() + " " + status);
                    }
                    break;

                case 2:
                    System.out.println("\n--- Buku Tersedia ---");
                    int countAvailable = 0;
                    for (int i = 0; i < library.getNumOfBooks(); i++) {
                        Book book = library.getBook(i);
                        if (!book.isBorrowed()) {
                            System.out.println((i + 1) + ". " + book.getTitle());
                            countAvailable++;
                        }
                    }
                    if (countAvailable == 0) {
                        System.out.println("Tidak ada buku yang tersedia.");
                        break;
                    }
                    int borrowIndex = readInt(input, "Pilih nomor buku yang ingin dipinjam: ") - 1;
                    if (borrowIndex >= 0 && borrowIndex < library.getNumOfBooks()) {
                        Book selectedBook = library.getBook(borrowIndex);
                        if (selectedBook.borrow()) {
                            member.addBorrowedBook(selectedBook);
                            System.out.println("Berhasil meminjam: " + selectedBook.getTitle());
                        } else {
                            System.out.println("Buku sudah dipinjam oleh orang lain.");
                        }
                    } else {
                        System.out.println("Nomor buku tidak valid.");
                    }
                    break;

                case 3:
                    if (member.getNumOfBorrowedBooks() == 0) {
                        System.out.println("\nAnda tidak memiliki buku yang dipinjam.");
                        break;
                    }
                    System.out.println("\n--- Buku yang Dipinjam ---");
                    for (int i = 0; i < member.getNumOfBorrowedBooks(); i++) {
                        System.out.println((i + 1) + ". " + member.getBorrowedBook(i).getTitle());
                    }
                    int returnIndex = readInt(input, "Pilih nomor buku yang ingin dikembalikan: ") - 1;
                    if (returnIndex >= 0 && returnIndex < member.getNumOfBorrowedBooks()) {
                        Book returnedBook = member.getBorrowedBook(returnIndex);
                        returnedBook.returnBook();
                        member.removeBorrowedBook(returnIndex);
                        System.out.println("Berhasil mengembalikan: " + returnedBook.getTitle());
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Buku yang Sedang Dipinjam ---");
                    if (member.getNumOfBorrowedBooks() == 0) {
                        System.out.println("Tidak ada buku yang sedang dipinjam.");
                    } else {
                        for (int i = 0; i < member.getNumOfBorrowedBooks(); i++) {
                            System.out.println((i + 1) + ". " + member.getBorrowedBook(i).getTitle());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih, " + member.getFirstName() + "! Sampai jumpa.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
            System.out.println();

        } while (choice != 0);

        input.close();
    }

    private static void printMenu() {
        System.out.println("=============================");
        System.out.println("     MENU PERPUSTAKAAN       ");
        System.out.println("=============================");
        System.out.println("1. Lihat Daftar Buku");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Lihat Buku Dipinjam");
        System.out.println("0. Keluar");
    }

    private static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }
}
