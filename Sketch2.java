import processing.core.PApplet;

public class Sketch2 extends PApplet {
	
  int[] intWRposY = {50,100,150,200};

  int intWRposx = 200;

	
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

    for(int i = 0; i < 4; i++){
      fill(255);
      ellipse(intWRposx, intWRposY[i], 50, 50);
    }

  }
  
  // define other methods down here.
}
