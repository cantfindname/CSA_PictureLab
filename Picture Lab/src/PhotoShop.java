import java.awt.Color;
import java.util.Scanner;

  
public class PhotoShop
{
  /** Method to show the original picture.**/
	public static void showOriginal(String picture)
	  {
	    Picture p = new Picture(picture);
	    p.explore();
	   
	  }
	
  /** Method to negate picture */
  public static void negate(String picture)
  {
    Picture p = new Picture(picture);
    p.negate();
    p.explore();
  }
  
  
  public static void borderPicture(String a){
	  Picture p=new Picture(a);
	  p.borderPicture(10, new Color(5,200,50));
	  p.explore();
  }
  
  public static void zeroBlue(String pic) {
	  Picture p = new Picture(pic);
	  p.zeroBlue();
	  p.explore();
  }
  
  public static void grayScale(String pic) {
	  Picture p = new Picture(pic);
	  p.grayScale();
	  p.explore();
  }
  
  public static void mirrorVertical(String pic) {
	  Picture p = new Picture(pic);
	  p.mirrorVertical();
	  p.explore();
  }
  
  public static void mirrorHorizontal(String pic) {
	  Picture p = new Picture(pic);
	  p.mirrorHorizontal();
	  p.explore();
  }
  
//Make sure that you test all of the methods you wrote in the    //Picture class.  You'll need to write add more methods to this //class and to add code to the main. 
  
  public static void main(String[] args)
  {
	String picture="cat.jpg";//use whatever picture you want
	
	Scanner kb = new Scanner(System.in);
	System.out.println("choose a number 1-6: \n1) ZeroBlue\n2)Negate\n3)GrayScale\n4)Border\n5)mirrorVertical\n6)mirrorHorizontal");
	int response = kb.nextInt();
	
	showOriginal(picture);
	
	if (response==1) zeroBlue(picture);
	else if (response==2) negate(picture);
	else if (response==3) grayScale(picture);
	else if (response==4) borderPicture(picture);
	else if (response==5) mirrorVertical(picture);
	else if (response==6) mirrorHorizontal(picture);
   
  }
}