import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Flowers{
	public static void main (String[] args){
      
		//Creo oggetto SimpleImage con l'immagine di input
		SimpleImage img = new SimpleImage("flowers.jpg");

		// ricordarsi che le immagini sono griglie di pixel
		// l'asse x e' la larghezza
		// l'asse y l'altezza
		// (0,0) e' l'angolo in alto a sinistra


		//per ogni pixel in posizione x,y
		for(int x = 0; x < img.width(); x++){

			for(int y = 0; y < img.height(); y++){
				
				Color c = img.get(x, y);
											
				int avg = MakeGrayImage.averageValue(c.getRed(), c.getGreen(), c.getBlue());
				
				// Converti in scala di Grigi
				Color gray = new Color(avg, avg, avg);
				
				img.set(x, y, gray);
			}
		}
		
		//Saving the modified image
		img.save("flowersGray.jpg");
		System.out.println("Done...");		
	}
}