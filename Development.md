# Diario di Sviluppo - Pong in Java

## Giorno 1: Pianificazione e Setup del Progetto

- Ho deciso di creare Pong in Java per migliorare la mia comprensione di Swing e della gestione del ciclo di gioco, poiché ritengo che sviluppare un gioco semplice ma completo sia un ottimo modo per padroneggiare questi concetti fondamentali inoltre, mi ha sempre divertito molto da bambino, insieme a classici come Snake e Tetris, il che mi ha motivato ulteriormente a svilupparlo.

- Ho impostato la struttura base del progetto con le seguenti classi, per mantenere il codice organizzato e facilmente manutenibile:

  - `GamePanel`: Gestisce il ciclo di gioco e il rendering.
  - `Player`: Rappresenta il paddle del giocatore.

- Ho scelto di utilizzare `JPanel` per il rendering grafico perché è leggero e flessibile.

## Giorno 2: Implementazione del Giocatore

- Ho creato la classe `Player` per rappresentare il paddle del giocatore.
- Ho collegato `KeyHandler` per gestire i movimenti del paddle tramite i tasti freccia.
- Ho implementato un `ComponentAdapter` per aggiornare la posizione del paddle quando la finestra viene ridimensionata.
- **Problemi Riscontrati:**
  - Inizialmente, il paddle si muoveva troppo velocemente. Ho risolto limitando la velocità per frame utilizzando una variabile di velocità massima e controllando l'incremento per ogni frame per evitare movimenti troppo rapidi.

## Giorno 3: Ciclo di Gioco e FPS Costanti

- Ho impostato il ciclo di gioco nel `GamePanel` utilizzando `Runnable` per garantire FPS costanti.
- Ho scelto di utilizzare un target di 60 FPS per mantenere un movimento fluido.
- Ho imparato come calcolare il tempo rimanente per ogni frame usando `System.nanoTime()`.
- **Problemi Riscontrati:**
  - Lag intermittente causato da `Thread.sleep()` impreciso. Ho risolto gestendo meglio il tempo rimanente per frame.

## Giorno ?: Ho perso il conto, quindi riparto da 1

## Giorno 1: Implementazione del Movimento della Pallina

- Ho creato una classe `Ball` per gestire la pallina nel gioco.
- Ho definito variabili per la posizione (`x`, `y`) e per la velocità (`dx`, `dy`).
- Ho implementato un metodo `update()` per aggiornare la posizione della pallina in base alla sua velocità.
- Ho aggiunto la logica di rimbalzo sui bordi superiore e inferiore dello schermo invertendo la velocità verticale.
- Per i calcoli del movimento, ho utilizzato semplici equazioni cinematiche: `x += dx` e `y += dy` ad ogni frame.

## Prossimi Passi

- Aggiungere la gestione delle collisioni tra pallina e paddle.
- Implementare il sistema di punteggio per entrambi i giocatori.
- Aggiungere suoni per rendere l'esperienza di gioco più coinvolgente (ad esempio, suono di rimbalzo e punto).
- Ottimizzare il codice per migliorare le prestazioni.
- Implementare un sistema di pausa e ripresa del gioco.
- Migliorare la grafica con effetti visivi semplici (es. scie o flash).
- Continuare a documentare ogni fase per avere un riferimento chiaro nei futuri progetti. la gestione delle collisioni tra pallina e paddle.
- Continuare a documentare ogni fase per avere un riferimento chiaro nei futuri progetti.

## Note Finali

Sto trovando utile documentare ogni passaggio, inclusi gli errori e le soluzioni, per comprendere meglio il processo di sviluppo.

