package characters;

public class Krieger extends player{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String klasse;
	private double maxHealth;
	private double health;	
	private double attack;
	private double def;
	private double speed;
	private double mana;
	private int exp;
	private int expPool;
	private int expGesammt;
	private int lvl = 1;
	private int lvlNeu;
	private int sPunkte;
	
	public Krieger(String name) {
		super(name );
		this.name = name;
		this.klasse = "Krieger";
		this.maxHealth = super.getMaxHealth() + 20;
		this.health = super.getHealth();
		this.attack = super.getAttack() + 60;
		this.def = super.getDef() + 20;
		this.speed = super.getSpeed() - 20;
		this.mana = super.getMana()- 50;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
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

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getExpPool() {
		return expPool;
	}

	public void setExpPool(int expPool) {
		this.expPool = expPool;
	}

	public int getExpGesammt() {
		return expGesammt;
	}

	public void setExpGesammt(int expGesammt) {
		this.expGesammt = expGesammt;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getLvlNeu() {
		return lvlNeu;
	}

	public void setLvlNeu(int lvlNeu) {
		this.lvlNeu = lvlNeu;
	}

	public int getsPunkte() {
		return sPunkte;
	}

	public void setsPunkte(int sPunkte) {
		this.sPunkte = sPunkte;
	}
	

	@Override
	public void levelErhöhen() {
		
		while (expPool > 0) {
			if (lvl >= 30) {
				expGesammt += exp;
			} else if (lvl >= 20 && expPool >= 1000) {
				expPool -= 1000;
				expGesammt +=1000;
				lvl++;
				lvlNeu++;
				sPunkte += 4;
			} else if (lvl >= 15 && expPool >= 750) {
				expPool -= 750;
				expGesammt +=750;
				lvl++;
				lvlNeu++;
				sPunkte += 3;
			} else if (lvl >= 10 && expPool >= 500) {
				expPool -= 500;
				expGesammt +=500;
				lvl++;
				lvlNeu++;
				sPunkte += 2;
			} else if (lvl < 10  && expPool >= 250) {
				expPool -= 250;
				expGesammt +=250;
				lvl++;
				lvlNeu++;
				sPunkte++;
			}
		break;
		}
		werteUp();
	}

	@Override
	public void werteUp() {
		while(lvlNeu > 0) {
			maxHealth *= 1.05;
			attack *= 1.015;
			def *= 1.012;
			speed *= 1.06;
			mana *= 1.01;
			lvlNeu--;
		}	
	}

	@Override
	public void gainEXP(int exp) {
		this.expPool += exp;
		this.exp = exp;
	}

	@Override
	public void  draw() {
		System.out.printf("Name:\t\t\t%s\n"
						+ "Klasse:\t\t\t%s\n"
						+ "Maximal Leben:\t\t%6.0f\n"
						+ "Lebenspunkte:\t\t%6.0f\n" 
						+ "Angriff:\t\t%6.0f\n" 
						+ "Verteidigung:\t\t%6.0f\n"
						+ "Geschwindigkeit:\t%6.0f\n"
						+ "Mana:\t\t\t%6.0f\n"
						+ "Level:\t\t\t%6d\n"
						+ "Erfahrungspunkte:\t%6d\n"
						+ "Skill Punkte:\t\t%6d\n"
						+ "ExpPool:\t\t%6d\n",
						name, klasse, maxHealth, health, attack, def, speed, mana, lvl, expGesammt, sPunkte, expPool);
	}
	
	@Override
	public void  drawFight() {
		System.out.printf("Name:\t\t\t%s\n"
						+ "Klasse:\t\t\t%s\n"
						+ "Lebenspunkte:\t\t%6.0f\n" 
						+ "Mana:\t\t\t%6.0f\n",
						name, klasse, health, mana);
	}
	


}
