import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HunterProbabilityTest {

	private static final double DELTA = 1E-6;
	
	@Test
	public void emptyAnimals() {
		Animal[] animals = new Animal[0];
		int minAnimalsCount = 0;
		HunterProbability hunter = new HunterProbability(animals, minAnimalsCount);
		assertEquals(1, hunter.getProbability(), DELTA);
	}
	
	@Test
	public void zeroMinAnimalCount() {
		Animal[] animals = new Animal[0];
		int minAnimalsCount = 0;
		HunterProbability hunter = new HunterProbability(animals, minAnimalsCount);
		assertEquals(1, hunter.getProbability(), DELTA);
	}	
	
	
	@Test
	public void minAnimalCountGreatherThanAnimals() {
		Animal[] animals = new Animal[0];
		int minAnimalsCount = 1;
		HunterProbability hunter = new HunterProbability(animals, minAnimalsCount);
		assertEquals(0, hunter.getProbability(), DELTA);
	}
	
	
	@Test
	public void HunterProfitability() {		
		Animal[] animals = new Animal[] {
				new Animal("медведь", 0.5), 
				new Animal("тигр", 0.5),
				new Animal("лев", 0.5)
				};
		int minAnimalsCount = 2;
		HunterProbability hunter = new HunterProbability(animals, minAnimalsCount);
		assertEquals(0.5, hunter.getProbability(), DELTA);
	}		
}
