package kermisOpdracht;

import java.util.Scanner;

public class KermisOpdracht {
	public static void main(String[] args) {
		
		new KermisOpdracht().kermisCentralFunc();
		
	}
	
	
	void kermisCentralFunc() {
		System.out.println("Geef aan wat je wilt doen in de kermis. De volgende inputs zijn geïmplementeerd.\n"
				+ "\n"
				+ "Draaien van attracties:\n"
				+ "1: botsautos\n"
				+ "2: spin\n"
				+ "3: spiegelpaleis\n"
				+ "4: spookhuis\n"
				+ "5: Hawaii\n"
				+ "6: ladderklimmen\n"
				+ "\n"
				+ "Informatie over de kermis:\n"
				+ "o: totale omzet van de kermis\n"
				+ "o_<attractienummer>: omzet van individuele attractie\n"
				+ "k: totaal aantal verkochte tickets\n"
				+ "k_<attractienummer>: aantal verkochte tickets van individuele attractie\n"
				+ "\n"
				+ "quit: afsluiten");
		
	//  Create central objects that make up the kermis
		Botsautos botsautos = new Botsautos();
		Spin spin = new Spin();
		Spiegelpaleis spiegelpaleis = new Spiegelpaleis();
		Spookhuis spookhuis = new Spookhuis();
		Hawaii hawaii = new Hawaii();
		Ladderklimmen ladderklimmen = new Ladderklimmen();
		Attractie[] attracties = {botsautos, spin, spiegelpaleis, spookhuis, hawaii, ladderklimmen};
		Kassa kassa = new Kassa();
		int totalTickets = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		//  If the input is an integer, run the corresponding attractie.
			if(sc.hasNextInt()) {
				int attractieID = sc.nextInt();
				boolean gedraaid = false;
				
				for(int i=0; i<6; i++) {
					if (attractieID == (i+1)) {
						attracties[i].draaien();
						kassa.turnover += attracties[i].price;
						totalTickets += 1;
						gedraaid = true;
						break;
					}
				}
				
				if (gedraaid == false) {
					System.out.println("De toegestane attractienummers zijn 1-6.");
				}
			}
			
			else {
				String inputText = sc.next();
			
			//  Total turnover
				if(inputText.equals("o")) {
					System.out.println("Totale omzet: " + kassa.turnover);
				}
				
			//  Turnover of individual attractie
				else if(inputText.length() == 3 && inputText.substring(0, 2).equals("o_")) {
					char IDChar = inputText.charAt(2);
					int ID = Character.getNumericValue(IDChar);
					System.out.println("Omzet van " + attracties[ID-1].name  + ": " + attracties[ID-1].turnover);
				}
				
			//  Total tickets
				else if(inputText.equals("k")) {
					System.out.println("Totaal aantal kaartjes: " + totalTickets);
				}
				
			//  Ticket amount of individual attractie
				else if(inputText.length() == 3 && inputText.substring(0, 2).equals("k_")) {
					char IDChar = inputText.charAt(2);
					int ID = Character.getNumericValue(IDChar);
					System.out.println("Aantal tickets van " + attracties[ID-1].name  + ": " + attracties[ID-1].tickets);
				}
				
				else if(inputText.equals("quit")) {
					System.out.println("De kermis sluit.");
					break;
				}
				
				else {
					System.out.println("De input was niet geldig, probeer het opnieuw.");
				}
			}
		}
		sc.close();
	}
	
}

class Kassa {
	double turnover;
	int inspectorVisits;
}

abstract class Attractie {
	int ID;
	String name;
	public static final String[] attractieNames = {"Botsautos", "Spin", "Spiegelpaleis", "Spookhuis", "Hawaii", "Ladderklimmen"};
	double price;
	double turnover;
	int tickets;
	int area;
	
	void draaien() {
		System.out.println("De attractie " + name + " draait.");
		this.tickets += 1;
		this.turnover += this.price;
	}
}

class Botsautos extends Attractie {
	
	Botsautos() {
		this.ID = 1;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.50;
	}
	
}

class Spin extends Attractie {
	
	Spin() {
		this.ID = 2;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.25;
	}
}

class Spiegelpaleis extends Attractie {
	
	Spiegelpaleis() {
		this.ID = 3;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.75;
	}
}

class Spookhuis extends Attractie {
	
	Spookhuis() {
		this.ID = 4;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 3.20;
	}
}

class Hawaii extends Attractie {
	
	Hawaii() {
		this.ID = 5;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.90;
	}
}

class Ladderklimmen extends Attractie {
	
	Ladderklimmen() {
		this.ID = 6;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 5.00;
	}
}