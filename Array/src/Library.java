public class Library {
    private Book[] books;
    private int numberOfBooks;
    private Member[] members;
    private int numberOfMembers;

    public Library() {
        books = new Book[20];
        numberOfBooks = 0;
        members = new Member[10];
        numberOfMembers = 0;
    }

    public void addBook(String title) {
        if (numberOfBooks < books.length) {
            books[numberOfBooks] = new Book(title);
            numberOfBooks++;
        }
    }

    public int getNumOfBooks() {
        return numberOfBooks;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void addMember(String f, String l) {
        if (numberOfMembers < members.length) {
            members[numberOfMembers] = new Member(f, l);
            numberOfMembers++;
        }
    }

    public int getNumOfMembers() {
        return numberOfMembers;
    }

    public Member getMember(int index) {
        return members[index];
    }
}
