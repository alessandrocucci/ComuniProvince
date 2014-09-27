package it.alessandrocucci.comuniprovince;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Comune {

    List<List<String>> comunidb = new ArrayList<List<String>>();

    public Comune(){
        for (int i = 0; i < 23; i++ ){
            comunidb.add(new ArrayList<String>());
        }


        try {
            CsvReader comuni = new CsvReader("data/comuni.csv");

            comuni.readHeaders();

            while (comuni.readRecord())
            {
                String ripgeo = comuni.get("Ripartizione geografica");
                comunidb.get(0).add(ripgeo);

                String nuts2 = comuni.get("Codice NUTS2 2010");
                comunidb.get(1).add(nuts2);

                String nuts3 = comuni.get("Codice NUTS3 2010");
                comunidb.get(2).add(nuts3);

                String codreg = comuni.get("Codice Regione");
                comunidb.get(3).add(codreg);

                String codprov = comuni.get("Codice Provincia");
                comunidb.get(4).add(codprov);

                String codcom = comuni.get("Codice Comune");
                comunidb.get(5).add(codcom);

                String codist = comuni.get("Codice Istat del Comune formato alfanumerico");
                comunidb.get(6).add(codist);

                String codistnum = comuni.get("Codice Istat del Comune formato numerico");
                comunidb.get(7).add(codistnum);

                String codist103 = comuni.get("Codice Istat del Comune a 103 province formato numerico");
                comunidb.get(8).add(codist103);

                String codist107 = comuni.get("Codice Istat del Comune a 107 province formato numerico");
                comunidb.get(9).add(codist107);

                String codcat = comuni.get("Codice Catastale");
                comunidb.get(10).add(codcat);

                String nome = comuni.get("Solo denominazione in italiano");
                comunidb.get(11).add(nome);

                String tedesco = comuni.get("Solo denominazione in tedesco");
                comunidb.get(12).add(tedesco);

                String capoluogo = comuni.get("Comune capoluogo di provincia");
                comunidb.get(13).add(capoluogo);

                String zona = comuni.get("Zona altimetrica");
                comunidb.get(14).add(zona);

                String altitudine = comuni.get("Altitudine del centro metri");
                comunidb.get(15).add(altitudine);

                String litoraneo = comuni.get("Comune litoraneo");
                comunidb.get(16).add(litoraneo);

                String montano = comuni.get("Comune Montano");
                comunidb.get(17).add(montano);

                String sis2001 = comuni.get("Codice Sistema locale del lavoro 2001");
                comunidb.get(18).add(sis2001);

                String densis2001 = comuni.get("Denominazione Sistema locale del lavoro 2001");
                comunidb.get(19).add(densis2001);

                String kmq = comuni.get("Superficie territoriale totale kmq");
                comunidb.get(20).add(kmq);

                String pop2001 = comuni.get("Popolazione legale 2001");
                comunidb.get(21).add(pop2001);

                String pop2011 = comuni.get("Popolazione legale 2011");
                comunidb.get(22).add(pop2011);

            }


            comuni.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTuttiComuni(String codprov){
        String risposta = "";
        for (int i = 0; i < comunidb.get(2).size(); i++){
            if (comunidb.get(2).get(i).equals(codprov)) risposta = risposta + comunidb.get(11).get(i) + '\n';
        }
        return risposta;
    }

    public String getNomeProvincia(String comune){
        String risposta ="";


        for (int j=0; j<comunidb.get(11).size(); j++){
                if (comunidb.get(11).get(j).equals(comune)) risposta = comunidb.get(2).get(j);
        }

        Provincia provincia = new Provincia();
        risposta = provincia.getNomeDaCodice(risposta);

        return risposta;
    }
}
