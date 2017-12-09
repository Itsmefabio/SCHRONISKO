import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
	private static void add(List<String> pojemnoœæ, String E)
	{
		
		
		pojemnoœæ.add(E);
	}
	private static void remove(List<String> pojemnoœæ, String E)
	{
		
		
		pojemnoœæ.remove(E);
	}
	



	public static void main(String[] args) {
		System.out.println("Program to prosty menager schroniska W schronisku mo¿e siê znajdowaæ max 20 zwierz¹t" );
		System.out.println("1.Dodaj zwierzê(Podaj imiê)");
		System.out.println("2.Usuñ zwierzê(Podaj numer zwierzêcia");
		System.out.println("3.Status Zajêtych miejsc");
		System.out.println("4.Koniec programu");
		System.out.println("Podaj liczbê 1-4");
		List<String> Pojemnoœæ = new ArrayList<String>(20);
		int cozrobic;
		for(int i =0;i<9999; i++) {
			
		Scanner decyzja= new Scanner(System.in);
		cozrobic = decyzja.nextInt();
		
			switch(Integer.valueOf(cozrobic))
		
		{
		case 1:{ if(Pojemnoœæ.size()==20){
		System.out.println("Schronisko jest pe³ne, nie mo¿esz dodaæ wiêcej zwierz¹t");
		break;}
		else {
			System.out.println("Podaj imiê zwierzêcia, które chcesz dodaæ");
			Scanner imie=new Scanner(System.in);
			String E=imie.nextLine();
			
		add(Pojemnoœæ, E);
			System.out.println("Numer Zwierzecia to: " + Pojemnoœæ.size());
			break;}
		}
		case 2:{  if(Pojemnoœæ.size()==0){
			System.out.println("Schronisko jest puste");
			break;}
			else {
			System.out.println("Podaj numer zwierzêcia, które nie znajduje siê ju¿ w schronisku: ");
			Scanner imie=new Scanner(System.in);
			String E=imie.nextLine();
			
		remove(Pojemnoœæ, E);
			System.out.println("Zwierzê usuniête z listy, obecny Stan schroniska to "+Pojemnoœæ.size());
		break;}
		}
		case 3:{
			System.out.println("Aktualna lista zwierz¹t");
			for(int j=0; j<Pojemnoœæ.size();j++)
			{System.out.println((String)Pojemnoœæ.get(j));}
			if(Pojemnoœæ.size()==20)
			{System.out.println("Schronisko jest pe³ne");
			break;}
			else {
				System.out.println("Schronisko nie jest pe³ne i jest jeszcze: " +(20-Pojemnoœæ.size())+ " Wolnych miejsc");
			break;}
			
			}
		
		}
			
			while(cozrobic==4)
		{
			System.out.println("Koñczymy program");
			System.exit(cozrobic);}
			
		}
	
				
				
	
	}
}
		
	
	
		
		
		
	


