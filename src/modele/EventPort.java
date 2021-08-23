package modele;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import constantes.ConstantesPorts;

/**
 * EventPort est la classe permet de cr�e un evenement pour un port et une date 
 * @see Date
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class EventPort implements Comparable <EventPort>,Serializable, ConstantesPorts {
	
	private Date date ;
	private String port;


	/** 
    * Constructeur de EventPort 
    * @param parDate Objet de la classe Date
    * @param parPort le port de l'event
    * @see Date
    */ 
	
	public EventPort (Date pardate, String parPort) throws ExceptionDate {
		
		if (pardate.getMois() < 10) {
			date = pardate;
			port = parPort;
		}else throw new ExceptionDate("Pas de donn�e disponible pour ce mois");
		

	}

	/**
	 * m�thode getDate de la classe EventPort 
	 * Accede a la date
	 * @return la date
	 */
	 public Date getDate ()  {
		    return date;
     }
	 
	 /**
	 * m�thode getPort de la classe EventPort 
	 * Accede a la date
     * @return le port en String 
	 */
	  public String getPort ()  {
		    return port;
	 }
	  
	 
	
	public int compareTo(EventPort o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * m�thode toString de la classe EventPort 
	 * Permet de convertir l'objet en chaine de caract�re.
	 * @return l'objet date et port 
	 */
	public String toString () {
		  return date + " - " + port  ;
	  }

}
