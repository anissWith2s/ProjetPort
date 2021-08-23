package vue;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel ;

import controleur.Controleur;
import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import modele.Date;

import javax.swing.JLabel ;
import javax.swing.JButton ;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * PanelCalendrier est un JPanel qui affiche un calendrier où l'on choisit la date 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class PanelCalendrier  extends JPanel implements ActionListener, ConstantesCalendrier, ConstantesCouleursFontes{
	
	JPanel panelCentre = new JPanel ( ) ; 
	CardLayout gestCard = new CardLayout(10,10);
	JButton [] tabBoutons = new JButton [INTITULES_BOUTONS.length];
	 
	JLabel labelIntituleMois;
	 	
	int indiceMois = 0;  
		 
	PanelMois [] panelsMois ;	
  
 /**
 * Constructeur de la classe PanelCalendrier qui ne prend rien en paramètre 
 */
  public  PanelCalendrier  ()	{
	 
	Date today = new Date();		 
	
	this.setLayout (new BorderLayout (9,9)) ;  
	JPanel panelSud = new JPanel ( ) ; 
	this.add (panelSud, BorderLayout.SOUTH); 
		
	// panelCentre
	this.add (panelCentre, BorderLayout.CENTER);
	panelsMois = new PanelMois [MOIS.length];

	panelCentre.setLayout (gestCard);
	for (int indiceMois = 0 ; indiceMois< ConstantesCalendrier.MOIS.length; indiceMois++)		{
		
		panelsMois [indiceMois] = new PanelMois (indiceMois+1);	 
	 	panelCentre.add (panelsMois[indiceMois], MOIS[indiceMois]);
		
	}
	// placer le mois courant en haut de la pile
	gestCard.show (panelCentre, MOIS[today.getMois()-1]);
	indiceMois = today.getMois()-1;
	
	// panelSud  
	labelIntituleMois = new JLabel (MOIS[today.getMois()-1], JLabel.LEFT);
	labelIntituleMois.setPreferredSize(new Dimension (80,20)); 		 
	labelIntituleMois.setFont (new Font ("Verdana",Font.PLAIN,14));	 
	panelSud.add (labelIntituleMois);  
	
	panelSud.setLayout (new FlowLayout ( FlowLayout.CENTER, 4,4));	
	for (int i = 0 ; i< INTITULES_BOUTONS.length ; i++)		{
		tabBoutons[i] = new JButton (INTITULES_BOUTONS[i]);  
		tabBoutons[i].setActionCommand(INTITULES_BOUTONS[i]) ; 
		tabBoutons[i].addActionListener (this);  
		tabBoutons[i].setFont (new Font ("Verdana",Font.PLAIN,16));
		tabBoutons[i].setBackground(ConstantesCouleursFontes.WHITE);
		tabBoutons[i].setBorderPainted(false);
		panelSud.add (tabBoutons[i]) ;
	}
	
	panelCentre.setBackground( WHITE);
	panelSud.setBackground ( WHITE);	
	setBackground (WHITE);
	setPreferredSize(new Dimension (500,320));
	
} // PanelFils  ()

	/** 
   * méthode actionPerfomed de la classe PanelCalendrier
   * La methode ce déclanche lorsque qu'un evenement ce passe, lors du clique d'un bouton pour passer au mois suivant, précèdent...
   * @param parEvt Objet de la classe ActionEvent
   */ 
  public void actionPerformed (ActionEvent evt){ 
	// pour décoloriser le bouton sélectionné  
	JButton boutonSelectionne = panelsMois[indiceMois].getBoutonSelectionne();
	if (boutonSelectionne != null) {
		boutonSelectionne.setBackground(WHITE);
	}
	switch (evt.getActionCommand()) {
		case INTIT_PREMIER :{
			gestCard.first (panelCentre);
			indiceMois=0; 			
			break;
		}
		case INTIT_PRECEDENT :{
			gestCard.previous (panelCentre);		 
			if (indiceMois==0) {
				indiceMois=ConstantesCalendrier.MOIS.length-1;				
				}
			else {
				--indiceMois;
			}
			break ;
		}
		case INTIT_SUIVANT :{
			gestCard.next (panelCentre);		
			if (indiceMois==ConstantesCalendrier.MOIS.length-1) {
				indiceMois=0; 
				 
				}
			else {
				++indiceMois;
			}
			break;
		}
		case INTIT_DERNIER : {
			gestCard.last (panelCentre);
			indiceMois=ConstantesCalendrier.MOIS.length-1; 
			break;			
		}
		 
	}// switch
	labelIntituleMois.setText (ConstantesCalendrier.MOIS[indiceMois]);
	
  }// actionPerformed

/** 
* méthode enrigistreEcouteur de la classe PanelCalendrier
* La methode permet de mettre les panelsMois à l'ecoute du controleur 
* @param parControleur Objet de la classe Controleur
*/ 
public void enrigistreEcouteur(Controleur parcontroleur) {
	for (PanelMois panelMois : panelsMois){
		panelMois.enrigistreEcouteur(parcontroleur);
	}
	
}




} 
