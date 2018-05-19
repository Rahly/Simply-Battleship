
public class ProstyPortalGra {
	
	public static void main(String[] args) {
		
		int iloscRuchow = 0;
		PomocnikGry pomocnik = new PomocnikGry();
		
		ProstyPortal portal = new ProstyPortal();
		
		int liczbalosowa = (int) (Math.random() * 5);
		
		int[] polozenie = {liczbalosowa, liczbalosowa+1, liczbalosowa+2};
		portal.setPolaPolzenia(polozenie);
		boolean czyIstnieje  = true;
		
		while(czyIstnieje == true) {
			String pole = pomocnik.pobierzDaneWejsciowe("Podaj liczbe");
			
			String wynik = portal.sprawdz(pole);
			
			iloscRuchow++;
			
			if(wynik.equals("zatopiony")) {
				czyIstnieje = false;
				System.out.println(iloscRuchow + "ruchów");
			}
		}
	}

}
