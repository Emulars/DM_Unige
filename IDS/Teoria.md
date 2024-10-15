# Dati

-  **Strutturati**: Dati organizzati e ben ordinati in tabelle.

-  **Non Strutturati**: Dati come entità libere, non seguono alcuna organizzazione (testi).


-  **Quantitativi**: Dati rappresentati da numeri.

	-  	**Discreti**: Possono essere contati e possono assumere solo deteriminati valori

	-  **Continui**: devono essere misurati e possono assumere una gamma infinta di valori.

-  **Qualitativi**: Dati descrivibili usando il linguaggio naturale.

  

## 4 Livelli dei Dati

  

-  **Nominale**: Dati qualitativi come nomi o categorie.

	- Operazioni = Uguagliazna, appartenenza ad un insieme, moda (valore + frequente).

  

-  **Ordinale**: Dati qualitativi ordinabili secondo dei criteri (es: indice di gradimento).

	- Operazioni = Op del Nominale, ordinament, confronto, mediana (valore in posizione centrale nella distribuzione).

  

-  **Intervalli**: Dati quantitativi

	- Operazioni = Precedenti, somma, sottrazione, media e deviazione standard (distanza di un punto rispetto alla media).

  

-  **Rapporti**: Dati quantitativi su cui ha senso calcolare anche moltiplicazioni e divisioni. *hanno un valore iniziale o uno zero naturale ma i valori NON devono essere negativi*.

  

## 5 Passi della Data Science

  

1. Porre una domande interessante

2. Ottenere i dati

3. Esplorare i dati

4. Creare un modello per i dati

5. Comunicare e presentare i dati.

  

<div  style="page-break-after: always;"></div>

  

# Statistica

  

## Bayes

  

<img  src="https://www.eage.it/data/eage/teorema-di-bayes-formula.gif"  width="50%">

  

Permette di aumentare la conoscenza a posteriori sulla base della conoscenza a priori.

  

## Correlazione tra dati

  

**Obiettivo**: Per comprendere meglio il problema e formulare delle ipotesi.

I *Coefficienti di correlazione* sono una misura quantitativa che descrive l'intensità della correlazione (o relazione) tra due variabili.

  

Tipi di associazione:

  

- Positiva: Al crescere di uno, cresce anche l'altro (valore vicino a 1).

- Negativa: Al crescere di uno, diminuisce l'altro (valore vicino a -1).

- Nulla: Non cresce né diminuisce l'altro (valore 0).

  

## Stima dei punti

  

Una stima di un punto è una stima di un parametro della popolazione sulla base dei dati di un campione (es. la media).

  

## Distribuzione di campionamento

  

Una distribuzione delle stime di più campioni di uguale dimensione si:

  

- Campiona N volte un insieme di M campioni

- Costruisce un istogramma delle N stime calcolate

  

## Intervallo di confidenza

  

Intervallo di valori basato su una stima che sappiamo contenere il vero parametro della popolazione con un certo grado di confidenza.

Il livello diconfidenza rappresenta la frequenza con cui la risposta ottenuta è accurata (probabilità % che l'intervallo contenga il valore esatto).

  

## Verifica dell'ipotesi

  

Test statistico per valutare se possiamo presumere che una determinata condizione sia vera per l'intera popolazione dato un campione limitato di dati.

Il test ci dice se possiamo accettare o rigettare l'ipotesi:

  

1. Specificare ipotesi nulla e alternativa

2. Determinare le dimensioni del campio per il test

3. Scegliere un livello di significatività (solitamente 0.05)

4. Racogliere i dati

5. Rigettare o accettare ipotesi nulla

  

## T-Test

  

Test statistico per determinare se un campione di dati quantitativi differisce in modo significativo da un altro dataset, inoltre si devono verificare due condizioni importanti:

  

- La distribuzione della popolazione deve essere normale e il campione deve essere composto da più di 30 elementi.

- La dimensione della popolazione deve essere 10 volte maggiore alla dimensione del campione.

  

Dall'esecuzione del T-test otteniamo due valori:

  

- T-test: Deviazione della media del campione rispetto all'ipotesi nulla

- P-value: Frequenza con cui il risultato ottenuto si otterrebbe per caso.

  

Inoltre grazie al P-value possiamo:

  

- Accettare l'ipotesi nulla, se p-value > livello di significatività

- Rifiutare l'ipotesi nulla, se p-value < livello di significatività


## Chi-Quadrato idoneità

  

Conteggio su variabili qualitative, lo usiamo quando vogliamo:

  

- Analizzare una variabile categorica da una popolazione

- Determinare se una variabile segue una certa distribuzione, specificata o attesa

  
<img  src="chi_quadrato_1.jpg"  width="50%">

  

## Chi-Quadrato Associazione/Indipendenza

  

Per determinare se due variabili categoriche sono indipendenti tra loro.

  

## Condizioni per Chi-Quadrato

  

- Tutti i conteggi previsti devono essere almeno 5

- Le singole osservazioni devono essere indipendenti e la popolazione deve esserealmeno 10 volte il campione

  

- Grado di libertà = Conteggi previsti - 1

- Accettiamo l'ipotesi nulla se P-value < valore del chi-quadrato

- Rifiutiamo l'ipotesi nulla se P-value > valore del chi-quadrato</br></br></br>

  

<div  style="page-break-after: always;"></div>

  

# Comunicare i dati

  

## Grafici a dispersione

  

Utili per evidenziare relazioni esistenti tra variabili e se possibile rivelarne una correlazione.

  

## Grafici a linee

  

Usati per monitorare l'andamento nel tmepo di una variabile quantitativa.

Gomito = Punto di cambio drastico di un grafico.

  

## Diagrammi a barre

  

Utilizzati per confrontare variabili suddivise in gruppi.

  

## Istogrammi

  

Servono per rappresentare e visualizzare la distribuzione di frequenza di una variabile quantitativa, raggruppando i dati in interavalli (bin) equivalenti.

  

## Box-plot

  

Vengono utilizzati per mostrare una distribuzione di valori e mettono in evidenza 5 diverse quantità:

  

- Il valore minimo

- Il primo quartile (25%) -> Valore che separa il 25% di valori più bassi da tutti gli altri.

- La mediana

- Il terzo quartile (75%) -> Valore che separa il 25% di valori più alti da tutti gli altri.

- Il valore massimo

  

Il quadrato è chiamato **Range Interquartile** o IQR e contiene il 50% centrale delle osservazioni effettuate; mentre i "baffi" segnano il valore minimo e massimo oppure sono i valori pari a IQR +- (IQR * 1.5).

Inoltre i valori al di fuori dei baffi sono detti **outliers**.

  

## Grafici a violino

  

Servono a rappresentare la distribuzione dei dati e la loro densità.

  

# Correlazione e Causalità

  

**La correlazione NON implica causalità**

  

## Il paradosso di Simpson

  

Anche se un grafico evidenzia una correlazione positiva tra due variabili, esse possono diventare anti-correlate prendendo in considerazione un altro fattore (di confusione).

  

<div  style="page-break-after: always;"></div>

  

# Metodi predittivi

  

**Machine Learning**:

Classe di metodi in grado di imparare da esempi invece di essere esplicitamente programmati a fare qualcosa.

  

## Machine Learning Supervisionato

  

Abbiamo un **training set**, ossia un insieme di dati (coppie input-output) da cui i modello imparerà.

  

Lo scopo è stimare una funzione *f* tale che $f(x^k)=y^k$ per ogni $(x^k, y^k)$ appartenente all'insieme.

  

La funzione che cerchiamo deve avere due importanti proprietà:

  

-  **Fitting**: Capacità di rappresentare i dati di training

-  **Stability/Generalization**: Capacità di generalizzare ai dati che avremo in futuro

  

### Regressione Lineare

  

Cerchiamo una relazione lineare tra input e output.

  

Per valutare la qualità della funzione stimata dividiamo il training set in due:

  

- Usiamo il 70% dei dati per l'allenamento

- ed il 30% restante per la fase di validazione/test

  

Successivamente possiamo calcolare l'**errore quadratico medio o la sua radice** e confrontarli con quelli del **modello nullo**.

<img src="https://miro.medium.com/max/966/1*lqDsPkfXPGen32Uem1PTNg.png" width="40%">


  

Il quadrato amplifica le differenze grandi e riduce quelle piccole.

  

### Regressione Logistica

  

Si tratta di una generalizzazione del modello di regressione lineare ai problemi di **classificazione**, prevedendo la probabilità che il dato appartenga ad una certa classe.

  

**Odds**:

  

- Probabilità che un dato appartenga ad una certa classe.

- L'Odds di un evento è il rapporto tra la sua probabiltà *p* e la probabilità che non accada *(1-p)*

  

<div  style="page-break-after: always;"></div>

  

## Machine Learning Non Supervisionato

  

Il training set non contiene più gli output desiderati.

  

### Clustering

  

L'obbiettivo è raggruppare i dati secondo misure di distanza o similarità in base al task. Abbiamo due elementi importanti:

  

- Cluster: Grupo di dati che si comporta in modo analogo

- Centroide: Punto medio del cluster

- K: Numero di cluster che vogliamo identificare

  

#### Algoritmo K-Means procedimento

  

1. Scegliamo K centroidi iniziali o a caso dal dataset (K-Means ++) o dal piano

2. Per ogni punto assegnarlo al centroide più vicino (Distanza Euclidea)

3. Per ogni centroide aggiornare la sua posizione (centroide = media dei punti appartenenti al cluster)

4. Ripetere punti (2) e (3) fino a raggiungere un **criterio di arresto**

  

#### Criterio di arresto

  

- Soluzione stupida: Impostare un numero massimo di iterazioni

- Soluzione alternativa: Impostare una distanza minima di spostamento per i centroidi

  

#### Valutare la qualità dei risultati

  

**La scelta del numero di cluster è critica!**

  

La qualità la calcoliamo con il **Coefficiente di Silhoutte**, che è un valore compreso tra 1 e -1, più è vicino a 1, più è buono il risultato.

  

$SC = (b-a)/max(a,b)$

  

- a: Distanza media intracluster, Cluster compatto, Meglio se valore basso

- b: Distanza media extracluster, Cluster ben separati tra loro, Meglio se valore alto.

  

### Dendrogramma

  

Inizialmente ogni punto è un cluster singolo, successivamente i cluster vengono ricorsivamente raggruppati in base alla vicinanza tra i punti al loro interno.

  
<img src="https://www.meccanismocomplesso.org/wp-content/uploads/2013/12/dendrogrammaXY-300x252.jpg" width="40%">

  

Per evitare che diventi un unico cluster, potremmo fissare una soglia sulla distanza massima tra i punti

  

<div  style="page-break-after: always;"></div>

  

# Curse of Dimensionality

  

Quando i dati vengono rappresentati con un numero di caratteristiche troppo elevato rispetto al numero di dati, si ha una **dimensionality explosion**.

  

Maggiore è il numero di caratteristiche usate per la rappresentazione di un dato, più i dati stessi risultano essere distanti gli uni dagli altri.

  

Quando le caratteristiche sono troppe rispetto alle reali necessità rischiamo di non migliorare la capacità descrittiva della rappresentazione e anzi peggiorare i risultati.

  

Perché i risultati siano affidabili il numero di dati (N) deve crescere esponenzialmente con il numero di caratteristiche (D).

  

# PCA - Analisi delle componenti principali

  

## Proprietà desiderabili per buone rappresentazioni

  

- Varianza alta: Caratteristiche con varianza alta contegono "molto segnale". La variabile presa in considerazione è in grado di rappresentare in modo discriminativo il dato che stiamo cercando di rappresentare.

  

- Non correlazione: Caratteristiche correlate sono ridondanti e poco informative. Non dobbiamo avere proprietà calcolabili o riconducibili.

  

- Non troppe: Il numero di dati e dimensionalità devono essere bilanciati.

  

## Decomposizione a valori singolari (SVD)

  

In algebra lineare, la SVD, è una particolare fattorizzazione di una matrice basata sull'uso di autovalori e autovettori. Data una matrice M reale o complessa di dimensione *m × n* si tratta di una scrittura del tipo:

$C = U \sum V^T$
  

## PCA

  

Algoritmo applicabile a matrici di dati di qualunque dimensione NxD, permette di identificare una nuova base le cui componenti catturano quanta più varianza possibile daidati originali.

  

Passaggi:

  

1. Costruiamo la matrice di covarianza dei dati C = X^T * X

2. Calcoliamo la sua SVD

3. Identifichiamo la nuova base: le prime K colonne di B, se vogliamo utilizzare K componenti principali.

- K = numero di dimensioni che vogliamo mantenere

  

## Explained Variance

  

Ci permette di capire il grado di correlazione tra il numero di componenti/proprietà e la percentuale di infromazione che ci forniscono per raggiungere la totalità dell'informazione del dataset.

![enter image description here](https://journals.plos.org/ploscompbiol/article/file?id=10.1371/journal.pcbi.1008851.g004&type=large)

  
Se le prime *n* componenti raggiungono il 100% vuol dire che sono quelle a dare la totalità delle informazioni.