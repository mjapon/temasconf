package test.util.logica;

import java.util.ArrayList;
import java.util.List;

import test.util.Charla;
import test.util.Sesion;
import test.util.Tematica;

public class ConstruyeUtil {
	
	/**
	 * Buscar el grupo de charlas que tenga el mayor numero de ellas
	 * @param tipo
	 * @param planes
	 * @return
	 */
	public static List<Charla> findGrupo(String tipo, List<Charla> planes){		
        List<Charla> sumaGrupo;
        Integer suma = 0;
        List<List> sumasGrupos = new ArrayList<>();
        
        boolean grupoFinded = false;
        for (int j=0;j<planes.size()-1;j++){        	
            sumaGrupo = new ArrayList<Charla>();
            Charla tematicaItemI = planes.get(j);            
            int timeIter = tematicaItemI.getTime();
            
            suma = timeIter;            
            sumaGrupo.add(tematicaItemI);
            
            grupoFinded = false;

            for(int i=j+1;i<planes.size();i++){                
            	Charla tematicaIterJ = planes.get(i);
                int timeIterJ = tematicaIterJ.getTime();
                
                sumaGrupo.add(tematicaIterJ);
                suma = suma + timeIterJ;
                
                //Logica para el caso de las sesion de la mañana
                if ("A".equalsIgnoreCase(tipo)){
                    if (suma<=180){
                        if (suma<180){
                            continue;
                        }
                        else if (suma==180){
                            grupoFinded = true;
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                else{//para el caso de la sesion de la tarde 
                	if(( suma>=180) && (suma<=240)){
                		grupoFinded = true;
                        break;
                    }
                    else {
                        continue;
                    }
                }
            }
            if (grupoFinded){
                sumasGrupos.add(sumaGrupo);
            }
        }
        
        int max = 0;
        int indexlistamax = -1;
        if (sumasGrupos.size()>0){
            //Se debe obtener el grupo que mas items tiene
            for (int i=0; i<sumasGrupos.size();i++) {
                int currentsize = sumasGrupos.get(i).size();
                if (currentsize > max){
                    max = currentsize;
                    indexlistamax = i;
                }
            }
        }        
        
        if (indexlistamax>-1){
            return sumasGrupos.get(indexlistamax);
        }        
        return null;
    }
	
	/**
	 * Borrar las charlas que ya fueron consideradas en la lista de charlas
	 * @param grupo
	 * @param allitems
	 * @return
	 */
	public static List<Charla> deleteItems(List<Charla> grupo, List<Charla> allitems ){		
		if (grupo != null && grupo.size()>0){
			allitems.removeAll(grupo);
		}
		return allitems;		
	}
	
	/**
	 * Obtiene una sesion para una tematica
	 * @param tipo
	 * @param charlasList
	 * @return
	 */
	public static Sesion getSesion(String tipo, List<Charla> charlasList){
		
		List<Charla> grupoTematica = findGrupo(tipo, charlasList);
		Sesion sesion = null;
		
		int startHour = 0;
		if (tipo=="A"){
			startHour = 9;
		}
		else{
			startHour = 13;
		}
        
        if (grupoTematica != null){
        	sesion = new Sesion(grupoTematica, startHour);
        	
        	//borrar el grup encontrado de charlasList
        	deleteItems(grupoTematica, charlasList);        	
        }
        else{
        	System.out.println("No se pudo encontrar el grupo de la tematica "+tipo);
        }
        
        return sesion;		
	}
	
	public static Tematica getTematica(List<Charla> charlasList){		
		Sesion sesionA = getSesion("A", charlasList);//Sesion de la mañana
        Sesion sesionB = getSesion("B", charlasList);//Sesion de la tarde        
        
        if ((sesionA != null)&&(sesionB!=null)){
        	return new Tematica(sesionA, sesionB);        	
        }
        
        return null;
	}
}