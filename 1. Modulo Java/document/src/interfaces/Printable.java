package interfaces;

import classes.Document;

public interface Printable {
    static void print(Document document) {
        System.out.println(document.toString());
    }
}
