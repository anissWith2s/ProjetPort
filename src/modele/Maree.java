package modele;

import java.io.Serializable;

/**
 * Maree est la classe qui d�finit une mar�e
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
	 * m�thode getMarreCoef de la classe Mar�e 
	 * Acc�de au coef de la mar�e
	 * @return coef
	 */
	public int getMarreCoef() {
		return coef; 
	}
	
	/**
	 * m�thode getMarreHauteur de la classe Mar�e 
	 * Acc�de � l'hauteur de la mar�e
	 * @return hauteur
	 */
	public float getMarreHauteur() {
		return hauteur; 
	}
	
	/**
	 * m�thode getMarreHM de la classe Mar�e 
	 * Acc�de � l'heure/minute de la mar�e
	 * @return heure/minute
	 */
	public HeureMinute getMarreHM() {
		return heureminute; 
	}
	
	  /**
	   * M�thode toString de la classe Mar�e
	   * @return l'objet heure/minute, hauteur et coef 
	  */
    public String toString () {
	   
	   return heureminute + "/" + hauteur + "/" + coef ;
      
    }

}
