// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class StudentSetTester{
	public static void main(String[] args){
      
	  // leggo il primo file con le coppie nome matricola
		try{
		  
			FileReader reader = new FileReader(args[0]);
			Scanner scan = new Scanner(reader);
		  
			StudentSet matricole = new StudentSet();
		  
			String line = "";
		  
			while(scan.hasNext()){
				line = scan.nextLine();
			  
				String name = line.substring(0, 16).trim();
				String surname = line.substring(16, 32).trim();
				int matNum = Integer.parseInt(line.substring(35, line.length()).trim());
			  
				Student currStudent = new Student(name, surname, matNum);
				matricole.add((Comparable)currStudent);
			}			
			
			System.out.println(matricole.toString());
			
			Scanner inScan = new Scanner(System.in);
			int count = 1;
			while(inScan.hasNext()){				
				String in = inScan.nextLine();
								
				String stringa1 = in.substring(0, in.indexOf(" ")).trim();
				String stringa2 = in.substring(in.indexOf(" "), in.length()).trim();
				
				Student s1Cmp = new Student(stringa1, "", 0);
				Student s2Cmp = new Student(stringa2, "", 0);
				
				SortedSet subset = matricole.subSet(s1Cmp, s2Cmp);
				String subsetStr = subset.toString();
								
				System.out.println("Subset " + count + " :");
				System.out.println("Dimensione = " + subset.size());
								
				System.out.println(subsetStr);
				count++;
			}
			scan.close();
			inScan.close();
			
		} catch(NoSuchElementException e){
			System.out.println(e);
		} catch(FileNotFoundException e){
			System.out.println(e);
		}
	  
    }
}


class StudentSet implements SortedSet{
    //costruttori e metodi pubblici ......da completare ......
	
	private int sSize;
	private static final int DEFAULT_LEN = 5;
	Student[] students;
	
	public StudentSet(){
		students  = new Student[DEFAULT_LEN];
		sSize = 0;
	}
	
	public boolean isEmpty(){
		return sSize == 0;
	}
	
	public void makeEmpty(){
		sSize = 0;
	}
	
	public int size(){
		return sSize;
	}
	

    public void add(Comparable obj){

        if (!(obj instanceof Student)) return;
        
        Student newStudent = (Student) obj;

        int i = 0;
        while (i < sSize && students[i].compareTo(newStudent) < 0) {
            i++;
        }

        if (i < sSize && students[i].compareTo(newStudent) == 0) {
            return; 
        }

        if (sSize == students.length) {
            students = resize();
        }

        for (int k = sSize; k > i; k--) {
            students[k] = students[k - 1];
        }

        students[i] = newStudent;
        sSize++;
    }
	
	public boolean contains(Comparable obj){
		if(!(obj instanceof Student)){
			return false;
		}

		Student student = (Student) obj;
		
		int low = 0;
		int high = sSize -  1;
		
		while(high >= low){
			int mid = (high + low) / 2;
			int cmp = students[mid].compareTo(student);
			
			if(cmp > 0){
				high = mid - 1;
			} else if(cmp < 0){
				low = mid + 1;
			} else {
				return true;
			}
		}
		return false;
		
	}
	
	public Comparable[] toArray(){
		Comparable[] arr = new Comparable[sSize];
		int position = 0;
		for(int i = 0; i < students.length; i++){
			if(students[i] != null){
				arr[position++] = students[i];
			}
		}
		return arr;
	}
	
	private Student[] resize(){
		Student[] newStudents = new Student[students.length * 2];
		System.arraycopy(students, 0, newStudents, 0, students.length);
		return newStudents;
	}
	
	public SortedSet subSet(Comparable fromObj, Comparable toObj){
		
		StudentSet newSet = new StudentSet();

        if (fromObj.compareTo(toObj) >= 0) {
            return newSet; 
        }

        for (int i = 0; i < sSize; i++) {
            Student current = students[i];

            boolean isAfterStart = current.compareTo(fromObj) >= 0;
            
            boolean isBeforeEnd = current.compareTo(toObj) < 0;

            if (isAfterStart && isBeforeEnd) {
                newSet.add(current);
            }

            if (current.compareTo(toObj) >= 0) {
                break;
            }
        }

        return newSet;
	}
	
    public String toString(){  
		String result = "";
		
		for(int i = 0; i < sSize; i++){
			result += students[i].toString() + "\n";
		}
		return result;	
	}
}

class Student implements Comparable{   //non modificare!!
	public Student (String c, String n, int m){
		cognome = c;
        nome = n;
        matricola = m;
    }

    public String getCognome()
    {   return cognome; }

    public String getNome()
    {   return nome; }

    public int getMatricola()
    {   return matricola; }


    /*
      I dati dello studente vengono stampati nel formato
      "cognome        nome          : n.matricola"
      Per il campo cognome e per il campo nome vengono allocati maxlength=15
      caratteri
    */
    public String toString(){
		int maxlength = 15;
        String sep1 = "";
        for (int i = 0; i < maxlength - cognome.length(); i++) sep1 += " ";
        String sep2 = "";
        for (int i = 0; i < maxlength - nome.length(); i++) sep2 += " ";
        return cognome + sep1 + nome + sep2 + ": " + matricola; 
    }

    /*
     Lo studente x e` "maggiore" dello studente y se il cognome di x segue
     quello di y secondo l'ordinamento lessicografico. Se i due cognomi sono
     uguali, allora x e` "maggiore" di y se il nome di x segue quello di y 
     secondo l'ordinamento lessicografico. Se anche i nomi sono uguali
     (due studenti omonimi) allora x e` "maggiore" di y se la sua matricola
     e` piu` grande di quella di y.
     Esempio1:
     (DeMorgan Augustus : 511123) e` maggiore di (Babbage Charles : 599987)
     Esempio2:
     (Bernoulli Nicolaus : 577789) e` maggiore di (Bernoulli Jacob : 500098)
     Esempio3:
     (Bernoulli Nicolaus : 588890) e` maggiore di (Bernoulli Nicolaus : 577789)

    */
    public int compareTo(Object other){
		Student aStudent = (Student) other;
        int comp = cognome.compareTo( ((Student) other).cognome);
        if (comp == 0) comp = nome.compareTo(((Student) other).nome);
        if (comp == 0) comp = matricola - ((Student) other).matricola;
        return comp;
    }

    /*
      Due studenti x e y sono "uguali" solo se hanno lo stesso cognome e lo 
      stesso nome e lo stesso numero di matricola. 
      Esempio:
     (Babbage Charles : 599987) e` uguale a (Babbage Charles : 599987)

    */
    public boolean equals(Object other){
		return this.compareTo(other) == 0;
    }

    private String cognome;
    private String nome;
    private int matricola;
}


interface SortedSet{     //non modificare!!
	// verifica se l'insieme contiene almeno un elemento
    boolean isEmpty(); 

    // svuota l'insieme
    void makeEmpty();
  
    // restituisce il numero di elementi nell'insieme
    int size();
  
    /*
        Inserisce l'oggetto comparabile obj nell'insieme se non e` gia` 
        presente, altrimenti fallisce silenziosamente.
    */
    void add(Comparable obj);
  
    /*
        Restituisce true se e solo se l'oggetto comparabile obj appartiene  
        all'insieme. Verranno considerate ottime le soluzioni per cui questo 
        metodo ha prestazioni O(log n) 
    */
    boolean contains(Comparable obj);
  
    /*
        Restituisce un array di oggetti comparabili contenente i riferimenti a 
        tutti gli elementi presenti nell'insieme
    */
    Comparable[] toArray();

    /*
        Riceve due riferimenti ad oggetti comparabili e restituisce un
        riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
        dell'insieme di partenza (cioe` il parametro implicito del metodo) 
        compresi tra fromObj (incluso) e toObj (escluso). 
        Se fromObj non appartiene all'insieme di partenza, il primo elemento 
        del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
        nell'insieme di partenza.
        Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
        il nuovo insieme sara` vuoto
    */
    SortedSet subSet(Comparable fromObj, Comparable toObj);

}
