//Programma sequenziale per il calcolo della moltiplicazione tra matrici.
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

void setUpMatrix();
void fillMatrix();
void printMatrix();
void Matrix_x_Matrix();

int main()
{
    srand(time(NULL));
    double time_spent = 0.0;    // to store the execution time of code
    
    const int M = 400, N = 500, P = 300;
    float A[M][N], B[N][P], C[P][M];
    float R1[M][P];   //Result of AxB
    float R2[P][P];   //Result of CxR1

    //Fill matrix with random values
    fillMatrix(M,N,A);
    fillMatrix(N,P,B);
    fillMatrix(P,M,C);
    setUpMatrix(M,P,R1);
    setUpMatrix(M,M,R2);    

    //Starting time
    clock_t begin = clock();
    
    //Compute AxB
    //printf("Matrice R1:\n");
    Matrix_x_Matrix(M,N,A,N,P,B,R1);
    //printMatrix(M,P,R1);

    //Compute Cx(AxB)
    //printf("Matrice R2:\n");
    Matrix_x_Matrix(P,M,C,M,P,R1,R2);
    //printMatrix(P,P,R2);
    
    //Ending time
    clock_t end = clock();
    
    // calculate elapsed time by finding difference (end - begin) and
    // dividing the difference by CLOCKS_PER_SEC to convert to seconds
    time_spent += (double)(end - begin) / CLOCKS_PER_SEC;
 
    printf("The elapsed time is %f second\ns", time_spent);

    return 0;
}


void setUpMatrix(int row, int column, float matrix[row][column]){
    for(int i=0; i<row; i++)
    {
        for(int j=0; j<column; j++)
        {
            matrix[i][j] = 0;
        }
    }
}

void fillMatrix(int row, int column, float matrix[row][column]){
    for(int i=0; i<row; i++)
    {
        for(int j=0; j<column; j++)
        {
            matrix[i][j] = ((float)(rand() % 100) / 10);;
        }
    }
}

void printMatrix(int row, int column, float matrix[row][column]){
    for(int i=0; i<row; i++)
    {
        for(int j = 0; j<column; j++)
        {
            printf("%2.f\t", matrix[i][j]);
        }
        printf("\n");
    }
    printf("\n\n");
}

void Matrix_x_Matrix(int row1, int column1, float M1[row1][column1], int row2, int column2, float M2[row2][column2], float R[row1][column2]){
    for(int i=0; i<row1; ++i)
    {
        for(int j=0; j<column2; ++j)
        {
            for (int k = 0; k < column1; ++k)
            {
                R[i][j] += M1[i][k] * M2[k][j];
            }
        }
    }
}
