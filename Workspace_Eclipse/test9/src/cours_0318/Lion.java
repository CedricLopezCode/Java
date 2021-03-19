package cours_0318;

public class Lion extends Animal {
	public String identifier() {
		//super oblige à celui des parents quand meme nom
		return super.identifier() + "lion";}
	public String crier() {return "Rugir";}
	
	
	}
