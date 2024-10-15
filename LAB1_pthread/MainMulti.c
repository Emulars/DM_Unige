//Programma multi-thread per il calcolo della moltiplicazione tra matrici
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include "utility.h"

int main()
{
    srand(time(NULL));

    double time_spent = 0.0;    // to store the execution time of code
    int printM=0;               //Print yes or no

    //const int M = 500, N = 400, P = 300;
    
    //find lower and higher size 
    int min = (M < N) ? ((M < P) ?  M : P ) : N;
    int max = (M > N) ? ((M > P) ?  M : P ) : N;

    //Calculate the number of thread
    const int nThread = (max % min) == 0 ? max/min : (max/min)+1;
    
    //Inizialize thread array
    pthread_t tid[nThread];
    
    struct args* arguments = (struct args*)malloc(nThread * sizeof(struct args));  
    
    printf("Stampare le matrici? Si[1] No[0]: ");
    scanf("%d",&printM);
    
    createMatrix(&A, M, N, 1);
    createMatrix(&B, N, P, 1);
    createMatrix(&C, P, M, 1);
    
    createMatrix(&R1, M, P, 0);
    createMatrix(&R2, P, P, 0);
    
    //Inizialize pthread barrier
    pthread_barrier_init(&barrier, NULL, nThread);
    
    //Starting time
    clock_t begin = clock();
    
    for (int i = 0; i < nThread; ++i)
    {
        arguments[i].thread_n = i;
        arguments[i].block_size = min;
        
        //Create and start thread + check 
        if( pthread_create(&tid[i], NULL, Matrix_x_Matrix, &arguments[i]) != 0)
        {
            fprintf(stderr, "Errore: thread # %d non creato\n", i);
            exit(1);
        }
    }
    
    void* returnCode;
    for (int i = 0; i < nThread; ++i)
    {
        if (pthread_join(tid[i], &returnCode) != 0)
        {
            fprintf(stderr, "Errore: impossibile joinare thread # %d\n", i);
            exit(1);
        }
    }
    
    //Ending time
    clock_t end = clock();
    
    if(printM == 1)
    {
        printf("Matrice A:\n");
        printMatrix(&A);
        printf("Matrice B:\n");
        printMatrix(&B);
        printf("Matrice C:\n");
        printMatrix(&C);
        printf("Matrice R1:\n");
        printMatrix(&R1);
        printf("Matrice R2:\n");
        printMatrix(&R2);    
    }
    
    //Clean
    free(A.ptr);
    free(B.ptr);
    free(C.ptr);
    free(R1.ptr);
    free(R2.ptr);
    free(arguments);

    //Destory the barrier
    pthread_barrier_destroy(&barrier);
    
    // calculate elapsed time by finding difference (end - begin) and
    // dividing the difference by CLOCKS_PER_SEC to convert to seconds
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
 
    printf("Esecuzione con %d thread -> Tempo trascorso: %f secondi\n", nThread, time_spent);
    
    exit(0);
}

