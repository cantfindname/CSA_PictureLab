

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 
/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * 
 * 
 * Before you begin working on this assignment, look at the Pixel class and SimplePicture class.
 * 
 * Your assignment is to complete (and test) the last 6 methods.
 * 
 * To get the most of this project, use your own pictures.  Have fun with
 * the methods you write and see what cool photshop pictures you can make.
 * 
 */


  
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   * 
   * Why does the class need to explicitly write the no argument (default) constructor?
   * 
   * This class has more than one constructor.  As soon as one constructor is written,
   * the no argument constructor isn't included in the class for free.
   */
  public Picture ()
  {
    /* REMEMBER YOU GET A FREE line of invisible code if the parent
     * constructor has a no agrument constuctor.
     * 
     * super();     IMPLICITYLY CALLED
     */
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  /**A picture is made up of a 2-dimensional array of pixels.  
   * SimplePicture has a method that will return the 2D-array of Pixels.  A Picture can use that method because Picture is
   * a subclass of SimplePicture.
   * 
   * Save the 2-D array of Pixels in a variable.  Then, go through each row and column of the array and set the blue value of the Pixel there
   * to 0.  Look in the Pixel class to see how to set the blue value to 0.
   */
  public void zeroBlue()
  {
	  Pixel[][] a = getPixels2D();
	for (int r=0;r<a.length;r++) {
		for (int c=0;c<a[r].length;c++) {
			a[r][c].setBlue(0);
		}
	}
	
  }
  
  /**Method to negate all the pixels in a picture.  To negate a pixel, 
    * set the red value to 255 minus the current red value, the green value to 255
    * minus the current green value, and the blue value to 255 minus the current value.
    *
 */ 
    public void negate(){	
    	Pixel[][] a = getPixels2D();
    	for (int r=0; r<a.length;r++) {
    		for (int c=0;c<a[r].length;c++) {
    			a[r][c].setBlue(255-a[r][c].getBlue());
    			a[r][c].setGreen(255-a[r][c].getGreen());
    			a[r][c].setRed(255-a[r][c].getRed());
    		}
    	}
    }
    
    
    /**Method to turn the picture into shades of gray.  Set the red, green, and blue values
      * to the average of the current red, green, and blue values.  
      */
    public void grayScale(){
    	int sum=0;
    	Pixel[][] a = getPixels2D();
    	for (int r=0;r<a.length;r++) {
    		for (int c=0; c<a[r].length;c++) {
    			sum = a[r][c].getBlue()+a[r][c].getGreen()+a[r][c].getGreen();
    			a[r][c].setBlue(sum/3);
    			a[r][c].setGreen(sum/3);
    			a[r][c].setRed(sum/3);
    		}
    	}
    }
    
    
 
  /** Method that mirrors the picture around a vertical mirror in the center of the picture
    *from left to right.   For example, if the original image is &@++, the new image will be &@@&*/
  public void mirrorVertical() {
    
	  Pixel[][] a= getPixels2D();
	  for (int r=0;r<a.length ;r++) {
		  for (int c=0; c<(a[r].length)/2; c++) {
			  a[r][a[r].length-c-1].setColor(a[r][c].getColor());
		  }
	  }
  }
  /** Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from top to bottom*/
  public void mirrorHorizontal()
  {
    Pixel[][] a = getPixels2D();
    for (int r=0; r<a.length/2; r++) {
    	for (int c=0; c<a[r].length; c++) {
    		a[a.length-1-r][c].setColor(a[r][c].getColor());
    	}
    }
  }
  
  /** Method that makes a border of w rows and columns around
   * the picture.  The border covers up parts of the picture. 
    * The color of the border is Color c.
    */
  
  public void borderPicture(int w, Color color){
	  Pixel[][] a = getPixels2D();
	  
	 for (int r=0; r<w ; r++) {
		 for (int c=0; c<a[r].length;c++) {
			 a[r][c].setColor(color);
			 a[a.length-r-1][c].setColor(color);
		 }
	 }
	  for (int r=0; r<a.length; r++) {
		  for (int c=0; c<w; c++) {
			  a[r][c].setColor(color);
			  a[r][a[r].length-1-c].setColor(color);
		  }
	  }
  }
 
} 
// this } is the end of class Picture, put all new methods before this

