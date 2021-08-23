package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.CalendrierDuMois;
import modele.Date;
/**
 * 
 * Création d'un PanelMois qui va générer pour chaque Mois un panel avec le jour en nombre dans chaque boutons et avec les 7 jours en lettre au dessus  
 * @author Thevakumaran Krishnath et Hassan Aniss 
 *
 */


public class PanelMois extends JPanel implements ActionListener,ConstantesCalendrier, ConstantesCouleursFontes {

	BoutonDate boutonSelectionne ;	 	
	Collection <BoutonDate> collectionBoutons = new ArrayList <BoutonDate> ();
	
	/**
	* PanelMois constructeur 
	* @param mois : le mois 

	*/
	public PanelMois (int mois)  {
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendrierDuMois(mois,today.getAnnee()).getDates();
		//System.out.println(datesDuMois);		
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (JOURS_SEMAINE_ABR[i],JLabel.CENTER);
			this.add(labeljour);			
		}
		
		BoutonDate boutonJour;
		

		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next() ;
				boutonJour = new  BoutonDate (date);
				collectionBoutons.add(boutonJour);
				boutonJour.addActionListener(this);  // gestion des couleurs des boutons 
				this.add(boutonJour);
				 
				boutonJour.setBackground (WHITE);
				
			
				if (date.isToday()) {
					boutonJour.setBackground(BLEU);
				}	
				if (date.getMois()!=mois)
					boutonJour.setForeground(CHARRETTE);		
					
		}		
		
		setBackground (WHITE);
	}

	/**
	* actionPerformed permet d'effectuer une action lorsque l'on clique sur un bouton, change sa couleur et remet sa couleur lors d'une autre selection 
	* @param evt : l'évenement qui se déroule lors des actions
	*/
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (boutonSelectionne != null && !boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(WHITE);			
		}
		boutonSelectionne = (BoutonDate) evt.getSource();
		if (!boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(VERT);
			}		
	}
	
	/**
	* getBoutonSelectionne renvoie le bouton selectionne 
	* @return boutonSelectionne
	*/
	public JButton getBoutonSelectionne () {
		return boutonSelectionne;	
	}
	
	/** 
	* méthode enrigistreEcouteur de la classe PanelMois
	* La methode permet de mettre les boutons contenants les dates à l'ecoute du controleur 
	* @param parControleur Objet de la classe Controleur
	*/ 
	public void enrigistreEcouteur(Controleur parcontroleur) {
		
		for (BoutonDate boutondate : collectionBoutons ){
			boutondate.addActionListener(parcontroleur);
		}
		
	}

	
}
