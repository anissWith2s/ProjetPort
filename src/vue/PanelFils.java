package vue;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.LectureEcriture;
import modele.MareeJour;
import modele.RechercheFichier;

/**
 * PanelFils est la classe permet de crée un JPanel contenant PanelCalendrier, PanelFormulaire, PanelAffichage et PanelPresentation
 * gérer par un cardLayout
 * 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 * @see panelCalendrier
 * @see panelFormulaire
 * @see panelAffichage
 * @see panelPresentation
 */

public class PanelFils extends JPanel implements ConstantesCouleursFontes, ActionListener{

	 PanelCalendrier panelCalendrier = new PanelCalendrier();
	 PanelFormulaire panelFormulaire = new PanelFormulaire();
	 PanelPresentation panelPresentation = new PanelPresentation ();
     RechercheFichier recherche ; 
     MareeJour mareejour ;
     File fichier = new File ("fichier"+ File.separator + "maree.ser");
     CardLayout gestionnaire = new CardLayout(5,5);
     
     /**
      * Constructeur de la classe PanelFils qui ne prend rien en paramètre 
      */
	 public PanelFils ()  {
		 
		recherche = new RechercheFichier(); 
		setLayout(gestionnaire);
		
		if (fichier.length() == 0){
			//System.out.println("vide");
			mareejour = new MareeJour();
			

		}
		
		else {
			mareejour = (MareeJour)LectureEcriture.lecture(fichier);
		}
		
		
		PanelAffichage panelAffichage = new PanelAffichage (mareejour);
		
		this.add(panelCalendrier,ConstantesCalendrier.MENU[0]);		
		this.add (panelFormulaire,ConstantesCalendrier.MENU[1]);
		this.add (panelAffichage,ConstantesCalendrier.MENU[2]);
		this.add (panelPresentation,"presentation");
		
		gestionnaire.show(this, "presentation");
		
        setBackground(WHITE);

		new Controleur (panelCalendrier,panelFormulaire, recherche, mareejour,panelAffichage,fichier);
	}

	/** 
   * méthode actionPerfomed de la classe PanelFils
   * La methode ce déclanche lorsque qu'un evenement ce passe, lors du clique d'un menu le panel conçerné s'affiche
   * @param parEvt Objet de la classe ActionEvent
   */ 
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ConstantesCalendrier.MENU[0])) {
			gestionnaire.show(this, ConstantesCalendrier.MENU[0]);
		}
		
		if(e.getActionCommand().equals(ConstantesCalendrier.MENU[1])) {
			gestionnaire.show(this, ConstantesCalendrier.MENU[1]);
		}
		
		if(e.getActionCommand().equals(ConstantesCalendrier.MENU[2])) {
			gestionnaire.show(this, ConstantesCalendrier.MENU[2]);
		}
		
		if(e.getActionCommand().equals(ConstantesCalendrier.MENU[3])) {
			if(JOptionPane.showConfirmDialog(this,"voulez vous quiiter ?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(1);
		          
			}
	
		}
	}
	

}
