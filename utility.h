//Matrix dim
#define M 500
#define N 400
#define P 600

struct matrix {
    float* ptr;
    int row;
    int col;
};

struct args {
    int thread_n;
    int block_size;
};

struct matrix A;
struct matrix B;
struct matrix C;
struct matrix R1;
struct matrix R2;

typedef struct args* Args;

pthread_barrier_t barrier;

//-----------------------[Matrix Functions]---------------------------
void createMatrix(struct matrix* m, int r, int c, int zero) {
    m->row = r;
    m->col = c;
    
    m->ptr = (float*)malloc(m->row * m->col * sizeof(float));

    if (m->ptr == NULL) {
        printf("createMatrix : malloc");
        exit(-1); 
    }      
    
    if(zero == 0)
    {
        for (int i=0; i < m->row * m->col; ++i)
            m->ptr[i] = 0;
    }
    else
    {
        for (int i=0; i < m->row * m->col; ++i)
            m->ptr[i] = ((float)(rand() % 100) / 10);
    }
    
}

void printMatrix(struct matrix* m){
    for(int i=0; i < m->row; i++)
    {
        for(int j=0; j < m->col; j++)
        {
            printf("%.2f\t", m->ptr[i * m->col + j] );
        }
        printf("\n");
    }
    printf("\n");
}

void* Matrix_x_Matrix(void* args){
    Args arg = args;
    float res = 0.0;
    
    for (int i = arg->thread_n; (i < A.row) && i < ((arg->thread_n * arg->block_size)+arg->block_size) ; ++i) 
    {
        for(int j=0; j<B.col; ++j)
        {
            res = 0.0;
            
            for(int x=0; x<A.col; ++x)
            {
                res += A.ptr[i * A.col + x] * B.ptr[x * B.col + j];
            }
            R1.ptr[i * R1.col + j] = res;
        }
    }
    
    pthread_barrier_wait(&barrier);
    
    for (int i = arg->thread_n; (i < C.row) && i < ((arg->thread_n * arg->block_size)+arg->block_size) ; ++i) 
    {
        for(int j=0; j<R1.col; ++j)
        {
            res = 0.0;
            
            for(int x=0; x<C.col; ++x)
            {
                res += C.ptr[i * C.col + x] * R1.ptr[x * R1.col + j];
            }
            R2.ptr[i * R2.col + j] = res;
        }
    }
    
    pthread_barrier_wait(&barrier);
}
