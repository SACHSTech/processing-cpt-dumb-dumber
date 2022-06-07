import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

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

    //Hail Mary route WR starting positions
    int[] intWRposYHailMary = {140,190,250,300};
    int[] intWRposXHailMary = {465,465,465,465};

    //Burner route WR starting positions
    int[] intWRposYBurner = {140, 190, 250, 300};
    int[] intWRposXBurner = {1065, 1065, 1065, 1065};

    //Cut route WR starting positions 
    int[] intWRposXCut = {465, 465, 465, 465};
    int[] intWRposYCut = {515, 565, 625, 675};

    //Slant route WR strating positons
    int[] intWRposXSlant = {1065, 1065, 1065, 1065};
    int[] intWRposYSlant = {515, 565, 625, 675};

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
  boolean CantThrow = false;
  boolean HailMary = false;
  boolean BurnerRoute = false;
  boolean touchdown = false;
  boolean IntroDone = false;
  boolean Catchmade = false;
  boolean TackleMade = false;
  boolean cut;
  boolean RouteSelected;
  boolean slant;

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
  PImage trans;
  PImage controls;
  PImage Pick;
  PImage Incomplete;
  PImage out;
  PImage Tackle;
	PImage defturn;
  PImage FieldPrev;
  PImage PlayerPrev;
  PImage SelectBackround;

  
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1400, 900);

  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    
    Field = loadImage("Field.png");
    Field.resize(1400,900);

    controls = loadImage("controls.png");
    controls.resize(1400,900);

    SelectBackround = loadImage("SelectBackround.png");
    SelectBackround.resize(1400,900);

    Incomplete = loadImage("Incomplete.png");
    Incomplete.resize(1400,900);

    Tackle = loadImage("Tackle.png");
    Tackle.resize(1400,900);

    Pick = loadImage("Pick.png");
    Pick.resize(1400,900);

    out = loadImage("out.png");
    out.resize(1400,900);

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

    defence = loadImage("defence.png");
    defence.resize(90,90);

    defturn = loadImage("defturn.png");
    defturn.resize(75,85);

    OLine = loadImage("OLine.png");
    OLine.resize(100,225);

    OLineGo = loadImage("OLineGo.png");
    OLineGo.resize(100,225);

    FieldPrev = loadImage("FieldPrev.png");
    FieldPrev.resize(475, 275);

    PlayerPrev = loadImage("PlayerPrev.png");
    PlayerPrev.resize(30,30);

    
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
  }

  public void draw() {

    if (firstScreen){
      image(CsBowl, 0, 0);
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
      Burner();
      cut();
      slant();
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
      if (snapball){
        if (circx != 990){
          ShowBall = true;
        }else{
          ShowBall = false;
        }
    
        noStroke();
        fill(255,102,0);
        rect(949,135,3,635);
    
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
    
        if (intQbPosX >= 1375){
          intQbPosX = 1375;
        }
    
        fill(255);
        if (!pastLine){
        image(Player, intQbPosX, intQbPosY);
        }
    
        if (circx < BallTargetx){
          circx+= 10;
        }
        if (circx > BallTargetx){
          circx-= 10;
        }
        if (circy < BallTargety){
          circy += 10;
        }
        if (circy > BallTargety){
          circy -= 10;
        }
    
        if (!pastLine && !CantThrow){
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
              CantThrow = true;
            }
            if (intQbPosX >= 900){
              pastLine = false;

            }

            image(OLineGo, 880, 330);

            
          for (int i = 0; i < 4; i++){
            if(intDefposx[i] < intWRposx[i]){
              image(defence,intDefposx[i],intDefposY[i]);
            }else{
              if (!pastLine && !CantThrow){
                image(defturn, intDefposx[i], intDefposY[i]);
              }else{
                image(defence,intDefposx[i],intDefposY[i]);
              }
            }
            

            if (snapball && !pastLine && !CantThrow){
              if (intDefposY[i] > intWRposY[i]){
                intDefposY[i] -= 4;
              }
              if (intDefposY[i] < intWRposY[i]){
               intDefposY[i] += 4;
             }
             if (intDefposx[i] < intWRposx[i]){
                intDefposx[i]-= random(0,2);
              }
              if (intDefposx[i] > intWRposx[i]){
                intDefposx[i]-= random(0,2);
              }
    }
  }
            if(CantThrow){
              for(int i = 0; i < 4; i++){
                if (intDefposY[i] > intQbPosY){
                  intDefposY[i] -= random(0,3);
                }
                if (intDefposY[i] < intQbPosY){
                 intDefposY[i] += random(0,3);
               }
               if (intDefposx[i] < intQbPosX){
                  intDefposx[i]+= random(0,3);
                }
                if (intDefposx[i] > intQbPosX){
                  intDefposx[i]-= random(0,3);
                }
              }

              for(int i = 0; i < 4; i++){
                if (intDefposx[i] <= intQbPosX + 5 && intDefposx[i] >= intQbPosX -5 && intDefposY[i] <= intQbPosY + 5 && intDefposY[i] >= intQbPosY -5){
                  TackleMade = true;
                }
              }

              if (intQbPosX >= 880 && intQbPosX <= 980 && intQbPosY >= 330 && intQbPosY <= 520){
                TackleMade = true;
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
                      Catchmade = true;
                  }
                }else{
                  if (circx >= intDefposx[i] && circx <= intDefposx[i] + 75 && circy >= intDefposY[i] && circy <= intDefposY[i] + 75){
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
            intWRposx[i] = -100;
            }
                  ShowBall = false;
                  delay(750);
                  image(Incomplete, 0, 0);
          }

          if (PickedOff){
            for (int i = 0; i < 4; i++){
              intWRposx[i] = 0;
            } 
                  ShowBall = false;
                  delay(750);
                  image(Pick, 0, 0);
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
    
        if (ShowBall){
          fill(153,102,0);
          ellipse(circx,circy, 25,15);
        }
    
      }else{
        image(controls, 0, 0);
      }
      for(int i = 0; i < 4; i ++){
      if (intWRposx[i] < 250 && circx < 250 && Catchmade){
        touchdown = true;
      }
    }



    if (touchdown){
      delay(750);
      image(TouchdownScreen, 0,0);
    }

      if(!ballthrown){
      if (intQbPosY <= 120 || intQbPosY >= 700){
        intQbPosY = 100000;
        image(out, 0, 0);
      }
    }

    for(int i = 0; i < 4; i++){
      if (blnBallCaught[i] && intDefposx[i] <= intWRposx[i] + 5 && intDefposx[i] >= intWRposx[i] -5 && intDefposY[i] <= intWRposY[i] + 5 && intDefposY[i] >= intWRposY[i] -5){
        TackleMade = true;
      }
    }

    if (TackleMade){
      delay(750);
      image(Tackle, 0, 0);
    }

}

  public void Burner(){
    if (snapball && BurnerRoute){
    intWRposx[0]-= 2;
    intWRposx[1]-= 2;
    intWRposx[2]-= 2;
    intWRposx[3]-= 2;

    if(intWRposx[0] < 600){
      intWRposY[0]++;
      intWRposx[0]--;
    }

    if (intWRposY[3] < 700 && intWRposY[3] > 400){
      intWRposY[3]-= 2;
    }
    }
  }

  public void cut(){
    if(snapball && cut){
      if (intWRposx[1] >= 750){
        intWRposx[1]-= 2;
        intWRposx[2]-= 2;
      }
      intWRposx[3]-= 2;

      if (intWRposx[1] <= 750 && intWRposx[1] >= 600){
        intWRposY[1]+= 3;
        intWRposx[1]-=2 ;
    }
    if (intWRposx[2] <= 750 && intWRposx[2] >= 600){
      intWRposY[2]-= 3;
      intWRposx[2]-= 2;
  }
  if (intWRposx[1] <= 600){
    intWRposx[2]-= 2;
    intWRposx[1]-= 2;
  }
  if (intWRposx[0] >= 675){
    intWRposx[0]-= 2;
  }
  if (intWRposx[0] <= 675){
    intWRposx[0]-= 2;
    intWRposY[0]++;
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

  public void slant(){
    if (snapball && slant){
      if (intWRposx[3] >= 430){
        intWRposx[3] -= 2;
        intWRposY[3] -= 2;
      }
      if (intWRposx[3] <= 430){
        intWRposx[3] -= 2;
      }
      if (intWRposx[0] >= 675){
        intWRposx[0]-= 2;
      }
      if (intWRposx[0] <= 675){
        intWRposx[0]-= 2;
        intWRposY[0]++;
      }
      if(intWRposx[1] >= 750){
        intWRposx[1]-= 2;
        intWRposx[2]-= 2;
        intWRposY[1]+= 2;
        intWRposY[2]+= 1;
      }
      if(intWRposx[1] <= 750){
        intWRposx[1]-= 2;
        intWRposx[2]-= 2;
      }
    }
  }

  public void Pregame(){
    image(SelectBackround, 0, 0);
    image(FieldPrev, 150, 100);
    image(FieldPrev, 150, 475);
    image(FieldPrev, 750, 100);
    image(FieldPrev, 750, 475);

    
    //Hail Mary Text
    if(mouseX < 625 && mouseX > 150 && mouseY < 380 && mouseY > 100){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Hail Mary", 225, 85);
    

    //Hail mary route preview
    for(int i = 0; i < 4; i++){
      image(PlayerPrev, intWRposXHailMary[i], intWRposYHailMary[i]);
    }

    for(int i = 0; i < 4; i++){
      intWRposXHailMary[i]-= 1;
    }

    for(int i = 0; i < 4; i ++){
      if(intWRposXHailMary[i] <= 100){
         intWRposXHailMary[i] = 415;
      }
    }

    //Burnen route text
    if(mouseX > 748 && mouseX < 1235 && mouseY < 380 && mouseY > 100){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Burner route", 785, 85);



    //Burner route preview
    for(int i = 0; i < 4; i++){
      image(PlayerPrev, intWRposXBurner[i], intWRposYBurner[i]);
    }
  
    intWRposXBurner[0]-= 1;
    intWRposXBurner[1]-= 1;
    intWRposXBurner[2]-= 1;
    intWRposXBurner[3]-= 1;
    

    if(intWRposXBurner[0] < 950){
      intWRposYBurner[0]+= 1;
      intWRposXBurner[0]--;
    }

    if (intWRposYBurner[3] <= 300 && intWRposYBurner[3] > 220){
      intWRposYBurner[3]-= 1;
    }

   if(intWRposXBurner[0] <= 750){
      intWRposYBurner[0] = 140;
      intWRposYBurner[3] = 250;
      intWRposXBurner[0] = 1065;
      intWRposXBurner[1] = 1065;
      intWRposXBurner[2] = 1065;
      intWRposXBurner[3] = 1065;
      }

    //Cut route text
    if(mouseX < 625 && mouseX > 150 && mouseY > 465 && mouseY < 750){
      fill(0, 240, 0);
    }
    else{
      fill(255); 
    }
    text("Cut Route", 225, 465);

    //Cut route preview 
    for(int i = 0; i < 4; i++){
      image(PlayerPrev, intWRposXCut[i], intWRposYCut[i]);
    }

    intWRposXCut[0]-= 1;
    intWRposXCut[1]-= 1;
    intWRposXCut[2]-= 1;
    intWRposXCut[3]-= 1;

    if(intWRposXCut[0] <= 332){
      intWRposYCut[0]++;
      intWRposXCut[0]--;
    }

    if(intWRposXCut[1] <= 362 && intWRposYCut[1] <= 625){
      intWRposYCut[1]++;
    }

    if(intWRposXCut[2] <= 362 && intWRposYCut[2] >= 565){
      intWRposYCut[2]--;
    }
    
    if(intWRposXCut[0] <= 100){
      intWRposYCut[0] = 515;
      intWRposYCut[1] = 565;
      intWRposYCut[2] = 625;
      intWRposYCut[3] = 675;
      intWRposXCut[0] = 415;
      intWRposXCut[1] = 415;
      intWRposXCut[2] = 415;
      intWRposXCut[3] = 415;
      }


    //Slant Route text
    if(mouseX > 748 && mouseX < 1235 && mouseY > 465 && mouseY < 750){
      fill(0, 240, 0);
    }
    else{
      fill(255); 
    }
    text("Slant Route", 800, 465);


    //Slant route preview 
    for(int i = 0; i < 4; i++){
      image(PlayerPrev, intWRposXSlant[i], intWRposYSlant[i]);
    }

    intWRposXSlant[0]-= 1;
    intWRposXSlant[1]-= 1;
    intWRposXSlant[2]-= 1;
    intWRposXSlant[3]-= 1;

    if (intWRposYSlant[3] <= 675 && intWRposYSlant[3] >= 515){
      intWRposYSlant[3]-= 1;
    }

    if(intWRposXSlant[1] >= 565 && intWRposYSlant[1] <= 625){
      intWRposYSlant[1]++;
    }

    if(intWRposXSlant[2] >= 625 && intWRposYSlant[2] <= 675){
      intWRposYSlant[2]++;
    }

    if(intWRposXSlant[0] < 950){
      intWRposYSlant[0]++;
      intWRposXSlant[0]--;
    }

    if(intWRposXSlant[0] <= 750){
      intWRposXSlant[0] = 1065;
      intWRposYSlant[0] = 515;
      intWRposYSlant[1] = 565;
      intWRposXSlant[1] = 1065;
      intWRposYSlant[2] = 625;
      intWRposXSlant[2] = 1065;
      intWRposXSlant[3] = 1065;
      intWRposYSlant[3] = 675;

    }

    fill(255);
    text("Select a route", 450,850);
      
  }

  public void RouteSelect(){
    if (!RouteSelected){
    if (!firstScreen){
    if (!HailMary && !BurnerRoute){
      if(mousePressed){
        if(mouseX < 580 && mouseX > 95 && mouseY < 380 && mouseY > 100){
            HailMary = true;
            screenpass = true;
            RouteSelected = true;
          }
          if(mouseX > 748 && mouseX < 1235 && mouseY < 380 && mouseY > 100){
            BurnerRoute = true;
            screenpass = true;
            RouteSelected = true;
          }
          if(mouseX < 580 && mouseX > 95 && mouseY > 465 && mouseY < 750){
            cut = true;
            screenpass = true;
            RouteSelected = true;
          }
          if(mouseX > 748 && mouseX < 1235 && mouseY > 465 && mouseY < 750){
            slant = true;
            screenpass = true;
            RouteSelected = true;
          }
      }
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