import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
	private static void add(List<String> pojemno��, String E)
	{
		
		
		pojemno��.add(E);
	}
	private static void remove(List<String> pojemno��, String E)
	{
		
		
		pojemno��.remove(E);
	}
	



	public static void main(String[] args) {
		System.out.println("Program to prosty menager schroniska W schronisku mo�e si� znajdowa� max 20 zwierz�t" );
		System.out.println("1.Dodaj zwierz�(Podaj imi�)");
		System.out.println("2.Usu� zwierz�(Podaj numer zwierz�cia");
		System.out.println("3.Status Zaj�tych miejsc");
		System.out.println("4.Koniec programu");
		System.out.println("Podaj liczb� 1-4");
		List<String> Pojemno�� = new ArrayList<String>(20);
		int cozrobic;
		for(int i =0;i<9999; i++) {
			
		Scanner decyzja= new Scanner(System.in);
		cozrobic = decyzja.nextInt();
		
			switch(Integer.valueOf(cozrobic))
		
		{
		case 1:{ if(Pojemno��.size()==20){
		System.out.println("Schronisko jest pe�ne, nie mo�esz doda� wi�cej zwierz�t");
		break;}
		else {
			System.out.println("Podaj imi� zwierz�cia, kt�re chcesz doda�");
			Scanner imie=new Scanner(System.in);
			String E=imie.nextLine();
			
		add(Pojemno��, E);
			System.out.println("Numer Zwierzecia to: " + Pojemno��.size());
			break;}
		}
		case 2:{  if(Pojemno��.size()==0){
			System.out.println("Schronisko jest puste");
			break;}
			else {
			System.out.println("Podaj numer zwierz�cia, kt�re nie znajduje si� ju� w schronisku: ");
			Scanner imie=new Scanner(System.in);
			String E=imie.nextLine();
			
		remove(Pojemno��, E);
			System.out.println("Zwierz� usuni�te z listy, obecny Stan schroniska to "+Pojemno��.size());
		break;}
		}
		case 3:{
			System.out.println("Aktualna lista zwierz�t");
			for(int j=0; j<Pojemno��.size();j++)
			{System.out.println((String)Pojemno��.get(j));}
			if(Pojemno��.size()==20)
			{System.out.println("Schronisko jest pe�ne");
			break;}
			else {
				System.out.println("Schronisko nie jest pe�ne i jest jeszcze: " +(20-Pojemno��.size())+ " Wolnych miejsc");
			break;}
			
			}
		
		}
			
			while(cozrobic==4)
		{
			System.out.println("Ko�czymy program");
			System.exit(cozrobic);}
			
		}
	
				
				
	
	}
}
		
	
	
		
		
		
	


