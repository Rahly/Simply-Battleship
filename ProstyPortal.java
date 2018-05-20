import java.util.ArrayList;

public class ProstyPortal {
	
	private ArrayList<String> polaPolozenia;
	private String nazwa;
	
	
	public void setPolaPolzenia(ArrayList<String> ppol)
	{
		polaPolozenia = ppol;
	}
	
	public void setNazwa(String nzwPortalu) {
		nazwa = nzwPortalu;
	}
	
	public String sprawdz(String ruch)
	{
		String wynik = "pud³o";
		int indeks = polaPolozenia.indexOf(ruch);
		
		if(indeks>=0) {
			polaPolozenia.remove(indeks);
			
			if(polaPolozenia.isEmpty()) {
				wynik = "zatopiony";
				System.out.println("Auc! zatopiles portal " + nazwa + " :(");
			}else {
				wynik = "trafiony";
			}
		}
		
	return wynik;
	}
	

	


}
