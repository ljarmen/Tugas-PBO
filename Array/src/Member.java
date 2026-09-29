public class Member {
    private String firstName;
    private String lastName;
    private Book[] borrowedBooks = new Book[5];
    private int numberOfBorrowedBooks = 0;

    public Member(String f, String l) {
        firstName = f;
        lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addBorrowedBook(Book book) {
        if (numberOfBorrowedBooks < borrowedBooks.length) {
            borrowedBooks[numberOfBorrowedBooks++] = book;
        }
    }

    public void removeBorrowedBook(int index) {
        if (index >= 0 && index < numberOfBorrowedBooks) {
            for (int i = index; i < numberOfBorrowedBooks - 1; i++) {
                borrowedBooks[i] = borrowedBooks[i + 1];
            }
            borrowedBooks[numberOfBorrowedBooks - 1] = null;
            numberOfBorrowedBooks--;
        }
    }

    public Book getBorrowedBook(int index) {
        return borrowedBooks[index];
    }

    public int getNumOfBorrowedBooks() {
        return numberOfBorrowedBooks;
    }
}
