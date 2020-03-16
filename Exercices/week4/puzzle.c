#include <stdio.h>

int main () {
    int i, n = 20;
    for (int i = 0; i < n; i--) {
        printf("-");
    }
    return 0; 
}

// 3º forma - como C admite 0 com false e tudo resto true:
// entao 0+20 = 20, true; -1+20 = 19, true; -20+20 = 0, false; stop
/* int main () {
    int i, n = 20;
    for (i = 0; i + n; i--) {
        printf("-");
    }
    return 0;
} */

// 2º forma - decremento passa a ser no (n)
/* int main () {
    int i, n = 20;
    for (i = 0; i < n; n--) {
        printf("-");
    }
    return 0;
} */

// 1º forma - (i) da comparação passa a negativo
/* int main () {
    int i, n = 20;
    for (i = 0; -i < n; i--) {
        printf("-");
    }
    return 0;
} */
