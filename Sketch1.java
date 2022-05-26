import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

  int intQbPosX;
  int intQbPosY;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

	
  PImage Field;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1400, 900);

    Field = loadImage("Field.png");
    Field.resize(1400,900);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    image(Field, 0, 0);
    intQbPosX = 1000;
    intQbPosY = 450;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  image(Field, 0, 0);

    noStroke();
    fill(255,102,0);
    rect(949,135,3,635);

    if (keyPressed){
      if (upPressed) {
        intQbPosY-= 5;
      }
      
      if (downPressed) {
        intQbPosY+= 5;
      }
      
      if (leftPressed) {
        intQbPosX-= 5;
      }
      
      if (rightPressed) {
        intQbPosX+= 5;
      }
    }

    if (intQbPosX >= 1375){
      intQbPosX = 1375;
    }

    fill(255);
    ellipse(intQbPosX, intQbPosY, 50,50);

    if (intQbPosY <= 120 || intQbPosY >= 770){
      rect(0, 0, 1400, 900);
    }
  
  // define other methods down here.
}
public void keyReleased(){
  if (keyCode == UP) {
    upPressed = false;
  }
  else if (keyCode == DOWN) {
    downPressed = false;
  }
  else if (keyCode == LEFT) {
    leftPressed = false;
  }
  else if (keyCode == RIGHT) {
    rightPressed = false;
  }
}

public void keyPressed(){
  if (keyCode == UP) {
    upPressed = true;
  }
  else if (keyCode == DOWN) {
    downPressed = true;
  }
  else if (keyCode == LEFT) {
    leftPressed = true;
  }
  else if (keyCode == RIGHT) {
    rightPressed = true;
  }
}
}
