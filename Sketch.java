import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

  int intQbPosX;
  int intQbPosY;


  int circx = 950;
  int circy = 450;
  int BallTargetx = 990;
  int BallTargety = 450;

  int[] intWRposY = {160,260,560,660};

  int intWRposx = 950;

  boolean[] blnBallCaught = new boolean[4];
	
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
  PImage Player;
  PImage NoBall;
  PImage RunYesBall;
  PImage RunNoBall;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1400, 900);

    Field = loadImage("Field.png");
    Field.resize(1400,900);

    Player = loadImage("Player.png");
    Player.resize(75,75);

    NoBall = loadImage("NoBall.png");
    NoBall.resize(75,75);

    RunYesBall = loadImage("RunYesBall.png");
    RunYesBall.resize(75,75);

    RunNoBall = loadImage("RunNoBall.png");
    RunNoBall.resize(75,75);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    image(Field, 0, 0);
    intQbPosX = 951;
    intQbPosY = 400;

    ShowBall = true;
    screenpass = false;
    snapball = false;

    for (int i = 0; i < 4; i++){
      blnBallCaught[i] = false;
    }
  }


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    RouteSelect();

if (screenpass){
      GameMech();
      HailMary();
      cross();
  }else{
    Pregame();
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


public void GameMech(){
  image(Field, 0,0);
  if(keyPressed){
    if(key == ' '){
      snapball = true;
    }
  }
  
      // game commences 
      if (snapball){

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
            intQbPosY--;
          }
          if (downPressed) {
            intQbPosY++;
          }
          if (leftPressed) {
            intQbPosX--;
          }
          if (rightPressed) {
            intQbPosX++;
          }
        }
    
        // does not let qb leave right side of screen 
        if (intQbPosX >= 1375){
          intQbPosX = 1375;
        }
    
        // prints qb on screen 
        fill(255);
        if (!pastLine){
        image(Player, intQbPosX, intQbPosY);
        }

        // pritns end screen if qb goes out of bounds
    
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
        if (!pastLine){
        if(!ballthrown){
          if (mousePressed){
            circx = intQbPosX;
            circy = intQbPosY;
        
            BallTargetx = mouseX;
            BallTargety = mouseY;
        
            ShowBall = true;
            ballthrown = true;    
            }
          }
        }

            for(int i = 0; i < 4; i ++){
              image(RunNoBall, intWRposx, intWRposY[i]);
            }


            if (intQbPosX <= 900){
              pastLine = true;
              image(RunYesBall, intQbPosX, intQbPosY );
            }
            
            if (ballthrown){
              if(!blnBallCaught[0] && !blnBallCaught[1] && !blnBallCaught[2] && !blnBallCaught[3]){
              image(NoBall, intQbPosX, intQbPosY);
              if(BallTargetx >= circx && BallTargetx <= circx + 10){
                for(int i = 0; i < 4; i++){
                  if (circx >= intWRposx && circx <= intWRposx + 75){
                    if(circy >= intWRposY[i] && circy <= intWRposY[i] + 75){
                      blnBallCaught[i] = true;
                  }
                }else{
                  intWRposx = 0;
                  ShowBall = false;
                  fill(255);
                  rect(0,0,1400,900);
                  fill(0);
                  text("ball \n dropped", 100 , 400);
                }
              }
              }
            }
          }
          

            for(int x = 0; x < 4; x++){
              if (blnBallCaught[x]){
                ShowBall = false;
                circx = intWRposx;
                circy = intWRposY[x];
                BallTargetx = intWRposx;
                BallTargety = intWRposY[x];
                image(RunYesBall, intWRposx, intWRposY[x]);
                image(NoBall, intQbPosX, intQbPosY);
              }
            }
    
        // if ball is supposed to be shown it will be printed onto screen 
        if (ShowBall){
          fill(153,102,0);
          ellipse(circx,circy, 25,15);
        }
    
      }else{
        //before snap basic non usable screen 
        noStroke();
        image(Field, 0, 0);
        image(NoBall, intQbPosX, intQbPosY);
        fill(153,102,0);
        ellipse(circx,circy, 25,15);
        for(int i = 0; i < 4; i ++){
          fill(255);
          image(RunNoBall, intWRposx, intWRposY[i]);
        }
      }

      if (intWRposx < 250 && circx < 250){
        rect(0,0,1400,900);
        fill(0);
        text("touchdown \n screen", 100 , 400);
      }

      if(!ballthrown){
      if (intQbPosY <= 120 || intQbPosY >= 770){
        rect(0, 0, 1400, 900);
        fill(0);
        text("out of bounds \n screen", 100 , 400);
      }
    }
  }

  public void cross(){
    if (snapball && cross){
      for(int i = 0; i<4; i++){
        if (i <= 1){
          intWRposY[i]+= 1;
        }else{
        intWRposY[i]-= 1;
        }
    }
    intWRposx-= 2;
  }
  }

  public void HailMary(){
    if (snapball && HailMary){
      intWRposx-= 2;
  }
  }

  public void Pregame(){
    // preshift screen 
    fill(255);
    rect(0,0,1400,900);
    fill(0);
    rect (200,100,1000,300);
    fill(0);
    rect (200,500,1000,300);
    fill(255);
    textSize(150);
    text("Hail Mary", 350 , 300);
    text("Cross Route", 250 , 700); 
  }

  public void RouteSelect(){
    if (!HailMary && !cross){
      if(mousePressed){
          if (mouseY > 100 && mouseY < 400){
            HailMary = true;
          }else if (mouseY > 500 && mouseY < 800){
            cross = true;
          }
          screenpass = true;
      }
    }
  }
}