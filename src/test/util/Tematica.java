package test.util;


public class Tematica {
	
	private Sesion sesionM;//Sesion de la mañana
	private Sesion sesionT;//Sesion de la tarde
	
	public Tematica(Sesion sesionM, Sesion sesionT){
		this.sesionM = sesionM;
		this.sesionT = sesionT;
	}
	
	public Sesion getSesionM(){
		return this.sesionM;
	}
	
	public Sesion getSesionT(){
		return this.sesionT;
	}
	
	@Override
	public String toString() {
		return "MAÑANA\n"+this.sesionM.toString()+"TARDE:\n"+this.sesionT.toString();		
	}
	    
}