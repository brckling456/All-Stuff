package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import characters.*;


public class App {

	public static void main(String[] args) {
		System.out.println("Herzlich Wilkommen bei RPG Test!");
		System.out.printf("1\t Neues Spiel. \n"
						+ "2\t Spiel laden. \n");
		
		Scanner sc = new Scanner(System.in);
		int auswahl = sc.nextInt();
		System.out.println(auswahl);
		
		switch(auswahl) {
		case 1:
			
			// Erzeucgen des Spielers
			System.out.println("Wie heisst dein Spieler?");
			sc = new Scanner(System.in);
			String name = sc.next();
			player p = new Krieger(name);
			BattleGround bg1 = new BattleGround();
			bg1.battle(p);
			System.out.println("------------------------------------");
			System.out.println("------------------------------------");
			p.draw();
			System.out.println("------------------------------------");
			System.out.println("------------------------------------");
			break;
			
		case 2:
			
			// Laden vom Spielstand fals vorhanden
			player pLoad = new Krieger("");
			System.out.println("Welchen Spieler willst du Laden?");
			sc = new Scanner(System.in);
			String nameLoad = sc.next();
			ObjectInputStream inp;
			try {
				inp = new ObjectInputStream(new FileInputStream(nameLoad + ".dat"));
				pLoad = (player) inp.readObject();
				inp.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			BattleGround bgLoad = new BattleGround();
			bgLoad.battle(pLoad);
			System.out.println("------------------------------------");
			System.out.println("------------------------------------");
			pLoad.draw();
			System.out.println("------------------------------------");
			System.out.println("------------------------------------");
			break;
			
		}
		
		sc.close();	
	}
}
