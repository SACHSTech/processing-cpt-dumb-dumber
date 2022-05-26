import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

  int intQbPosX;
  int intQbPosY;

  int counter;


  int circx = 950;
  int circy = 450;
  int BallTargetx = 990;
  int BallTargety = 450;

  int[] intWRposY = {200,280,620,700};

  int intWRposx = 950;
	
  boolean ShowBall;
  boolean screenpass;
  boolean snapball;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean pastLine = false;
  boolean ballthrown = false;

  boolean HailMary = false;
  boolean cross = false;

	
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
    // Makes user press shift to continue to game screen 
    if(keyPressed){
      if(keyCode == SHIFT){
        screenpass = true;
      }
    }


    // if game screen code is passed main code will run
    if (screenpass){

      // if space bar is pressed, ball will be snapped from line of scrimmage 
      if(keyPressed){
        if(key == ' '){
          snapball = true;
        }
      }





      Game();

      for(int i = 0; i < 4; i++){
        fill(255);
        ellipse(intWRposx, intWRposY[i], 50, 50);
      }

      if (snapball && HailMary){
          intWRposx-= 3;
      }

      if (snapball && cross){
        for(int i = 0; i<4; i++){
          if (i <= 1){
            intWRposY[i]+= 2;
          }else{
          intWRposY[i]-= 2;
          }
      }
      intWRposx-= 3;
    }

      





  }else{
    // preshift screen 
    fill(255);
    rect(0,0,1400,900);
    fill(0);
    rect (200,100,1000,300);
    fill(0);
    rect (200,500,1000,300);

    if (mousePressed){
      if (mouseY > 100 && mouseY < 400){
        HailMary = true;
      }else if (mouseY > 500 && mouseY < 800){
        cross = true;
      }
    }
  }
}



public void keyReleased(){
  if (key == 'w') {
    upPressed = false;
  }
  else if (key == 's') {
    downPressed = false;
  }
  else if (key == 'a') {
    leftPressed = false;
  }
  else if (key == 'd') {
    rightPressed = false;
  }
}

public void keyPressed(){
  if (key == 'w') {
    upPressed = true;
  }
  else if (key == 's') {
    downPressed = true;
  }
  else if (key == 'a') {
    leftPressed = true;
  }
  else if (key == 'd') {
    rightPressed = true;
  }
}



public void Game(){
  
      // game commences 
      if (snapball){
        image(Field, 0, 0);
    
        // once the ball hits the qbs hands the ball disappears
        if (circx != 990){
          ShowBall = true;
        }else{
          ShowBall = false;
        }
    
        // draws line of scrimm
        noStroke();
        fill(255,102,0);
        rect(949,135,3,635);
    
        // movement functions for qb 
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
    
        // does not let qb leave right side of screen 
        if (intQbPosX >= 1375){
          intQbPosX = 1375;
        }
    
        // prints qb on screen 
        fill(255);
        ellipse(intQbPosX, intQbPosY, 50,50);
    
        // pritns end screen if qb goes out of bounds 
        if (intQbPosY <= 120 || intQbPosY >= 770){
          rect(0, 0, 1400, 900);
        }
    
        if (circx < BallTargetx){
          circx+= 8;
        }
        if (circx > BallTargetx){
          circx-= 8;
        }
        if (circy < BallTargety){
          circy += 8;
        }
        if (circy > BallTargety){
          circy -= 8;
        }
    
        // if mouse is pressed footballs target location will change and move towards it 
          if (mousePressed){
            circx = intQbPosX;
            circy = intQbPosY;
        
            BallTargetx = mouseX;
            BallTargety = mouseY;
        
            ShowBall = true;
            ballthrown = true;
            }
    
    
        // if ball is supposed to be shown it will be printed onto screen 
        if (ShowBall){
          fill(153,102,0);
          ellipse(circx,circy, 25,15);
        }
        for(int i = 0; i < 4; i ++){
          fill(255);
          ellipse(intWRposx, (float)(intWRposY[i] * 200), 50, 50);
        }
    
      }else{
        //before snap basic non usable screen 
        noStroke();
        image(Field, 0, 0);
        fill(255);
        ellipse(intQbPosX, intQbPosY, 50,50);
        fill(153,102,0);
        ellipse(circx,circy, 25,15);
        for(int i = 0; i < 4; i ++){
          fill(255);
          ellipse(intWRposx, (float)(intWRposY[i] * 200), 50, 50);
        }
      }
  }
}
