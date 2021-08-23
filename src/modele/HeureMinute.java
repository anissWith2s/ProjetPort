package modele;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import constantes.ConstantesCalendrier;

import java.util.Calendar;
 
/**
 * HeureMinute est la classe qui d�finit une heure et des minutes 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class HeureMinute implements ConstantesCalendrier,Serializable {

  private int jourSemaine ;
  private int heure;
  private int minute;
  private int seconde;
  private static final long serialVersionUID = -6532501823666366754L;
  
  /** 
   * Constructeur de HeureMinute qui ne prend aucun param�tre 
   * Initialise les champs a la date du Systeme
   */ 
  
  public HeureMinute ()   { 
	  GregorianCalendar dateAuj = new GregorianCalendar ();
	  heure = dateAuj.get (Calendar.HOUR);
	  minute = dateAuj.get (Calendar.MINUTE); 

  }

	/** 
   * Constructeur de HeureMinute 
   * @param parHeure d�finit l'heure
   * @param parMinute d�finit une minute
   */ 
  public HeureMinute (int parHeure, int parMinute)   {   
	heure = parHeure;
	minute = parMinute;
  }
  
  /**
   * M�thode toString de la classe HeureMinute
   * @return l'objet heure et minute 
  */
  public String toString () {
    return   + heure + ":" + minute;	  
  }  


  /**
   * m�thode getHeure de la classe HeureMinute 
   * Accede a l'heure
   * @return l'heure
   */
	public int getHeure() { 
		return heure;
	}
	
   /**
   * m�thode getMinute de la classe HeureMinute 
   * Accede � une minute
   * @return une minute 
   */	
	public int getMinute() { 
		return minute;
	}


	/**
	 * m�thode parseHeureMinute de la classe HeureMinute 
	 * permet de transformer un string en Heure/Minute
	 * @param parTokenDate un String qui contient une heure et une minute
	 * @return heure/minute 
	 */

	public static HeureMinute parseHeureMinute(String parTokenHeure) {
	
		
		StringTokenizer heure_min = new StringTokenizer(parTokenHeure,":");
		String heure = heure_min.nextToken();
		String minute = heure_min.nextToken();
		
		//si les valeurs sont nul retourner 0 
		if (heure.equals("--") && minute.equals("--") ) {
			return new HeureMinute(0,0);
		}
		int intheure = Integer.parseInt(heure);
		int intminute = Integer.parseInt(minute);
	
		return new HeureMinute(intheure,intminute);
	
		
	}
	
	
	}  // class Date