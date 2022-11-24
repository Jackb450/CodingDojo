
public class Bat extends Mammal{
	public void setBatEnergy() {
		this.energyLevel = 300;
	}
	public void fly() {
		this.energyLevel -= 50; 
		System.out.println("*flaping wings*");
		displayEnergy();
	}
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("chomp!");
		displayEnergy();
	}
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("SWOOOSH");
		displayEnergy();	
	}
}