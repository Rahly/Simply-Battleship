import java.util.ArrayList;

public class ProstyPortalGra {
	
	private PomocnikGry pomocnik = new PomocnikGry();
	private ArrayList<ProstyPortal> listaPortali = new ArrayList<ProstyPortal>();
	private int iloscRuchow = 0;
	
	private void przygotujGre() {
		
		ProstyPortal pierwszy = new ProstyPortal();
		pierwszy.setNazwa("onet.pl");
		ProstyPortal drugi = new ProstyPortal();
		drugi.setNazwa("wp.pl");
		ProstyPortal trzeci = new ProstyPortal();
		trzeci.setNazwa("Go2.com");
		
		listaPortali.add(pierwszy);
		listaPortali.add(drugi);
		listaPortali.add(trzeci);
		
		System.out.println("Twoim celem jest zatopienie trzech portali.");
		System.out.println("onet.pl, wp.pl, Go2.com");
		System.out.println("Zatop je w jak najmniejszej ilosci ruchow");
		
		for(ProstyPortal rozmieszczanyPortal : listaPortali) {
			
			ArrayList<String> nowePolozenie = PomocnikGry.rozmiescPortal(3);
			rozmieszczanyPortal.setPolaPolzenia(nowePolozenie);
		}
	}
	
	private void rozpocznijGre() {
		
		while(!listaPortali.isEmpty()) {
			
			String ruchGracza = pomocnik.pobierzDaneWejsciowe("Podaj pole: ");
			sprawdzRuchGracza(ruchGracza);
		}
		zakonczGre();
	}
	
	private void sprawdzRuchGracza(String ruch) {
		
		iloscRuchow++;
		String wynik = "pudlo";
		
		for(ProstyPortal portalDoSprawdzenia : listaPortali) {
			wynik = portalDoSprawdzenia.sprawdz(ruch);
			if(wynik.equals("trafiony")) {
				break;
			}
			if(wynik.equals("zatopiony")) {
				listaPortali.remove(portalDoSprawdzenia);
				break;
			}
		}
		System.out.println(wynik);
	}
	
	private void zakonczGre() {
		
		System.out.println("Wszystkie Portale zostaly zatopione! Teraz Twoje informacje nie maja znaczenia.");
		
		if(iloscRuchow <= 18) {
			System.out.println("Wykonales jedynie " + iloscRuchow + " ruchow.");
			System.out.println("Wydostales sie zanim Twoje informacje zatonely.");
		}else {
			System.out.println("Ale sie grzebales!. Wykonales az " + iloscRuchow + " ruchow.");
			System.out.println("Teraz rybki plywaja pomiedzy Twoimi informacjami.");
		}
	}
	
	public static void main(String[] args) {
		
		ProstyPortalGra gra = new ProstyPortalGra();
		gra.przygotujGre();
		gra.rozpocznijGre();
		
	}

}



