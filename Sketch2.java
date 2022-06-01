import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  int intQbPosX;
  int intQbPosY;


  int circx = 950;
  int circy = 450;
  int BallTargetx = 990;
  int BallTargety = 450;

  int[] intWRposY = {150,250,570,670};
  int[] intWRposx = {950,950,950,950};

  int[] intDefposY = {150,250,560,660};
  int[] intDefposx = {850,850,850,850};

  boolean[] blnBallCaught = new boolean[4];
  boolean[] NotCatch = new boolean[4];
	
  boolean ShowBall;
  boolean screenpass;
  boolean snapball;
  boolean PickedOff;
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean pastLine = false;
  boolean ballthrown = false;
  boolean firstScreen = true;

  boolean HailMary = false;
  boolean cross = false;
  boolean touchdown = false;
  boolean IntroDone = false;

	
  PImage Field;
  PImage Player;
  PImage NoBall;
  PImage RunYesBall;
  PImage RunNoBall;
  PImage TouchdownScreen;
  PImage crossroute;
  PImage burner;
  PImage CsBowl;
  PImage Intro;
  PImage defence;
  PImage OLine;
  PImage OLineGo;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1400, 900);

    Field = loadImage("Field.png");
    Field.resize(1400,900);

    TouchdownScreen = loadImage("TouchdownScreen.png");
    TouchdownScreen.resize(1400,900);

    CsBowl = loadImage("CsBowl.png");
    CsBowl.resize(1400,900);

    Intro = loadImage("Intro.png");
    Intro.resize(1400,900);

    Player = loadImage("Player.png");
    Player.resize(75,75);

    NoBall = loadImage("NoBall.png");
    NoBall.resize(75,75);

    RunYesBall = loadImage("RunYesBall.png");
    RunYesBall.resize(75,75);

    RunNoBall = loadImage("RunNoBall.png");
    RunNoBall.resize(75,75);

    crossroute = loadImage("cross.png");
    crossroute.resize(1000,300);

    burner = loadImage("burner.png");
    burner.resize(1000,300);

    defence = loadImage("defence.png");
    defence.resize(90,90);

    defence = loadImage("defence.png");
    defence.resize(90,90);

    OLine = loadImage("OLine.png");
    OLine.resize(100,225);

    OLineGo = loadImage("OLineGo.png");
    OLineGo.resize(100,225);

    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
<<<<<<< HEAD
    image(Field, 0, 0);
    intQbPosX = 1000;
    intQbPosY = 400;

    ShowBall = true;
    screenpass = false;
    snapball = false;
    firstScreen = true;

    for (int i = 0; i < 4; i++){
      blnBallCaught[i] = false;
    }
    textSize(150);
=======
    background(0);
>>>>>>> 0b346881d9697ffd38e0393995adf2f3037b2929
  }


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
<<<<<<< HEAD

  public void draw() {

    if (firstScreen){
      image(CsBowl, 0, 0);
=======
  public void draw() {
    
    if (mousePressed){
      draw = true;
      m = mouseX;
      r = (width - mouseY);
>>>>>>> 0b346881d9697ffd38e0393995adf2f3037b2929
    }

    if(!firstScreen){

    if (!IntroDone){
      image(Intro, 0, 0);
    }

    if (IntroDone){

    RouteSelect();

if (screenpass){
      GameMech();
      HailMary();
      cross();
  }else{
    Pregame();
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
              image(RunNoBall, intWRposx[i], intWRposY[i]);
            }


            if (intQbPosX <= 900){
              pastLine = true;
              image(RunYesBall, intQbPosX, intQbPosY );
            }

            image(OLineGo, 880, 330);

            
          for (int i = 0; i < 4; i++){
            image(defence,intDefposx[i],intDefposY[i]);
            if (snapball){
              if (intDefposY[i] > intWRposY[i]){
                intDefposY[i] -= random(0,2);
              }
              if (intDefposY[i] < intWRposY[i]){
               intDefposY[i] += random(0,2);
             }
             if (intDefposx[i] < intWRposx[i]){
                intDefposx[i]-= random(0,2);
              }
              if (intDefposx[i] > intWRposx[i]){
                intDefposx[i]-= random(0,2);
              }
    }
  }
            
            if (ballthrown){
              if(!blnBallCaught[0] && !blnBallCaught[1] && !blnBallCaught[2] && !blnBallCaught[3]){
              image(NoBall, intQbPosX, intQbPosY);
              if(BallTargetx >= circx && BallTargetx <= circx + 10){
                for(int i = 0; i < 4; i++){
                  if (circx >= intWRposx[i] && circx <= intWRposx[i] + 75){
                    if(circy >= intWRposY[i] && circy <= intWRposY[i] + 75){
                      blnBallCaught[i] = true;
                  }
                }else{
                  if (circx >= intDefposx[i] + 10 && circx <= intDefposx[i] + 40 && circy >= intDefposY[i] + 10 && circy <= intDefposY[i] + 40){
                    PickedOff = true;                  
                  }else{
                    NotCatch[i] = true;
                  }
                }
              }
              }
            }
          }

          if (NotCatch[0] && NotCatch[1] && NotCatch[2] && NotCatch[3]){
            for(int i = 0; i < 4; i++){
            intWRposx[i] = 0;
            }
                  ShowBall = false;
                  fill(255);
                  rect(0,0,1400,900);
                  fill(0);
                  text("ball \n dropped", 100 , 400);
          }

          if (PickedOff){
            for (int i = 0; i < 4; i++){
              intWRposx[i] = 0;
            }
                  ShowBall = false;
                  fill(255);
                  rect(0,0,1400,900);
                  fill(0);
                  text("Picked Off", 100 , 400);
          }
          

            for(int x = 0; x < 4; x++){
              if (blnBallCaught[x]){
                ShowBall = false;
                circx = intWRposx[x];
                circy = intWRposY[x];
                BallTargetx = intWRposx[x];
                BallTargety = intWRposY[x];
                image(RunYesBall, intWRposx[x], intWRposY[x]);
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
          image(RunNoBall, intWRposx[i], intWRposY[i]);
          image(defence, intDefposx[i], intDefposY[i]);
        }
        image(OLine, 880, 330);
      }
      for(int i = 0; i < 4; i ++){
      if (intWRposx[i] < 250 && circx < 250 && (!NotCatch[0] || !NotCatch[1] || !NotCatch[2] || !NotCatch[3])){
        touchdown = true;
      }
    }



    if (touchdown){
      image(TouchdownScreen, 0,0);
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
    intWRposx[0]-= 2;
    intWRposx[1]-= 2;
    intWRposx[2]-= 2;
    intWRposx[3]-= 2;

    if(intWRposx[0] < 600){
      intWRposY[0]+= 2;
      intWRposx[0]--;
    }

    if (intWRposY[3] < 700 && intWRposY[3] > 400){
      intWRposY[3]-= 2;
    }
    }
  }

  public void HailMary(){
    if (snapball && HailMary){
      for(int i = 0; i<4; i++){
      intWRposx[i]-= 2;
      }
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
    image(burner, 200, 115);
    image(crossroute, 200, 515);
  }

  public void RouteSelect(){
    if (!firstScreen){
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


public void mouseClicked(){

   if (!firstScreen && !IntroDone){
     IntroDone = true;
  }

   if (firstScreen){ 
    firstScreen = false;
   }
  }
}