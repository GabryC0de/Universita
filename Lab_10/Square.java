import java.awt.Rectangle;

public class Square extends Rectangle {

    public int[] position = new int[2];
    public int sideLen;

    public Square(int[] coord, int len) {
        super((coord[0] - len / 2), (coord[1] - len / 2), len, len);
    }

    public int getArea() {
        return (this.height * this.height);
    }

    public void setSize(int width, int height) {
        if (width == height) {
            super.setSize(width, height);
        } else {
            throw new IllegalArgumentException("I parametri inseriti non sono validi!");
        }
    }

    public void setSize(int Dim) {
        super.setSize(Dim, Dim);
    }
}

// Realizzare una classe Square che estenda la classe Rectangle della libreria
// standard. La classe deve realizzare i seguenti comportamenti:

// Il costruttore crea un quadrato ricevendo come parametri espliciti le
// coordinate (x,y) del centro del quadrato, e la dimensione del quadrato
// (ovvero la lunghezza del lato). Per realizzare il costruttore sarà necessario
// invocare costrutttori e/o metodi della classe Rectangle (si consiglia in
// particolare di studiare la documentazione dei metodi setLocation e setSize
// della classe Rectangle). Osservare anche che, dal momento che che i campi x,
// y, width, height di Rectangle sono tutti di tipo int, il posizionamento del
// centro del quadrato avrà una approssimazione di ±1.
// La classe possiede un nuovo metodo getArea(), che calcola e restituisce
// l'area del quadrato.
// La classe sovrascrive il metodo setSize(int width, int height) della classe
// Rectangle (studiarne la documentazione): se width=height, il metodo esegue
// correttamente ridimensionando il quadrato alla nuova dimensione width,
// altrimenti lancia un'eccezione di tipo IllegalArgumentException.
// La classe possiede un nuovo metodo setSize(int dim), che esegue il
// ridimensionamento del quadrato sulla base dell'unico parametro esplicito dim.