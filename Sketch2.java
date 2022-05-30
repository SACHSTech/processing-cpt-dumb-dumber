import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PVector;
import java.util.ArrayList;
import java.math.MathContext;

public class Sketch2 extends PApplet {

  double x = 0;
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
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    y = 100 * Math.sin(0.01*x);
    x-= Math.PI / 2;
    
    ellipse((float)x + 900,(float)y + 600,20,20);
    

  }
  
  // define other methods down here.
}
