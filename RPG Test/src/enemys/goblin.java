package enemys;


public class goblin {
	
	private double health = 120;	
	private double attack = 110;
	private double def = 90;
	private double speed = 120;
	private double mana = 100;
	private int lvl = 1;
	
	
	public goblin(int lvl) {
		this.lvl = lvl;
	}

	public double getHealth() {
		return health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public double getAttack() {
		return attack;
	}
	
	public void setAttack(double attack) {
		this.attack = attack;
	}
	
	public double getDef() {
		return def;
	}
	
	public void setDef(double def) {
		this.def = def;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getMana() {
		return mana;
	}
	
	public void setMana(double mana) {
		this.mana = mana;
	}
	
	public int getLvl() {
		return lvl;
		
	}
	
	public void setLvl(int lvl) {
		this.lvl = lvl;
		while(lvl > 0) {
			health *= 1.03;
			attack *= 1.015;
			def *= 1.012;
			speed *= 1.06;
			mana *= 1.01;
			lvl--;
		}
	}
	
	public void  draw() {
		System.out.printf("Gegner Art:\t\tGoblin\n"
						+ "Lebenspunkte:\t\t%6.0f\n" 
						+ "Angriff:\t\t%6.0f\n" 
						+ "Verteidigung:\t\t%6.0f\n"
						+ "Geschwindigkeit:\t%6.0f\n"
						+ "Mana:\t\t\t%6.0f\n"
						+ "Level:\t\t\t%6d\n",
						health, attack, def, speed, mana, lvl);
	}
	
	public void  drawFight() {
		System.out.printf("Gegner Art:\t\tGoblin\n"
						+ "Lebenspunkte:\t\t%6.0f\n" 
						+ "Mana:\t\t\t%6.0f\n",
						health, mana);
	}

}
