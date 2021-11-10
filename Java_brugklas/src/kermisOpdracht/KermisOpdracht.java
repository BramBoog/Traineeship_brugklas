package kermisOpdracht;

import java.util.Scanner;
import java.util.Random;
import java.lang.Class;

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
				+ "m_<attractienummer>: monteur roepen voor onderhoudsbeurt aan spin of Hawaii\n"
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
		BelastingInspecteur belastingInspec = new BelastingInspecteur();
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
	//  Main loop
		while(true) {
			
		//  If the input is an integer, run the corresponding attractie.
			if(sc.hasNextInt()) {
				int attractieID = sc.nextInt();
				boolean gedraaid = false;
				
				for(int i=0; i<6; i++) {
					if (attractieID == (i+1)) {
						
						if(attractieID == 2 || attractieID == 5) {
							RisicoRijkeAttractie risicoAtt = (RisicoRijkeAttractie) attracties[i];
							if(risicoAtt.draaiAmount >= risicoAtt.draaiLimiet) {
								throw new RuntimeException("De attractie " + risicoAtt.name +
											" heeft zijn draailimiet van " + risicoAtt.draaiLimiet + " bereikt!\n"
											+ "Roep een monteur aan met m_2 voor het draailimiet wordt bereikt om dit te voorkomen.");
							}
						}
						
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
				
			//  If an attractie did run, random visit from the belastinginspecteur is possible
				else {
					if(r.nextInt(16) == 1) {
						for(int i=0; i<6; i++) {
							belastingInspec.belastingHeffen(kassa, attracties[i]);
						}
					}
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
					int ID = Character.getNumericValue(inputText.charAt(2));
					System.out.println("Omzet van " + attracties[ID-1].name  + ": " + attracties[ID-1].turnover);
				}
				
			//  Total tickets
				else if(inputText.equals("k")) {
					System.out.println("Totaal aantal kaartjes: " + totalTickets);
				}
				
			//  Ticket amount of individual attractie
				else if(inputText.length() == 3 && inputText.substring(0, 2).equals("k_")) {
					int ID = Character.getNumericValue(inputText.charAt(2));
					System.out.println("Aantal tickets van " + attracties[ID-1].name  + ": " + attracties[ID-1].tickets);
				}
				
			//  Reset draaiAmount for RisicoRijkeAttracties
				else if(inputText.length() == 3 && inputText.substring(0,2).equals("r_")) {
					int ID = Character.getNumericValue(inputText.charAt(2));
					if(!(ID == 2 || ID == 5)) {
						System.out.println("Alleen spin en Hawaii kunnen een onderhoudsbeurt krijgen!");
					}
					else {
						attracties[ID-1].draaiAmount = 0;
						System.out.println("De attractie " + attracties[ID-1].name + " heeft een onderhoudsbeurt gekregen.");
					}
					
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
	int taxVisits;
}

abstract class Attractie {
	int ID;
	String name;
	public static final String[] attractieNames = {"Botsautos", "Spin", "Spiegelpaleis", "Spookhuis", "Hawaii", "Ladderklimmen"};
	double price;
	double turnover;
	int tickets;
	int area;
	int draaiAmount;
	
	void draaien() {
		System.out.println("De attractie " + name + " draait.");
		this.tickets += 1;
		this.turnover += this.price;
		this.draaiAmount += 1;
	}
}

abstract class RisicoRijkeAttractie extends Attractie {
	int draaiLimiet;
	
	 void opstellingsKeuring() {
		 this.draaiAmount = 0;
	 }
}

interface GokAttractie {
	double kansSpelBelastingBetalen();
}

class BelastingInspecteur {
	int totalTax = 0;
	
	void belastingHeffen(Kassa kassa, Attractie attr) {
		if(GokAttractie.class.isAssignableFrom(attr.getClass())) {
			GokAttractie gokAttr = (GokAttractie) attr;
			double tax = gokAttr.kansSpelBelastingBetalen();
			totalTax += tax;
			attr.turnover -= tax;
			kassa.turnover -= tax;
			kassa.taxVisits += 1;
			System.out.println("Er is belasting geheven over de omzet van " + attr.name);
		}
	}
}

class Botsautos extends Attractie {
	
	Botsautos() {
		this.ID = 1;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.50;
	}
}

class Spin extends RisicoRijkeAttractie implements GokAttractie {
	
	Spin() {
		this.ID = 2;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.25;
		this.draaiLimiet = 5;
	}
	
	public double kansSpelBelastingBetalen() {
		double taxPayment = this.turnover * 0.3;
		return taxPayment;
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

class Hawaii extends RisicoRijkeAttractie {
	
	Hawaii() {
		this.ID = 5;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 2.90;
		this.draaiLimiet = 10;
	}
}

class Ladderklimmen extends Attractie implements GokAttractie {
	
	Ladderklimmen() {
		this.ID = 6;
		this.name = Attractie.attractieNames[ID-1];
		this.price = 5.00;
	}
	
	public double kansSpelBelastingBetalen() {
		double taxPayment = this.turnover * 0.3;
		return taxPayment;
	}
}