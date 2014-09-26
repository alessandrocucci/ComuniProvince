package it.alessandrocucci.comuniprovince;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Provincia {
	
	List<List<String>> provincedb = new ArrayList<List<String>>();
	
	public Provincia(){
		
		for (int i = 0; i < 15; i++ ){
			provincedb.add(new ArrayList<String>());
		}
		
		
		try {
			CsvReader province = new CsvReader("data/province.csv");
		
			province.readHeaders();

			while (province.readRecord())
			{
				String codrip = province.get("Codice ripartizione");
				provincedb.get(0).add(codrip);
				
				String nuts = province.get("Codice NUTS1 2006");
				provincedb.get(1).add(nuts);
				
				String nuts10 = province.get("Codice NUTS1 2010");
				provincedb.get(2).add(nuts10);
				
				String ripgeoM = province.get("Ripartizione geografica(Maiuscolo)");
				provincedb.get(3).add(ripgeoM);
				
				String ripgeo = province.get("Ripartizione geografica");
				provincedb.get(4).add(ripgeo);
				
				String codreg = province.get("Codice regione");
				provincedb.get(5).add(codreg);
				
				String nuts2 = province.get("Codice NUTS2 2006 (a)");
				provincedb.get(6).add(nuts2);
				
				String nuts210 = province.get("Codice NUTS2 2010 (a)");
				provincedb.get(7).add(nuts210);
				
				String denregM = province.get("Denominazione regione(Maiuscolo)");
				provincedb.get(8).add(denregM);
				
				String denreg = province.get("Denominazione regione");
				provincedb.get(9).add(denreg);
				
				String codprov = province.get("Codice provincia");
				provincedb.get(10).add(codprov);
				
				String nuts3 = province.get("Codice NUTS3 2006");
				provincedb.get(11).add(nuts3);
				
				String nuts310 = province.get("Codice NUTS3 2010");
				provincedb.get(12).add(nuts310);
				
				String denprov = province.get("Denominazione provincia");
				provincedb.get(13).add(denprov);
				
				String sigla = province.get("Sigla automobilistica");
				provincedb.get(14).add(sigla);
				
			}
	
			
			province.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public String getNomeProvincia(String sigla){
		int i, j;
		String risposta = null;
		
		for (i=0; i<15; i++){
			
			for (j=0; j<provincedb.get(i).size(); j++){
				if (provincedb.get(i).get(j).equals(sigla)) risposta = provincedb.get(i-1).get(j);
			}
		
		}
		return risposta;
	}
	
	public String getSiglaProvincia(String nome){
		int i, j;
		String risposta = null;
		
		for (i=0; i<15; i++){
			
			for (j=0; j<provincedb.get(i).size(); j++){
				if (provincedb.get(i).get(j).equals(nome)) risposta = provincedb.get(i+1).get(j);
			}
		
		}
		return risposta;
	}

    public String getAll(String input){
        int i, j;
        String risposta = "";

        for (i = 0; i<15; i++){
            for (j=0; j<provincedb.get(i).size(); j++){
                if (provincedb.get(i).get(j).equals(input)){
                    for (int k = 0; k<15; k++) {
                        risposta = risposta + provincedb.get(k).get(j) + '\n';
                    }
                }
            }
        }

        return risposta;
    }

}