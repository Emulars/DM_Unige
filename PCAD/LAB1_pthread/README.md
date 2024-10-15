# Foglio 1
## Gruppo: 404 - Group not found
- Davide Miggiano - 4840761
- Filippo Manini - 4798004
## Note finali
Se si desidera cambiare le dimensioni delle matrice per fare più test, basta modificare i valori dei define (M, N e P) all'inizio del file utility.h.

Avendo eseguito dei test temporali abbiamo potuto notare come, all'aumentare delle dimensioni delle matrici, nella gestione multithreading si ottengano degli ottimi tempi grazie alla suddivisione in blocchi di esecuzione.
Bisogna però prestare attenzione a non creare troppi blocchi gestiti ognuno da un thread diverso, poiché la creazione di un elevato numero di thread rallenterà l'esecuzione del programma.