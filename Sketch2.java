import processing.core.PApplet;

public class Sketch2 extends PApplet {

  float x;
  float y = 400;
  float t;
  float m;
  float r;

  boolean draw = false;
  boolean done;

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
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    if (mousePressed){
      draw = true;
      m = mouseX;
      r = (width - mouseY);
    }

    if (draw){
    x+= m / 200;
    y-= r/25 - t;

    t+= r/5000;
    
      ellipse(x,y,10,10);
    }


  }
  
  // define other methods down here.
}
