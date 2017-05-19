package test.util;


import java.util.List;

public class Sesion {
	
	private List<Charla> charlas;
	private int startTime;
	
	public Sesion(List<Charla> charlas, int startTimeInHour){
		this.charlas = charlas;
		this.startTime = startTimeInHour;
		setStartTimeByCharla();
	}
	
	public List<Charla> getCharlas(){
		return this.charlas;
	}	
	
	private void setStartTimeByCharla(){
		double currentTime = this.startTime;
		for (Charla charla: this.charlas){			
			charla.setStartTimeInhours(currentTime);
			int duration = charla.getTime();
			//Se transforma a horas 
			double nhora = duration/60.00;
			currentTime = currentTime+nhora;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(Charla charla:this.charlas){
			buffer.append(charla.toString()+"\n");
		}
		return buffer.toString();
	}	
}