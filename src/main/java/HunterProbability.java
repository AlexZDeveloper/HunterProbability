/*
	Задача 110: Будни браконьера
В диком заповеднике находятся редкие животные, всего N животных всех видов. 
Браконьеру нужно подстрелить не менее K животных, чтобы прокормить свою семью. 
Для каждого животного браконьер знает вероятность того, что он его подстрелит. 
Необходимо помочь браконьеру посчитать вероятность успеха охоты.

Входные данные: arr = (animal, probability) - массив ктр хранит пары: 
	животное -> вероятность его подстрелить. 
K - минимальное кол-во животных, ктр необходимо подстрелить браконьеру.

Вывод: вероятность, что охота для браконьера окажется успешной.

Пример:
K = 2; arr =  { "медведь", 0.5 }, { "тигр", 0.5 }, { "лев", 0.5 } 
Answer = 0.5 (или 50%)
 * */
public class HunterProbability {

	private Animal[] animals;
	private int N;
	
	public HunterProbability(Animal[] animals, int N) {
		this.animals = animals;
		this.N = N; 
	}
	
	public double getProbability() {
		if (N == 0)
			return 1;
		if (N > animals.length) 
			return 0;
		
		int cnt = (int) Math.pow(2, animals.length);
		double s = 0;
		
		// Перебор всевозможных комбинаций
		for (int k = 0; k < cnt; k++) {
			double probability = 1;
			int hit = 0;
			
			for (int i = 0; i < animals.length; i++) {				
				if ((k & (1<<i)) > 0) {
					probability *= animals[i].getProbability();
					hit++;
				} else {
					probability *= 1 - animals[i].getProbability();
				}
			}			
			if (hit >= N) {
				s += probability;
			}	
		}
		return s;	
	}	
	
	public static void main(String args[]) {
		Animal[] animals = new Animal[] {
				new Animal("медведь", 0.5), 
				new Animal("тигр", 0.5),
				new Animal("лев", 0.5)
				};
		int minAnimalsCount = 2;
		HunterProbability hunter = new HunterProbability(animals, minAnimalsCount);		
		System.out.println("Probabiliity: " + hunter.getProbability());
	}
}
