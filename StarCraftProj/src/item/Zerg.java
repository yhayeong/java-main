package item;

public class Zerg extends AirUnit implements Repairable {

	public Zerg() {
		super(200);
	}

	@Override
	public void fix() {
		this.healthPoint = this.MAX_HP;
	}

}
