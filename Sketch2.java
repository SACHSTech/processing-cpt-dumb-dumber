import processing.core.PApplet;

public class Sketch2 extends PApplet {

  double x = -100;
  double y;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 1000);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    ellipse((float)x + 100,(float)y + 200,20,20);
    x++;

    y = (-1 * (x*x) / 10) +1000;
    

  }
  
  // define other methods down here.
}
