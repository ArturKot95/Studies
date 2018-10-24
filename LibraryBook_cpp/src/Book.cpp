#include "Book.h"

#include <iostream>
#include <string.h>

using namespace std;

Book::Book() {}
Book::Book(int publicationYear, char *title) {
    if (publicationYear >= 1900 && publicationYear <= 2015) {
        this->publicationYear = publicationYear;
    }

    int length = sizeof this->title;
    strncpy(this->title, title, length);
    strcat(this->title, "\0");
}
Book::~Book() {
    cout << "Destroyed book:" << endl;
    this->printMe();
}
void Book::printMe() {
    cout << "Book \"" << this->title << "\"" << endl;
    cout << "Status: " << this->status << endl;
    cout << "Publication year: " << this->publicationYear << endl;
    cout << "Was borrowed " << this->bNumber << " times." << endl;
}
bool Book::borrowIt() {
    if (this->status == AVAILABLE) {
        this->status = BORROWED;
        this->bNumber++;
        return true;
    }
    cout << "Book is actually borrowed." << endl;
    return false;
}
bool Book::returnIt() {
    if (this->status == BORROWED) {
        this->status = AVAILABLE;
        return true;
    }
    cout << "Book wasn't borrowed." << endl;
    return false;
}
bool Book::looseIt() {
    if (this->status == BORROWED || this->status == AVAILABLE) {
        this->status = LOST;
        return true;
    }
    cout << "Book is lost already." << endl;
    return false;
}
