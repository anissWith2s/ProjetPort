package vue;
import javax.swing.*;
import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import modele.Date;
import java.awt.Insets;

/**
 * FenetreMere est la classe permet lancer toute les vues
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class FenetreMere extends JFrame implements ConstantesCouleursFontes { 
	
	/**
	 * Constructeur de la classe FenetreMere
	 * @param parTitre titre de la fenetre
	 */
	
	@SuppressWarnings("deprecation")
	public FenetreMere (String parTitre) {
	    super (parTitre); 
	    PanelFils contentPane  = new PanelFils ();
		
		//La barre de menu
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		for (String nomItem : ConstantesCalendrier.MENU){
			JMenuItem menuItem = new JMenuItem(nomItem,nomItem.charAt(0));
			menuItem.addActionListener(contentPane);
			menuItem.setActionCommand(nomItem);
			menuBar.add(menuItem);
		}
		
		
		setContentPane (contentPane);
				
		setLocation(80,50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
		setVisible(true);
		setSize(900,500);
		
		
	} 
	
	/**
	 * fonction main FenetreMere	
	 * @param args
	 */
	public static void main (String  [] args) {
	 	new FenetreMere ("Horaire des marées ");
	
		
	}  


} 