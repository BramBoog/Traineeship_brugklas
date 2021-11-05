package Demo_dag2;



import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		System.out.println("go");
		
		int getal;
		getal = 5;
		int getal2 = 6;
		long getal3 = 12;
		boolean waar = true;
		char letter = 'r';
		
		new Fiets(); // object maken uit klasse: instantiëren
		Fiets fiets1 = new Fiets();
		
		Fiets fiets2 = new Fiets();
		fiets2.merk = "Batavus";
		
		Fiets fiets3 = new Fiets();
		fiets3.merk = "Giant";
		fiets3.breedteStuur = 32;
		fiets3.opstappen();
		
		fiets1.hoogte = 3;
		System.out.println(fiets1.hoogte);
		System.out.println(fiets2.hoogte);
		fiets2.hoogte = 5;
		Fiets.hoogte = 7;
		System.out.println(fiets1.hoogte);
		System.out.println(fiets2.hoogte);
		
		Dier dier1 = new Dier();
		dier1.soortnaam = "Leeuw";
		dier1.lf = new Leefomgeving();
		dier1.lf.land = "Brazilië";
		
		Dier dierK = new Konijn();
		Konijn konijn = new Konijn();
		// dierK krijgt ook alle eigenschappen van Dier
		// links van = (het referentieniveau) bepaalt waar je bij kan:
		konijn.leeftijd = 3;
		konijn.oorLengte = 4;
		dier1.leeftijd = 24;
	//  dier1.oorLengte = 5; kan niet
		dierK.leeftijd = 6;
	//  dierk.oorLengte = 6; kan niet
		
		
		Sporter piet = new Sporter();
		piet.rennen(65, 12); // argumenten
		
		piet.drankjekopen().drinken();
		
		new Drankje().drinken();
		
		Drankje d = new Drankje();
		d.drinken();
		
		
		System.out.println("voer uw naam in");
		Scanner sc = new Scanner(System.in);
		String tekst = sc.next();
		
		System.out.println(tekst + tekst);
		int tweede = sc.nextInt();
		System.out.println(tweede + tweede);
		
		Random r = new Random();
		int dobbelsteen = r.nextInt(7);
		System.out.println(dobbelsteen);
		
		// array
		int[] getallen = {5, 6, 8, 91, 14};
		System.out.println(getallen[2]);
		
		for(int x=0 ; x < getallen.length ; x++) {
			System.out.println(getallen[x]);
		}
	
		ArrayList<Integer> getallen3 = new ArrayList();
		getallen3.add(6);
		
		       
		getallen[2] = 66;
		System.out.println(getallen[2]);
		        
		for(int y = 0; y < getallen3.size(); y++) {
		System.out.println( getallen3.get(y) );
	}
}
}


class Fiets{
	int breedteStuur;
	int wielgrootte;
	String merk;
	static int hoogte;
	// final int hoogte = 9;
	// static final int hoogte = 9;
	
	void opstappen() {
		System.out.println("Ik stap op de fiets");
		}
}

class Dier{	 	// Parent/Super/Base
	Leefomgeving lf;	// has - a relatie
	String soortnaam;
	int leeftijd;
}

class Leefomgeving{
	int oppervlakte;
	String land;
}

class Konijn extends Dier{	// Child/Sub
	// is a relatie heeft richting
	int oorLengte;
}

class Sporter{
	Sporter(){ // constructor
		System.out.println("er wordt een nieuwe sporter gemaakt");
	}
	Sporter(int a){
		System.out.println("er wordt een nieuwe sporter gemaakt met getal");
	}
	
	int rennen(int afstand, int snelheid) { //parameter
		System.out.println(afstand);
		return 80;
		}
	
	Drankje drankjekopen(){
        return new Drankje();
    }
}

class Drankje{
    void drinken() {
        System.out.println("drinken");
    }
}