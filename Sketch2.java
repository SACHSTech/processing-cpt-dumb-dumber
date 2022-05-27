import processing.core.PApplet;

public class Sketch2 extends PApplet {
  float x;
  float y = -2;
  float m;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
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
	  background(210, 255, 173);
    x+= 0.1;
    m = (float)(0 - 0.1) * (y * y) + 30;
    y+= 0.1;

    ellipse(x,m + 400,20,20);
  }
  
  // define other methods down here.
}
