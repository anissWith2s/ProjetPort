package modele;

import java.util.TreeSet;
import java.io.Serializable;
import java.util.Collection;

/**
 * CalendrierDuMois est la classe qui définit un calendrier contenant les jours pour un mois et une annee dans une collection de date  
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class CalendrierDuMois{	
  
  private Collection <Date> treeSetDate;	  
  
  /** 
   * Constructeur de CalendrierDuMois 
   * Stock dans une collection les jours d'un mois
   * @param mois 
   * @param annee 
   */ 
  public CalendrierDuMois ( int mois, int annee) {			   
	    treeSetDate = new TreeSet <Date> ();
	    Date date = new Date (1,mois,annee);
	    int indiceJour = date.getJourSemaine() ;
	    for (int x = indiceJour ; x!=0 ; x--) {	    	 
	    	treeSetDate.add(date);	    	
	    	date = date.dateDeLaVeille();
	    }	    
	    date = new Date (2,mois,annee);
	    indiceJour = indiceJour % 7 ;
	    while (date.getMois () == mois) {
	      while(indiceJour<7) {
	    	treeSetDate.add(date);
	    	date = date.dateDuLendemain();
	    	indiceJour++ ;
	      } 
	      indiceJour=0;
	    }    
	  }
  

  /**
   * méthode getDates de la classe CalendrierDuMois 
   * Accede à la collection qui contient la date 
   * @return collection qui contient la date 
   */
public Collection <Date> getDates() {	
	return treeSetDate;	
}	

/**
 * Méthode toString de la classe CalendrierDuMois
 * @return une collection 
*/
public String toString () {
	return treeSetDate.toString();
}
    
}