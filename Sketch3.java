import processing.core.PApplet;
import processing.core.PImage;

public class Sketch3 extends PApplet {

    PImage Field;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1400, 900);

    Field = loadImage("Field.png");
    Field.resize(475, 300);
  }
    

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
    image(Field, 100, 100);
  }
    

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    

    

  }
  
  // define other methods down here.
}
