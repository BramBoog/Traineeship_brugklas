package designPatterns;

public class DesignPatterns {
	public static void main(String[] args) {
		
		BankOverschrijving bo = new BankOverschrijving();
		bo.setBedrag(-70);
		bo.overschrijvingUitvoeren();
		System.out.println(bo.getBedrag());
		
		LoterijUitgifte lu1 = LoterijUitgifte.getLoterijUitgifte();
		LoterijUitgifte lu2 = LoterijUitgifte.getLoterijUitgifte();
		System.out.println(lu1);
		System.out.println(lu1);
		lu1.lottrekken();
		lu2.lottrekken();
		lu1.lottrekken();
		lu2.lottrekken();
		
		ShapeFactory sf = new ShapeFactory();
		Shape shape1 = sf.getShape("circle");
		shape1.draw();
		Shape shape2 = sf.getShape("rectangle");
		shape2.draw();
	}
}

// Encapsulation
class BankOverschrijving {
	private int bedrag;
	
	public void setBedrag(int amount) {
		if(amount < 0) {
			System.out.println("vul een positief getal in");
		}
		else {
			bedrag = amount;
		}
	}
	
	public int getBedrag() {
		return bedrag;
	}
	
	void overschrijvingUitvoeren() {
		System.out.println("bij mij gaat er " + bedrag + " af.");
		System.out.println("bij jou komt er " + bedrag + " bij.");
	}
}

// Singleton
class LoterijUitgifte {
	// private constructor zorgt ervoor dat class niet kan worden geïnstantieerd
	private LoterijUitgifte() {}
	private static LoterijUitgifte lu = new LoterijUitgifte();
	
	// static zorgt ervoor dat je deze methode kan aanroepen zonder
	// een instantie van de class te maken
	public static LoterijUitgifte getLoterijUitgifte( ) {
		return lu;
	}
	
	int lotnummer = 0;
	void lottrekken() {
		System.out.println(lotnummer++);
	}
}

// Factory
interface Shape {
	void draw();
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("rectangle draw");
	}
}

class Circle implements Shape {
	public void draw() {
		System.out.println("circle draw");
	}
}

class ShapeFactory {
	Shape getShape(String shapeType) {
		if(shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		}
		
		if(shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		}
		
		else return null;
	}
}