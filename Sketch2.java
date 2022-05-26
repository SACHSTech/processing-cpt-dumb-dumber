import processing.core.PApplet;

public class Sketch2 extends PApplet {
	
  int circx = 0;
  int circy = 200;
  int x = circx;
  int y= circy;
	
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

    if (circx < x){
      circx++;
    }
    if (circx > x){
      circx--;
    }
    if (circy < y){
      circy ++;
    }
    if (circy > y){
      circy --;
    }


    ellipse(circx, circy, 25,25);
  }

  public void mousePressed(){

    x = mouseX;
    y = mouseY;
  }

  
  // define other methods down here.
}
