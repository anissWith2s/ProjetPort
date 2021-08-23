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
 * MareeJour est la classe qui contient les diff�rents Mar�e d'un jour 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class MareeJour implements Serializable{
	
	
	private ArrayList <Maree> listeMarre ;
	private HashMap <Integer, ArrayList <Maree>> hashMapMarre;
	private Date date;
	private Maree marre;
	private static final long serialVersionUID = -6269912554833473967L;
	
	/** 
	* Constructeur de MareeJour qui ne prend aucun param�tre 
    * Initialise une hashmap et une arraylist contenant des mar�es
	*/ 
   public MareeJour (){
		
	     hashMapMarre = new HashMap <> ();
	     listeMarre = new  ArrayList <Maree>();
	
		
	}

   /**
    * Methode ajoutMareePayant de la classe MareeJour
    * Permet d'ajouter des mar�es de la classe Marre dans une collection puis dans une hashMap avec le jour de la date en cl� 
    * @param parTokenDate String contenant la date 
    * @param parMarre objet de la classe Marre 
    */
	public void ajoutMareePayant (String parTokenDate, Maree parMarre){
		
	
		this.marre = parMarre;
		date = Date.parseDate(parTokenDate);
		
		//ajoute les mar�es dans une ArrayList 
		listeMarre.add(parMarre);
		int jour = date.getJour();
		
		//si hashmap contient la cl� (jour) alors ajouter la mar�e
		if (hashMapMarre.containsKey(jour)) { 		
			hashMapMarre.get(jour).add (parMarre);	
			 }
		
		
		//sinon cr�e une nouvelle ArrayList puis l'ajouter dans une HashMap avec le jour de la date pour cl� 
		else {
			 ArrayList <Maree> liste = new ArrayList <Maree> ();
			 liste.add (parMarre);
			 gethashMapMarre().put (jour, liste);		 
		}
		
	}
	
	  /**
	  * Methode ajoutMarreGratuit de la classe MareeJour
	  * Permet d'ajouter des mar�es de la classe Marre dans une collection puis dans une hashMap avec le jour de la date en cl� pour le mois associ� � l'�v�nement du port   
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
	 * m�thode gethashMapMarre de la classe MareeJour 
	 * Accede � l'HashMap qui contient le jour pour un mois et une arraylist contenant les mar�es 
	 * @return hashMapMarre 
	 */

	public HashMap <Integer, ArrayList <Maree>> gethashMapMarre() {
		return hashMapMarre;
	}
	
	 /**
	   * M�thode toString de la classe MareeJour
	   * @return String contenant les mar�es 
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
   * Permet de retourner une collection qui contient en cl� le jour re�u dans le param�tre
   * @param jour 
   * @return collection de marre contenant le jour en cl� 
   */	 
  public Collection <Maree> getEvenementsjour (int jour) {
		return hashMapMarre.get(jour);
	}
  
  /**
   * m�thode getMarreDate de la classe MareeJour 
   * Accede � la date 
   * @return la date 
   */
	public Date getMarreDate() {
		return date; 
	}
	
	/**
    * m�thode getMarre de la classe MareeJour 
    * Accede � la collection de mar�e 
    * @return la collection de mar�e 
    */
	public ArrayList<Maree> getMarre() {
		return listeMarre; 
	}
	





}
