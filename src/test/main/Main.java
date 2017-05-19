package test.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import test.util.Charla;
import test.util.Tematica;
import test.util.file.LeeArchivoUtil;
import test.util.logica.ConstruyeUtil;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Problema Dos: Administración de Temas de Conferencia");
		
		String ruta = "";
		if (args.length==0){
			System.out.println("DEBE EJECUTAR EL PROGRAMA INGRESANDO COMO PARAMETRO LA RUTA DEL ARCHIVO :-(");
		}
		else{
			ruta = args[0];
			System.out.println("Ruta del archivo que se procede ha leer es:"+ruta);
		}
		
		List<Charla> charlasList = null;
		try {			
			charlasList = LeeArchivoUtil.getCharlasList(ruta);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se pudo localizar el archivo con la lista de charlas:"+e.getMessage());
		}
        	
        Collections.sort(charlasList);
        
        boolean continuar = true;        
        List<Tematica> listaTematicas = new ArrayList<Tematica>();
        
        while (continuar){
        	Tematica tematica = ConstruyeUtil.getTematica(charlasList);
        	continuar = tematica != null;
        	if (continuar){
        		listaTematicas.add(tematica);
        	}
        }
        
        System.out.println("Lista de tematicas encontradas es:");
        for(Tematica tematica: listaTematicas){
        	System.out.println("TEMATICA--->");
        	System.out.println(tematica.toString());
        }
        
        System.out.println("FIN DEL PROGRAMA--->");        
	}
	
}