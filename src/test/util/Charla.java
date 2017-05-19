package test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Charla implements Comparable<Charla>, Cloneable {
    private String descripcion;
    private String subject;
    private Integer time;
    private boolean valid;
    private Integer indexInList;    
    private double startTimeInhours;

    public Charla(String description){
    	this.indexInList = 0;
        this.descripcion = description;
        this.startTimeInhours = 0;
        this.proccesLine();        
    }

    private void proccesLine(){
        String string = "(\\D+)(\\d+min|lightning)";
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(this.descripcion);

        this.valid = matcher.find();

        if (this.valid){
            this.subject = matcher.group(1);
            String group2  = matcher.group(2);
            if ( group2.contains("min") ){
                this.time = Integer.valueOf(group2.replaceAll("min",""));
            }
            else if (group2.contains("lightning")){
                this.time = 5;
            }
        }
    }

    public boolean isValid(){
        return this.valid;
    }

    public String getSubject(){
        return this.subject;
    }

    public Integer getTime(){
        return this.time;
    }
    
    public void setIndexList(Integer index){
    	this.indexInList = index;
    }
    
    public Integer getIndexList(){
    	return this.indexInList;
    }

	public String getStartTime() {
		int horas = (int)this.startTimeInhours;
		int minutos = (int)((this.startTimeInhours-horas)*60);		
		return  String.valueOf(horas)+":"+String.valueOf(minutos);
	}
	

	public void setStartTimeInhours(double startTimeInhours) {
		this.startTimeInhours = startTimeInhours;
	}

	@Override
	public int compareTo(Charla o) {		
		return new Integer(this.time).compareTo(new Integer(o.getTime()));
	}
	
	@Override
	public String toString() {
		return this.getStartTime()+" "+ this.descripcion;
	}	
	
}