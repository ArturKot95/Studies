#ifndef LIBRARYBOOK_BOOK_H
#define LIBRARYBOOK_BOOK_H

#include <string>

class Book {
private:
    int publicationYear = 2005;
    enum STATUS {
        AVAILABLE,
        LOST,
        BORROWED
    };
    STATUS status = AVAILABLE;
    char title[101] = "unknown";
    int bNumber = 0;
public:
    Book();
    Book(int publicationYear, char *title);
    ~Book();
    void printMe();

    bool borrowIt();
    bool returnIt();
    bool looseIt();
};


#endif //LIBRARYBOOK_BOOK_H
