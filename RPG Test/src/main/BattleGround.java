package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import characters.*;
import enemys.goblin;

public class BattleGround {

	
	public void battle(player p) {
		
		// Gegner an das spieler Level anpassen
		goblin g = new goblin(0);
		int zahl = (int) (Math.random() * 10);
		System.out.printf("Zufalls Zahl: %d\n",zahl);
		if (p.getLvl() == 1) {
			g.setLvl(1);
		} else {
			if (zahl >= 5) {
				g.setLvl(p.getLvl()+1);
			} else {
				g.setLvl(p.getLvl());
			}
		}
		
		// Zähl Variable für Rundenzahl
		int runde = 0;
		
		// Variable für erstschlag ermittlung
		boolean pFirst =false;
		
		// Ermittlung Erstschlag
		if(p.getSpeed() > g.getSpeed()) {
			pFirst = true;
		}
		// Spieler bei Low HP heilen
		if (p.getHealth()< p.getMaxHealth()) {
			p.setHealth(p.getMaxHealth());
		}
		
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		p.draw();
		System.out.println("------------------------------------");
		g.draw();
		
		// Ablauf der Kämpfe
		while (p.getHealth() >= 0 || g.getHealth() >= 0) {
			if (pFirst) {
				double pDamage = p.getAttack()/10;
				g.setHealth(g.getHealth() - pDamage);
				double gDamage = g.getAttack()/10;
				p.setHealth(p.getHealth() - gDamage);
				runde++;
			} else {
				double gDamage = g.getAttack()/10;
				p.setHealth(p.getHealth() - gDamage);
				double pDamage = p.getAttack()/10;
				g.setHealth(g.getHealth() - pDamage);
				runde++;
			}
			System.out.println("------------------------------------");
			System.out.printf("Runde: %d\n", runde);
			System.out.println("------------------------------------");
			p.drawFight();
			System.out.println("------------------------------------");
			g.drawFight();
			
			// Ende des Kampfes ermitteln
			if (p.getHealth() < 0) {
				System.out.println("Sie haben Verloren.");
				break;
			} else if (g.getHealth() < 0) {
				if (p.getLvl() < g.getLvl()) {
					p.gainEXP(500) ;
				} else if (p.getLvl() >= g.getLvl()){
					System.out.println("Sie haben Gewonnen.");
					p.gainEXP(250);
				}	
				p.levelErhöhen();
				
				// Abspeichern vom Spielstand
				ObjectOutputStream outP;
				try {
					outP = new ObjectOutputStream(new FileOutputStream(p.getName()+".dat"));
					outP.writeObject(p);
					outP.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				break;
			}
		}	
	}
}


