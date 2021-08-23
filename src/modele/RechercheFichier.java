package modele;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import constantes.ConstantesPorts;

/**
 * RechercheFichier est la classe qui cherche le fichier selon la date et le port 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */

public class RechercheFichier implements ConstantesPorts,Serializable{
	
	
	LectureTranscription lecture;
	
	//repertoire du fichier payant
	File folder = new File("PORT_17");
	File[] listOfFiles = folder.listFiles();
	
	//repertoire du fichier gratuit
	File folder_gratuit = new File("PORT_17_gratuit");
	File[] listOfFiles_gratuit = folder_gratuit.listFiles();
	
	
	 /**
	   * Méthode recherche de la classe RechercheFichier
	   * Permet de chercher le fichier associé à la date et le port 
	   * @param parEvt objet de la classe EventPort
	   */
	
	public void recherche (EventPort parEvt) {
		
		
		//stock le nom des fichiers payants 
		ArrayList<String> fichier = new ArrayList<String>();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	fichier.add(file.getName());
		    }
		}
		
		//classe dans l'ordre alphabétique 
		Collections.sort(fichier);
		
		//stock le nom des fichiers gratuits 
        ArrayList<String> fichier_gratuit = new ArrayList<String>();
		
		for (File file : listOfFiles_gratuit) {
		    if (file.isFile()) {
		    	fichier_gratuit.add(file.getName());
		    }
		}
		
		Collections.sort(fichier_gratuit);
		
		
		for (int i = 0; i< NOM_PORT.length; i++ ) {
			
			//si le mois et entre 6 et 9 
			if (parEvt.getDate().getMois() > 5 && parEvt.getDate().getMois() < 10) {
				
				//récupere le nom du fichier selon le port et le mois (version payante)
				if (parEvt.getPort() == NOM_PORT[i]) {
							
					if (parEvt.getDate().getMois() == 6) 
						i = i;

					if (parEvt.getDate().getMois() == 7) 
						i = i+17;

					if (parEvt.getDate().getMois() == 8) 
						i = i+(17*2);

					if (parEvt.getDate().getMois() == 9) 
						i = i+(17*3);
							
					lecture.lectureTranscriptionPayante(fichier.get(i));	
     
						
				}

		   }

			//si le mois et entre 1 et 5 
			if ((parEvt.getDate().getMois() > 0 && parEvt.getDate().getMois() < 6)) {
				//récupere le nom du fichier selon le port et le mois (version gratuite)
				if (parEvt.getPort() == NOM_PORT[i]) {
					
					for (int j = 0; j< NOM_PORT_GRATUIT.length; j++ ) {
						if (NOM_PORT_GRATUIT[j]==NOM_PORT[i]) {
					        lecture.lectureTranscriptionGratuit(fichier_gratuit.get(j),parEvt);
						}
						
					}
					
					
				}
				
				
			}
			
		}
	
	}
				
			
}
		
		
		
		



