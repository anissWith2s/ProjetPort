package modele;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import constantes.ConstantesCalendrier;

import java.util.Calendar;

/**
 * Date est la classe qui définit une date
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class Date implements Comparable <Date>,ConstantesCalendrier,Serializable {
  private int jour;
  private int mois;
  private int annee;
  private int jourSemaine ;

  /** 
   * Constructeur de Date qui ne prend aucun paramètre 
   * Initialise les champs a la date du Systeme
   */ 
  public Date ()   { 
	  GregorianCalendar dateAuj = new GregorianCalendar ();
	  annee = dateAuj.get (Calendar.YEAR);
	  mois = dateAuj.get (Calendar.MONTH) + 1; 
	  jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	  jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);

	  if (jourSemaine == 1)
		  jourSemaine = 7;
	  else jourSemaine -= 1; 
  }
  
	/** 
   * Constructeur de Date 
   * @param parJour définit le jour 
   * @param parMois définit le mois 
   * @param parAnnee définit l'année 
   */ 
  
  public Date (int parJour, int parMois, int parAnnee)   {   
	jour = parJour;
	mois = parMois;
	annee = parAnnee; 
	GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
	jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
	if (jourSemaine == 1)
		  jourSemaine = 7;
	else jourSemaine -= 1; 
  }
  
  /** 
   * Constructeur de Date
   * @param parMinute définit une minute
   * @param parHeure définit l'heure
   * @param parJour définit le jour 
   * @param parMois définit le mois 
   * @param parAnnee définit l'année 
   */ 
  
  public Date (int parJour, int parMois, int parAnnee, int parHeure, int parMinute)   {   
	jour = parJour;
	mois = parMois;
	annee = parAnnee; 

	
	GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
	jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
	if (jourSemaine == 1)
		  jourSemaine = 7;
	else jourSemaine -= 1; 
  }
   
  /**
   * Methode compareTo de la classe date
   * Permet de comparer les dates 
   * @param parDate
   * @return 0 si this et parDate sont égales, 
   * @return -1 si this précède parDate,
   * @return 1 si parDate précède this
   */
  public int compareTo (Date parDate) {
    if (annee < parDate.annee)
		return -1;
	if (annee > parDate.annee)
		return 1;
	
	if (mois < parDate.mois)
		return -1;
	if (mois > parDate.mois)
		return 1;
	
	if (jour < parDate.jour)
		return -1;
	if (jour > parDate.jour)
		return 1;
	return 0;	
  }
 
  /**
   * Methode dateDuLendemain de la classe date
   * Permet de donner la date du lendemain 
   * @return la date du lendemain 
   */
  public Date dateDuLendemain ()   {	
    if (jour < dernierJourDuMois(mois,annee))
		     return  new Date (jour+1,mois,annee);
		else if (mois < 12)
				return new Date (1,mois+1,annee);
			 else return new Date (1,1,annee+1);	
  }  
  
  /**
   * Methode dateDeLaVeille de la classe date
   * Permet de donner la date de la veille 
   * @return la date de la veille 
   */
  public Date dateDeLaVeille () {    
	if (jour > 1)
			return  new Date (jour-1,mois,annee);
	else if (mois > 1)
			   return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		 else return  new Date (31,12,annee-1);
  }	 
  
  /**
   * Methode dernierJourduMois de la classe date
   * Permet de donner le dernier jour du mois 
   * @param parMois le mois de la date 
   * @param parAnnee l'année de la date 
   * @return un entier qui est le dernier jour du mois 
   */
  public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
			 case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			 case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			 default : return 31 ;
			}  // switch
	  } 
  
  /** 
   * Méthode estBissextile de la class Date 
   * @param parAnnee Corespond a l'année
   * @return Un test qui renvoi un boléen en fonction de l'année bissextile ou non
   */  
  private static boolean estBissextile(int parAnnee) {
			return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	  }
    
  /**
   * Méthode toString de la classe Date
   * @return l'objet jour, mois et l'annee 
  */
  public String toString () {
    return  jour + "/" +mois +"/" + annee ;	  
  }  
  
  /**
   * Méthode datePremierJourSemaine de la classe Date
   * @return le premier jour de la semaine  
  */
  public Date datePremierJourSemaine() { 
	Date today = this;
	while (today.getJourSemaine() != 1) {
		today = today.dateDeLaVeille();
	}
		
	return today;
	
   }
   
/**
 * méthode getAnnee de la classe Date 
 * Accede à l'année
 * @return l'année
 */
  public int getAnnee() { 
	return annee;
  }

/**
 * méthode getJour de la classe Date 
 * Accede au jour
 * @return le jour 
 */
	public int getJour() { 
		return jour;
	}

/**
 * méthode getMois de la classe Date 
 * Accede au mois
 * @return le mois
 */
	public int getMois() { 
		return mois;
	}


/**
 * méthode getJourSemaine de la classe Date 
 * Accede au jour de la semaine 
 * @return jour de la semaine 
 */

	public int getJourSemaine () {
		return jourSemaine;
	}

/**
 * méthode isToday de la classe Date 
 * permet de savoir la date d'ajourd'hui avec un boolean 
 * @return un boolean 
 */
	public boolean isToday() {
		return new Date().compareTo(this) == 0;
	}

/**
 * méthode parseDate de la classe Date 
 * permet de transformer un string en une date 
 * @param parTokenDate un String qui contient une date 
 * @return une date  
 */

	public static Date parseDate(String parTokenDate) {
		
		StringTokenizer decoup = new StringTokenizer(parTokenDate,"- /");
		String annee = decoup.nextToken();
		String mois = decoup.nextToken();
		String jour = decoup.nextToken();
	
		int intjour = Integer.parseInt(jour);
		int intmois = Integer.parseInt(mois);
		int intannee = Integer.parseInt(annee);
		
		//version gratuit l'année et le jour sont inversés
		if(intjour == 2021) {
			return new Date(intannee,intmois,intjour);
		}
		//pour la version payante 
		return new Date(intjour,intmois,intannee);
	
		
	}
}  // class Date