package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import constantes.ConstantesCouleursFontes;
/**
 * PanelPresentation est la classe de présentation lors de l'ouverture de l'application
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class PanelPresentation extends JPanel  implements ConstantesCouleursFontes{
	
	CardLayout gestionnaireDeCartes = new CardLayout (0,0); 
	JPanel panelCentre = new JPanel();                                     
	JPanel panelNord = new JPanel (); 
	JPanel panelSud = new JPanel();  
	final File REPERTOIRE_IMAGES = new File ("image") ;                     
	final File[] ACCES_IMAGES = REPERTOIRE_IMAGES.listFiles() ;
	JLabel image ;
    JLabel titre = new JLabel (" Un horaire des marées ");
    
    JLabel nomPrenom = new JLabel (" Thevakumaran Krishnath, Hassan Aniss ");
    
    /**
	* PanelPresentation constructeur 
	* ne prend rien en paramètre

	*/
	public PanelPresentation () {
		
		this.setLayout(new BorderLayout(20,20));
		
		
		titre.setFont(new Font ("Sitka Display", Font.BOLD,17));
		panelNord.setBackground(BLEU);
		add(panelNord,BorderLayout.NORTH);
		titre.setForeground(WHITE);
		panelNord.add(titre);
		
		nomPrenom.setFont(new Font ("Sitka Display", Font.BOLD,15));
		add(panelSud,BorderLayout.SOUTH);
		panelSud.add(nomPrenom);

		//ajout de l'image dans le panel Centre 
		panelCentre.setLayout(gestionnaireDeCartes);
		add(panelCentre,BorderLayout.CENTER);
		                                   
		image = new JLabel (new ImageIcon(ACCES_IMAGES[0].toString())) ;    
		panelCentre.add(image,"image");                            
			
		
		
		
	}
	
}

