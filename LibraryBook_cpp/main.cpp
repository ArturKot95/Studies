#include <iostream>
#include "Book.h"

using namespace std;

int main() {
    Book * b1 = new Book();
    Book * b2 = new Book(2010, "BOOOOOK");

    b1->borrowIt();
    b1->returnIt();

    delete b1;
    delete b2;
    return 0;
}
