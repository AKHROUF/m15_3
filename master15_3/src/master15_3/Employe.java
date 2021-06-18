package master15_3;

public class Employe {

	private int id;
	private String nom;
	private char sexe;
	private double salaire;
	
	private int idDepartement;
	
	public Employe() {	
	}

	public Employe(int id, String nom, char sexe, double salaire, int idDepartement) {
		super();
		this.id = id;
		this.nom = nom;
		this.sexe = sexe;
		this.salaire = salaire;
		this.idDepartement = idDepartement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public int getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}
	
	
}
