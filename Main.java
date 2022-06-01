import processing.core.PApplet;

/**
 * Main class to execute sketch
 * @author 
 *
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch"};
	// Sketch mySketch = new Sketch();  //comment this out to run the other sketch files
	// Sketch1 mySketch = new Sketch1();  // uncomment this to run this sketch file
<<<<<<< HEAD
	 Sketch2 mySketch = new Sketch2();  // uncomment this to run this sketch file
=======
	// Sketch2 mySketch = new Sketch2();  // uncomment this to run this sketch file
	   Sketch3 mySketch = new Sketch3();  // uncomment this to run this sketch file
>>>>>>> 0b346881d9697ffd38e0393995adf2f3037b2929
	  
	  PApplet.runSketch(processingArgs, mySketch);
  }
  
}
