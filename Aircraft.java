// Assignment #: 6
//         Name: Suvan Kumar
//    StudentID: 1221910898
//      Lecture: MWF 10:10 - 11am
//  Description: ADD THIS

public class Aircraft {
	private String type;
	private String name;
	private int bombCarryingCapacity;
	private int attackPower;
	private int stealthIndex;
	
	/**
	 * 
	 * @param _type	Type (Fighter Jet, Bomber - Propeller Type, Bomber - Jet Type, Combat Helicopter)
	 * @param _name Name
	 * @param _bombCarryingCapacity Bomb Carrying Capacity
	 * @param _attackPower Attack Power
	 * @param _stealthIndex Stealth Index
	 */
	
	public Aircraft(String _type, String _name, int _bombCarryingCapacity, int _attackPower, int _stealthIndex) {
		this.type = _type;
		this.name = _name;
		this.bombCarryingCapacity = _bombCarryingCapacity;
		this.attackPower = _attackPower;
		this.stealthIndex = _stealthIndex;
	}
	
	public Aircraft() {
		this("?", "?", 0, 0, 0);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getBombCarryingCapacity() {
		return bombCarryingCapacity;
	}


	public void setBombCarryingCapacity(int bombCarryingCapacity) {
		this.bombCarryingCapacity = bombCarryingCapacity;
	}


	public int getAttackPower() {
		return attackPower;
	}


	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}


	public double getStealthIndex() {
		return stealthIndex;
	}

	public void setStealthIndex(int stealthIndex) {
		this.stealthIndex = stealthIndex;
	}
	
	public String toString() {
		return String.format("Aircraft name: %s\t\t\t(%s)\nBomb Carrying Capacity: %d\t\t\tAttack Power: %d\t\t\tStealth Index: %d\n", this.name, this.type, this.bombCarryingCapacity, this.attackPower, this.stealthIndex);		
	}

	public boolean contains(String nameResult) {
		return false;
	}
}
