package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import vue.BoutonDate;
import vue.PanelFormulaire;
/**
 * MareeJour est la classe qui contient les différents Marée d'un jour 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class MareeJour implements Serializable{
	
	
	private ArrayList <Maree> listeMarre ;
	private HashMap <Integer, ArrayList <Maree>> hashMapMarre;
	private Date date;
	private Maree marre;
	private static final long serialVersionUID = -6269912554833473967L;
	
	/** 
	* Constructeur de MareeJour qui ne prend aucun paramètre 
    * Initialise une hashmap et une arraylist contenant des marées
	*/ 
   public MareeJour (){
		
	     hashMapMarre = new HashMap <> ();
	     listeMarre = new  ArrayList <Maree>();
	
		
	}

   /**
    * Methode ajoutMareePayant de la classe MareeJour
    * Permet d'ajouter des marées de la classe Marre dans une collection puis dans une hashMap avec le jour de la date en clé 
    * @param parTokenDate String contenant la date 
    * @param parMarre objet de la classe Marre 
    */
	public void ajoutMareePayant (String parTokenDate, Maree parMarre){
		
	
		this.marre = parMarre;
		date = Date.parseDate(parTokenDate);
		
		//ajoute les marées dans une ArrayList 
		listeMarre.add(parMarre);
		int jour = date.getJour();
		
		//si hashmap contient la clé (jour) alors ajouter la marée
		if (hashMapMarre.containsKey(jour)) { 		
			hashMapMarre.get(jour).add (parMarre);	
			 }
		
		
		//sinon crée une nouvelle ArrayList puis l'ajouter dans une HashMap avec le jour de la date pour clé 
		else {
			 ArrayList <Maree> liste = new ArrayList <Maree> ();
			 liste.add (parMarre);
			 gethashMapMarre().put (jour, liste);		 
		}
		
	}
	
	  /**
	  * Methode ajoutMarreGratuit de la classe MareeJour
	  * Permet d'ajouter des marées de la classe Marre dans une collection puis dans une hashMap avec le jour de la date en clé pour le mois associé à l'évènement du port   
	  * @param parTokenDate String contenant la date 
	  * @param parMarre objet de la classe Marre 
	  * @param parEvt objet de la classe EventPort 
	  */	
	public void ajoutMarreGratuit (String parTokenDate, Maree parMarre, EventPort parEvt){
			
			
			this.marre = parMarre;
			date = Date.parseDate(parTokenDate);
			if (date.getMois() == parEvt.getDate().getMois()) {

				listeMarre.add(parMarre);
				int jour = date.getJour();
					
				if (hashMapMarre.containsKey(jour)) { 		
					hashMapMarre.get(jour).add (parMarre);	
					 }
					
				else {
					 ArrayList <Maree> liste = new ArrayList <Maree> ();
					 liste.add (parMarre);
					 gethashMapMarre().put (jour, liste);		 
				}
			}
		}
			

		
	
	/**
	 * méthode gethashMapMarre de la classe MareeJour 
	 * Accede à l'HashMap qui contient le jour pour un mois et une arraylist contenant les marées 
	 * @return hashMapMarre 
	 */

	public HashMap <Integer, ArrayList <Maree>> gethashMapMarre() {
		return hashMapMarre;
	}
	
	 /**
	   * Méthode toString de la classe MareeJour
	   * @return String contenant les marées 
	  */
	 public String toString () {
	    String chaine =  "\n" + listeMarre + "\n" ;
	    Set <Integer> clefs = gethashMapMarre().keySet ();
	    Iterator <Integer> iterateur =clefs.iterator();
	    while (iterateur.hasNext()) {
			 Integer clef = iterateur.next();
			 ArrayList <Maree> liste = gethashMapMarre().get(clef);
			 chaine += clef + " : " + liste + "\n";
			 }
		return chaine;
	
			
	}
	
  /**
   * Methode getEvenementsjour de la classe MareeJour
   * Permet de retourner une collection qui contient en clé le jour reçu dans le paramètre
   * @param jour 
   * @return collection de marre contenant le jour en clé 
   */	 
  public Collection <Maree> getEvenementsjour (int jour) {
		return hashMapMarre.get(jour);
	}
  
  /**
   * méthode getMarreDate de la classe MareeJour 
   * Accede à la date 
   * @return la date 
   */
	public Date getMarreDate() {
		return date; 
	}
	
	/**
    * méthode getMarre de la classe MareeJour 
    * Accede à la collection de marée 
    * @return la collection de marée 
    */
	public ArrayList<Maree> getMarre() {
		return listeMarre; 
	}
	





}
