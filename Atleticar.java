package discipline;

public abstract class Atleticar {
	private String punoIme;
	protected double rezultat;
	
	public Atleticar() {
	}
	
	public Atleticar(String punoIme, double rezultat) {
		this.punoIme = punoIme;
		this.rezultat = rezultat;
	}
	public String getPunoIme() {
		return punoIme;
	}
	public void setPunoIme(String punoIme) {
		this.punoIme = punoIme;
	}
	public double getRezultat() {
		return rezultat;
	}
	public void setRezultat(double rezultat) {
		this.rezultat = rezultat;
	}
//	this bolji od a
//	atleticar.daLiJeBolji(atleticar2);
//	string1.equals(string2);
	public abstract boolean daLiJeBolji(Atleticar a);
	
	public void stampaj() {
		System.out.println(this.punoIme + ", " + this.rezultat);
	}
	
	
}
