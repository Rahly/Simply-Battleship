import java.io.*;
import java.util.*;

public class PomocnikGry {
	
	private static final String alfabet = "abcdefg";
	private static int dlugoscPlanszy = 7;
	private static int wielkoscPlanszy = 49;
	private static int [] plansza = new int[wielkoscPlanszy];
	private static int iloscPortali = 0;
	
	public String pobierzDaneWejsciowe(String komunikat) {
		
		String daneWejsciowe = null;
		
		System.out.println(komunikat + " ");
		try {
			BufferedReader sw = new BufferedReader(new InputStreamReader(System.in));
			daneWejsciowe = sw.readLine();
			
			if(daneWejsciowe.length() == 0)
				return null;
			
		}catch (IOException e) {
			System.out.println("IOEcxception: " + e);
		}
		return daneWejsciowe.toLowerCase();
	}
	
	public static ArrayList rozmiescPortal(int wielkoscPortalu) {
		
		ArrayList<String> zajetePola = new ArrayList<String>();
		String [] wspolrzedneLnc = new String [wielkoscPortalu];
		String pomoc = null;
		int [] wspolrzedne = new int[wielkoscPortalu];
		int prob = 0;
		boolean powodzenie = false;
		int polozenie = 0;
		
		iloscPortali++;
		int inkr = 1;
		if((iloscPortali %2) == 1) {
			inkr = dlugoscPlanszy;
		}
		
		while(!powodzenie & prob++ < 200) {

			polozenie = (int) (Math.random() * wielkoscPlanszy);
			int x = 0;
			powodzenie = true;
				while(powodzenie && x< wielkoscPortalu) {
					if(plansza[polozenie] == 0) {
						wspolrzedne[x++] = polozenie;
						polozenie += inkr;
						if(polozenie >= wielkoscPlanszy) {
							powodzenie =  false;
						}
						if(x>0 & (polozenie % dlugoscPlanszy == 0)) {
							powodzenie = false;
						}
						}else {
							powodzenie = false;
						}
					}
				}
				
				int x = 0;
				int wiersz = 0;
				int kolumna = 0;
				
				while(x < wielkoscPortalu) {
					plansza[wspolrzedne[x]] = 1;
					wiersz = (int) (wspolrzedne[x] / dlugoscPlanszy);
					kolumna = wspolrzedne[x] % dlugoscPlanszy;
					pomoc = String.valueOf(alfabet.charAt(kolumna));
					zajetePola.add(pomoc.concat(Integer.toString(wiersz)));
					x++;
				}
		
		return zajetePola;
	}

}
