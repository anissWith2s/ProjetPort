package controleur;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import modele.Date;
import modele.EventPort;
import modele.ExceptionDate;
import modele.LectureEcriture;
import modele.LectureTranscription;
import modele.MareeJour;
import modele.RechercheFichier;

import vue.BoutonDate;
import vue.PanelAffichage;
import vue.PanelCalendrier;
import vue.PanelFormulaire;

/**
 * Le controleur répond aux actions effectués par le clique sur le bouton "recherche" et met en relation la vue et le modèle 
 * @see LectureTranscription
 * @see LectureEcriture
 * @see File
 * @see RechercheFichier
 * @see PanelCalendrier
 * @see PanelFormulaire
 * @see MareeJour
 * @see PanelAffichage
 * @author Thevakumaran Krishnath @author Hassan Aniss
 *
 */

public class Controleur implements ActionListener {
	
    private LectureTranscription lecture = new LectureTranscription();
    private LectureEcriture ecriture ;
    private File fichier;
    private RechercheFichier rechercheFichier;
    private PanelCalendrier panelCalendrier;
    private PanelFormulaire panelFormulaire;
    private MareeJour marreJour;
    private PanelAffichage panelAffichage;

    /** 
     * Constructeur de Controleur 
     * @param panelCalendrier correspond a un PanelCalendrier
     * @param panelFormulaire correspond a un PanelFormulaire
     * @param recherche correspond a une RechercheFichier
     * @param marreJour correspond a un MarreJour
     * @param panelAffichage correspond a un PanelAffichage 
     * @param file correspond a un objet File 
     * Le controleur ce met a l'écoute des elements des panels
     */ 

    public Controleur(PanelCalendrier panelCalendrier, PanelFormulaire panelFormulaire, RechercheFichier recherche, MareeJour marreJour, PanelAffichage panelAffichage,File file) {

    	this.marreJour = marreJour;
    	this.panelCalendrier = panelCalendrier;
    	this.panelFormulaire = panelFormulaire;
    	this.rechercheFichier = recherche;
        this.panelAffichage = panelAffichage;
        this.fichier = file;
    	
        //calendrier et formulaire à l'écoute des actions 
        panelCalendrier.enrigistreEcouteur(this);
        panelFormulaire.enrigistreEcouteur(this);
    }
    
	/**
	* méthode actionPerformed permet d'effectuer une action lorsque l'on clique sur "Recherche" et met en relation la vue et le modèle, lève une exception si le mois est supérieur au 9ème mois
	* @param evt l'évenement qui se déroule lors des actions
	* 
	*/
	public void actionPerformed(ActionEvent evt) {
		
		//action lors du clique 
		if (evt.getActionCommand().equals("Recherche")) {
			
			EventPort nouveau;
			try {
				nouveau = panelFormulaire.getEvenement();
				rechercheFichier.recherche(nouveau);
			    marreJour = lecture.getMareeUnJourTranscrit();
			    ecriture.ecriture(fichier, marreJour);
			    //System.out.println(marreJour.getEvenementsjour(nouveau.getDate().getJour())); -> test
			    panelAffichage.update(nouveau.getDate(),marreJour);
			    
			} catch (ExceptionDate e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			
		}
		
	    if (evt.getSource() instanceof BoutonDate ){
			Date date = ((BoutonDate) evt.getSource()).getDate();
			panelFormulaire.setDate(date);
		}
		
	}
	

}

