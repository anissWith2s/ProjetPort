package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

import constantes.ConstantesPorts;
/**
 * LectureTranscription est la classe qui permet de lire un fichier et de le transcrire à notre guise 
 * @author Thevakumaran Krishnath et Hassan Aniss 
 */
public class LectureTranscription  implements ConstantesPorts, Serializable{

	
 private Date date;
 private static MareeJour marrejour;
 
 /** 
  * lectureTranscriptionPayante lit un fichier payant et le transcrit en une information maree et l'ajoute dans une collection mareeUnJour
  * @param nomFichier qui est le fichier payant à lire 
  * @return le fichier lu 
  */ 
public static Object lectureTranscriptionPayante (String nomFichier){
	ObjectInputStream flux ;
	Object objetLu = null;
	marrejour = new MareeJour();
	
	// Ouverture du fichier en mode lecture
	try {
		
		BufferedReader buffer = new BufferedReader (
				new InputStreamReader (
						new FileInputStream (
						new File ("PORT_17" + File.separator + nomFichier))));
		
		String ligne = " "; 
		
		//compteur qui va compter le nombre de ligne 
		int compteur = 0;	
		
		//stocker les 4 marrées d'un jour 
        Maree [] marre = new Maree[4];
        
		
		while((ligne = buffer.readLine())!= null) {
			compteur ++;
			
			//stock les informations d'une ligne 
			String donnee [] = new String [PORT_INFO.length];
			if (compteur > 4){
				
				StringTokenizer decoup = new StringTokenizer(ligne,"\t");
				
				//stock chaque string découpé dans le tableau avec l'indice associé 
				for (int i = 0; i < PORT_INFO.length; i++){
					 donnee [i]  = decoup.nextToken();
					 
				}
				
				//création des 4 marrées avec les informations stocké pour une ligne 
				marre[0] = new Maree(donnee [1],donnee [2],donnee [3]);
				marre[1] = new Maree(donnee [4],donnee [5],donnee [6]);
				marre[2] = new Maree(donnee [7],donnee [8]);
				marre[3] = new Maree(donnee [9],donnee [10]);
				
				//ajoute les 4 marées et la date en string 
				for (int j = 0; j<= 3; j ++) {
					marrejour.ajoutMareePayant(donnee[0], marre[j]);
				}
	
			}
	    }		
		//System.out.println(marrejour);
	}
	
	
	
	catch (IOException parException) {
		System.err.println ("Erreur lecture du fichier " + parException.toString ());
		System.exit (1);
	}
	return objetLu ;
	
}

/** 
 * lectureTranscriptionGratuit lit un fichier gratuit et le transcrit en une information maree et l'ajoute dans une collection mareeUnJour
 * @param nomFichier qui est le fichier gratuit à lire 
 * @return le fichier lu 
 */ 
public static Object lectureTranscriptionGratuit (String nomFichier, EventPort parEvt){
	
	ObjectInputStream flux ;
	Object objetLu = null;
	marrejour = new MareeJour();

	// Ouverture du fichier en mode lecture
	try {
		
		BufferedReader buffer = new BufferedReader (
				new InputStreamReader (
						new FileInputStream (
						new File ("PORT_17_gratuit" + File.separator + nomFichier))));
		
		String ligne = " "; 
		
		//compte les lignes 
		int compteur = 0;
		
        Maree marre ;
        
        //compte les lignes pour effectuer des calcules d'heure 
        int compteur_heure =0;
		
		while((ligne = buffer.readLine())!= null) {
			compteur ++;
			
			//stock les données d'une ligne 
			String donnee [] = new String [3];
			
			
			if (compteur > 13){
				
				//va prendre une informations pour chaque heure 
				if (compteur_heure%59 == 0) {
					StringTokenizer decoup = new StringTokenizer(ligne," \t ; ");
					
					//stock chaque string découpé dans le tableau avec l'indice associé 
					for (int i = 0; i < 3; i++){
						 donnee [i]  = decoup.nextToken();
						 
					}
					
					//crée le marée et l'ajoute dans la collection avec la date 
					marre = new Maree(donnee [1],donnee [2]);	
					marrejour.ajoutMarreGratuit(donnee[0],marre,parEvt);
				}

			}
			compteur_heure ++;
	    }	

	}
	
	
	
	catch (IOException parException) {
		System.err.println ("Erreur lecture du fichier " + parException.toString ());
		System.exit (1);
	}
	return objetLu ;
	
}

/**
 * méthode getMareeUnJourTranscrit de la classe LecturTranscription 
 * Accede à la collection MareeUnJour qui est transcrit 
 * @return collection MareeUnJour
 */
public MareeJour getMareeUnJourTranscrit () {
	return marrejour;
}



}

/*

*/