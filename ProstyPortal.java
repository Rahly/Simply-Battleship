
public class ProstyPortal {
	
	static int[] polaPolozenia;
	static int iloscTrafien = 0;
	
	public static String sprawdz(String stringPole)
	{
		int strzal = Integer.parseInt(stringPole);
		
		String wynik = "pud³o";
		
		for(int pole:polaPolozenia) {
			if (strzal == pole) {
				wynik = "trafiony";
				iloscTrafien++;
				break;
			}
		}
		
		if(iloscTrafien == polaPolozenia.length) {
			
			wynik = "zatopiony";
		}
		
		System.out.println(wynik);
		
		return wynik;
	}
	
	public void setPolaPolzenia(int [] ppol)
	{}

}
