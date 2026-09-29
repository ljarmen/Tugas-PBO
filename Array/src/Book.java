public class Book {
    private String title;
    private boolean isBorrowed;

    public Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public boolean borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            return true;
        } else {
            return false;
        }
    }
}
