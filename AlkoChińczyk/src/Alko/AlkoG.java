package Alko;

public class AlkoG {
	private String name;
	private int pole;
	boolean ruch;
	
	AlkoG(){
		this.name="";
		this.pole=0;
		this.ruch=true;
	}
	int getPole(){
		return pole;
	}
	void poleNast(){
		pole++;
	}
	String getName(){
		return name;
	}
	
	void nowyRuch(){
		ruch=true;
	}
	void poRuchu(){
		ruch=false;
	}
}
