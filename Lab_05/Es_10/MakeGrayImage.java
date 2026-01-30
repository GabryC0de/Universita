import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MakeGrayImage{
	public static int averageValue(int r, int g, int b){
		return(r + g + b) / 3;		
	}
}