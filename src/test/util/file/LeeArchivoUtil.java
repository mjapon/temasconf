package test.util.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import test.util.Charla;

public class LeeArchivoUtil {
	
	public static List<Charla> getCharlasList(String filePath) throws FileNotFoundException, IOException{
		
		String cadena;
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        List<Charla> charlasList = new ArrayList<>();
		
		while ((cadena = bufferedReader.readLine()) != null) {
			charlasList.add(new Charla(cadena));			
		}
		
		bufferedReader.close();
		fileReader.close();
		
		return charlasList;
		
	}	
	
}