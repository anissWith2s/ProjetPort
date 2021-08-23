package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;
import constantes.ConstantesCouleursFontes;
import constantes.ConstantesPorts;
import modele.Date;
import modele.EventPort;
import modele.ExceptionDate;

/**
 * PanelFormulaire est un JPanel qui affiche un formulaire o� l'on choisit le port 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class PanelFormulaire extends JPanel implements ConstantesCouleursFontes, ConstantesPorts{
	
	Date date ;
	JLabel labelDate ;
	JButton boutonAjout = new JButton ("Recherche");
	JLabel recherche = new JLabel ("Choisissez un port : ");
	
	JComboBox <String> nom_port = new JComboBox <String> (NOM_PORT);
	
	/**
	 * Constructeur de la classe PanelFormulaire qui ne prend rien en param�tre 
	 */	
	public PanelFormulaire () {
		
		date = new Date (); 
		labelDate = new JLabel (date.toString(), JLabel.LEFT);
		boutonAjout.setActionCommand("Recherche");
		
		setBackground(WHITE);
		setLayout (new GridBagLayout ());	
		GridBagConstraints contraintes = new GridBagConstraints ();
	  	contraintes.insets = new Insets (6,6,6,6); 
	  	contraintes.anchor = GridBagConstraints.WEST;
	  	
	  	 // labelDate
	  	contraintes.gridy=0; contraintes.gridwidth = 4;	contraintes.gridx=0;
		this.add(labelDate, contraintes);
		
		// boutonAjout
		contraintes.gridwidth = 1;	contraintes.gridx=4;
		this.add(boutonAjout, contraintes);
		
		contraintes.gridy++; 
		contraintes.gridx=0;
		this.add (recherche,contraintes);
		
		contraintes.gridy++; 
		contraintes.gridx=0;
		this.add (nom_port,contraintes);
		
		labelDate.setFont(FONT_14);
		recherche.setFont(FONT_14);
		
		boutonAjout.setFont (FONT_14); 
		boutonAjout.setBackground(BLEU);
		boutonAjout.setForeground(WHITE);
		
		nom_port.setBackground(WHITE);

	}
	
	/**
	 * m�thode getType de la classe PanelFormulaire  
	 * Accede au nom du port dans le JComboBox
	 * @return un String qui est le nom du port 
	 */
	public String getType () {
		return String.valueOf(nom_port.getSelectedItem());
	}

	/**
	 * m�thode getEvenement de la classe PanelFormulaire  
	 * Accede � l'�v�nement du port 
	 * @return un �v�nement du port 
	 * @throws ExceptionDate 
	 */
	public EventPort getEvenement () throws ExceptionDate{
		return new EventPort(date,getType());
	}

	
	/**
	 * m�thode getDate de la classe PanelFormulaire  
	 * Accede � la date 
	 * @return la date 
	 */
	public Date getDate() {
		
		return date;
	}
	
	/** 
	* m�thode enrigistreEcouteur de la classe PanelFormulaire
	* La methode permet de mettre le boutonAjout � l'ecoute du controleur 
	* @param parControleur Objet de la classe Controleur
	*/ 
	
	public void enrigistreEcouteur (Controleur parControleur) {
		boutonAjout.addActionListener(parControleur);
	}
	
	/**
	 * m�thode setDate de la classe PanelFormulaire  
	 * modifie la date avec le param�tre 
	 * @param pardate
	 */
	
	public void setDate (Date parDate) {
		date = parDate;
		labelDate.setText(date.toString());
	}

}
