public class Book{

    private String author, title, isbn;

    public Book(){}

    public Book(String a, String t, String i){
        author = a;
        title = t;
        isbn = i;
    }

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public String getISBN(){
        return isbn;
    }

    public void setAuthor(String neww){
        author = neww;
    }

    public void setTitle(String neww){
        title = neww;
    }

    public void setISBN(String neww){
        isbn = neww;
    }

    public String toString(){
        return "Author: " + author + "\nTitle: " + title + "\nISBN: " + isbn;
    }
}