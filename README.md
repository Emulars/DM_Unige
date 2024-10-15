# IDS_Video_Games
Progetto finale di Introduzione alla Data Science

Miggiano Davide - 4840761

---
[Dataset](https://www.kaggle.com/datasets/rishidamarla/video-game-sales)

---

## Costruzione del progetto

> Come abbiamo ragionato?

La domanda principale su cui si basa la strutturazione del progetto è *"Cosa ha causato l'impennata nelle vendite tra il 2000 e il 2010 e le vendite nelle diverse regioni del mondo sono correlate?"*.

Prima di tutto dopo aver compreso cosa fossero le diverse features nel dataset, ho voluto visualizzare tutte le vendite nelle diverse regioni geografiche, per comprenderne l'andamento tra il 1980 ed il 2020 e farmi un'idea sulla somiglianza o meno tra le diverse regioni.

Poi per capire se quelle vendite fossero date da tanti giochi diversi o da pochi, ho voluto visualizzare il numero di giochi rilasciati negli anni.
Unendo i due grafici possiamo notare come nel periodo tra il 2000 ed il 2010 ci sia stato un incremento nelle vendite ma anche nelle uscite dei giochi.
Inoltre ci permette di notare come dal 2017 circa ci sia proprio un crollo delle uscite e delle vendite, dovuto però a delle mancanze del nostro dataset e non ad eventi particolari nel mercato.

Tornando alle vendite tra il 2000 ed il 2010, mi sono chiesto se l'incremento nelle vendite potesse essere dato da qualche piattaforma in particolare, quindi ho visualizzato la distribuzione dei giochi e delle loro vendite per generi. Ho potuto notare come in entrambi i casi spiccassero tre piattaforme: PS2, DS e Wii, le quali sono uscite rispettivamente nel 2000, 2004 e 2006 e tutt'oggi queste console rientrano nella classifica delle piattaforme con il maggior numero di pezzi venduti.

Potrebbe essere quindi che l'uscita di queste tre piattaforme abbia portato una grande crescita al mercato in generale e che di consegunza abbia aumentato le vendite globali.
Lo controllo attraverso un t-test ad una coda (maggiore) con un livello di  confidenza del 95%, ottenendo che la media delle vendite gloabli delle piattaforme PS2, DS e Wii è maggiore rispetto a quella delle altre piattaforme.

Mentre per quanto riguarda la seconda parte della domande: "le vendite delle diverse regioni del mondo sono correlate tra loro?"
Attraverso l'utilizzo di alcuni grafici a dispersione tra le varie vendite ed un successivo controllo attraverso una funzione della libreria di pandas chiamata "corr" ho ottenuto la correlazione di Pearson tra queste variabili che esprime un'eventuale relazione di linearità tra quest'ultime.

> Quali sono state le difficoltà?

Le difficoltà maggiori sono state date dalla mancanza di numerosi dati per alcune feature del dataset come ad esempio i voti degli utenti e della critica ed il loro numero ma principalmente dalla quasi completa mancanza di giochi degli ultimi 5 anni.

> Quali sono i principali risultati ottenuti?

1. Com'è già detto ho potuto notare come il rilascio di alcune piattaforme abbia portato in breve tempo grande crescita a questo mercato

2. Come le vendite nelle diverse regioni del mondo sia correlate tra loro, sottolineando la forte correlazione tra le vendite globali e le vendite in Nord America.

3. E per concludere come i generi più apprezzati in generale siano gli Action e gli Sportivi ma anche come questo non valga per il Giappone dove il genere preponderante è il RPG.
