package modele;

import java.io.Serializable;

/**
 * Maree est la classe qui définit une marée
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class Maree implements Serializable{
	
	public HeureMinute heureminute;
	public float hauteur;
	public int coef; 
	private static final long serialVersionUID = -7653036403957139203L;
	
	 /** 
	 * Constructeur de Maree pour pleine mer
	 * @param parTokenHeureMinute un string qui contient une heure/minute de la mer 
	 * @param parTokenHauteur un string qui contient l'hauteur de la mer 
	 * @param parTokenCoef un string qui contient le coef de la mer
	 */ 
    //pour marreePM
	public Maree(String parTokenHeureMinute, String parTokenHauteur, String parTokenCoef ){
		
		heureminute = HeureMinute.parseHeureMinute(parTokenHeureMinute);
		
		//si String existe pas alors mettre -1 pour le distinguer dans le celluleRenderer 
		if (parTokenHauteur.equals("--.--")) {
			
			hauteur = (float) -1.0;
		}
		else 
		    hauteur = Float.parseFloat(parTokenHauteur)	;
		
		if (parTokenCoef.equals("---")) {
			coef = -1;
		}
		else 
			coef = Integer.parseInt(parTokenCoef)	;
		
	}
	
	 /** 
	 * Constructeur de Maree pour basse mer
	 * @param parTokenHeureMinute un string qui contient une heure/minute de la mer 
	 * @param parTokenHauteur un string qui contient l'hauteur de la mer 
	 */
	
	//pour marreBM
	public Maree(String parTokenHeureMinute, String parTokenHauteur){
		

		heureminute = HeureMinute.parseHeureMinute(parTokenHeureMinute);

		if (parTokenHauteur.equals("--.--")) {
			hauteur = (float) -1.0;
		}
		else 
		    hauteur = Float.parseFloat(parTokenHauteur)	;
	}
	
	

	/**
	 * méthode getMarreCoef de la classe Marée 
	 * Accède au coef de la marée
	 * @return coef
	 */
	public int getMarreCoef() {
		return coef; 
	}
	
	/**
	 * méthode getMarreHauteur de la classe Marée 
	 * Accède à l'hauteur de la marée
	 * @return hauteur
	 */
	public float getMarreHauteur() {
		return hauteur; 
	}
	
	/**
	 * méthode getMarreHM de la classe Marée 
	 * Accède à l'heure/minute de la marée
	 * @return heure/minute
	 */
	public HeureMinute getMarreHM() {
		return heureminute; 
	}
	
	  /**
	   * Méthode toString de la classe Marée
	   * @return l'objet heure/minute, hauteur et coef 
	  */
    public String toString () {
	   
	   return heureminute + "/" + hauteur + "/" + coef ;
      
    }

}
