import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  int intQbPosX;
  int intQbPosY;


  int circx = 950;
  int circy = 450;
  int x = 1000;
  int y = 450;
	
  boolean ShowBall;
  boolean screenpass;
  boolean snapball;

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

    ShowBall = true;
    screenpass = false;
    snapball = false;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    if(keyPressed){
      if(keyCode == SHIFT){
        screenpass = true;
      }
    }

    if (screenpass){

      if(keyPressed){
        if(key == ' '){
          snapball = true;
        }
      }


      if (snapball){
	  image(Field, 0, 0);

    if (circx == 1000){
      ShowBall = false;
    }

    noStroke();
    fill(255,102,0);
    rect(949,135,3,635);

    if (keyPressed){
      if (upPressed) {
        intQbPosY-= 2;
      }
      
      if (downPressed) {
        intQbPosY+= 2;
      }
      
      if (leftPressed) {
        intQbPosX-= 2;
      }
      
      if (rightPressed) {
        intQbPosX+= 2;
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

    if (circx < x){
      circx+= 5;
    }
    if (circx > x){
      circx-= 5;
    }
    if (circy < y){
      circy += 5;
    }
    if (circy > y){
      circy -= 5;
    }

    if (mousePressed){
      circx = intQbPosX;
    circy = intQbPosY;

    x = mouseX;
    y = mouseY;

    ShowBall = true;
    }


    if (ShowBall){
      fill(153,102,0);
      ellipse(circx,circy, 25,25);
    }
  }else{
    image(Field, 0, 0);
    fill(255);
    ellipse(intQbPosX, intQbPosY, 50,50);
    fill(153,102,0);
    ellipse(circx,circy, 25,25);
  }
}else{
  rect(0,0,1400,900);
}
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
