import processing.core.PApplet;
import processing.core.PImage;

/**
 * code to play the greatets game of all time (CS bowl), refer to readme file for information about game 
 * @author: Jenusan Y & David U
 */

public class Sketch extends PApplet {

  // initializing position variables and values 
  int intQbPosX = 1000;
  int intQbPosY = 400;
  double BallPosX = 950;
  double BallPosY= 450;
  int BallTargetx = 990;
  int BallTargety = 450;

  // initializing arrays
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
	
  // initializing booleans 
  boolean ShowBall;
  boolean screenpass;
  boolean snapball;
  boolean PickedOff;
  boolean upPressed;
  boolean downPressed;
  boolean leftPressed;
  boolean rightPressed;
  boolean pastLine;
  boolean ballthrown;
  boolean firstScreen;
  boolean CantThrow;
  boolean HailMary;
  boolean BurnerRoute;
  boolean touchdown;
  boolean IntroDone;
  boolean Catchmade;
  boolean TackleMade;
  boolean cut;
  boolean RouteSelected;
  boolean slant;

  // initializing images 
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
  PImage HailMarryline;
  PImage CutRouteline;
  PImage BurnerRouteline;
  PImage SlantRouteline;

  
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
    
    // loading images 
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

    SlantRouteline = loadImage("SlantRoute.png");
    SlantRouteline.resize(475, 275);

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

    //Load Hail Marry Lines
    HailMarryline = loadImage("HailMarryLine.png");
    HailMarryline.resize(475, 275);

    //Load Cut Route lines
    CutRouteline = loadImage("CutRoute .png");
    CutRouteline.resize(475, 274);

    //Load Burner Route lines
    BurnerRouteline = loadImage("BurnerRoute.png");
    BurnerRouteline.resize(475, 275);

    // set true boolean values
    ShowBall = true;
    screenpass = false;
    firstScreen = true;
    firstScreen = true;

    // set all balues of ballcaught array to be false
    for (int i = 0; i < 4; i++){
      blnBallCaught[i] = false;
    }
  }

  public void draw() {

    // if first screen is still supposed to be shown it will be 
    if (firstScreen){
      image(CsBowl, 0, 0);
    }


    if(!firstScreen){

    if (!IntroDone){
      // displays intro 
      image(Intro, 0, 0);
    }

    if (IntroDone){
      // runs method for users to select routes
    RouteSelect();

if (screenpass){
      // runs method which inserts mechanics of game 
      GameMech();

      // runs each route method based on if the route was selected 
      HailMary();
      Burner();
      cut();
      slant();
  }else{
    // runs pregame method if ball is not snapped yet 
    Pregame();
  }
  }
}
}


// movement method for when keys are released
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

// movement method for when keys are pressed
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

// game mechanic method which is universal for any route 
public void GameMech(){
  // replaces image of backround each run for animation 
  image(Field, 0,0);

  // if space is pressed the ball will be snapped 
  if(keyPressed){
    if(key == ' '){
      snapball = true;
    }
  }

  // if ball is snapped the ball will move and disapear once it hits the quarterbacks hand 
      if (snapball){
        if (BallPosX != 990){
          ShowBall = true;
        }else{
          ShowBall = false;
        }
    
        // draws line of scrimmage 
        noStroke();
        fill(255,102,0);
        rect(949,135,3,635);
    
        // movement functions for quarterback 
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
    
        // restricts the quarterback from  moving off the screen 
        if (intQbPosX >= 1375){
          intQbPosX = 1375;
        }
    
        // draws qb on screen 
        if (!pastLine){
        image(Player, intQbPosX, intQbPosY);
        }
    
        // sets movement for football to move towards target 
        if (BallPosX < BallTargetx){
          BallPosX+= 10;
        }
        if (BallPosX > BallTargetx){
          BallPosX-= 10;
        }
        if (BallPosY < BallTargety){
          BallPosY += 10;
        }
        if (BallPosY > BallTargety){
          BallPosY -= 10;
        }
    
        // if mouse is clicked while game is running target locatoin will move to wherver mouse is clicked, and ball will move to target 
        if (!pastLine && !CantThrow){
        if(!ballthrown){
          if (mousePressed){
            BallPosX = intQbPosX;
            BallPosY = intQbPosY;
        
            BallTargetx = mouseX;
            BallTargety = mouseY;
        
            ShowBall = true;
            ballthrown = true;    
            }
          }
        }

        // prints qb without ball in hands for when ball is thrown 
            for(int i = 0; i < 4; i ++){
              image(RunNoBall, intWRposx[i], intWRposY[i]);
            }


            // if qb passes line of scrimmage they cant thrown anymore and can only scramble 
            if (intQbPosX <= 900){
              pastLine = true;
              image(RunYesBall, intQbPosX, intQbPosY );
              CantThrow = true;
            }

            // if qb comes back from line of scrimmage animation reverts 
            if (intQbPosX >= 900){
              pastLine = false;
            }

            // processes image of the lineman facing eachother 
            image(OLineGo, 880, 330);

            
          // processes images of defence based on conditions
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
            

            // processes movement of defence based on position of wide receivers 
            // defecne movement is AI so it works no matter what the route is 
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
            // if qb is past line of scrimm defence runs towards qb 
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

              // checks if position of defence is the same as position of offensive player with ball, and sets boolean tackle to true if so
              for(int i = 0; i < 4; i++){
                if (intDefposx[i] <= intQbPosX + 5 && intDefposx[i] >= intQbPosX -5 && intDefposY[i] <= intQbPosY + 5 && intDefposY[i] >= intQbPosY -5){
                  TackleMade = true;
                }
              }

              if (intQbPosX >= 880 && intQbPosX <= 980 && intQbPosY >= 330 && intQbPosY <= 520){
                TackleMade = true;
              }
              
            }

            // checks where the ball landed and where all the WRs are, and if any positoons are equal, the catch will be made,
            // and the players animation will change to be holding a ball 
            if (ballthrown){
              if(!blnBallCaught[0] && !blnBallCaught[1] && !blnBallCaught[2] && !blnBallCaught[3]){
              image(NoBall, intQbPosX, intQbPosY);
              if(BallTargetx >= BallPosX && BallTargetx <= BallPosX + 10){
                for(int i = 0; i < 4; i++){
                  if (BallPosX >= intWRposx[i] && BallPosX <= intWRposx[i] + 75){
                    if(BallPosY >= intWRposY[i] && BallPosY <= intWRposY[i] + 75){
                      blnBallCaught[i] = true;
                      Catchmade = true;
                  }
                }else{
                  // checks if the ball landed on the floor or in a defenders hand and processes fail images based on what happened 
                  if (BallPosX >= intDefposx[i] && BallPosX <= intDefposx[i] + 75 && BallPosY >= intDefposY[i] && BallPosY <= intDefposY[i] + 75){
                    PickedOff = true;                  
                  }else{
                    NotCatch[i] = true;
                  }
                }
              }
              }
            }
          }

          // if none of the players have the ball in their hands the incomplete procedure will play
          if (NotCatch[0] && NotCatch[1] && NotCatch[2] && NotCatch[3]){
            for(int i = 0; i < 4; i++){
            intWRposx[i] = -100;
            }
                  ShowBall = false;
                  delay(750);
                  image(Incomplete, 0, 0);

                  for (int i = 0; i < 4; i++){
                    intDefposx[i] = -100;
                    intWRposx[i] = -100;
                  }
          }

          // if the defence has the ball, the picked off procedure will play 
          if (PickedOff){
            for (int i = 0; i < 4; i++){
              intWRposx[i] = 0;
            } 
                  ShowBall = false;
                  delay(750);
                  image(Pick, 0, 0);
          }
          

          // if the ball is caught then the player that caught it will change animations to be holding a ball 
            for(int x = 0; x < 4; x++){
              if (blnBallCaught[x]){
                ShowBall = false;
                BallPosX = intWRposx[x];
                BallPosY = intWRposY[x];
                BallTargetx = intWRposx[x];
                BallTargety = intWRposY[x];
                image(RunYesBall, intWRposx[x], intWRposY[x]);
                image(NoBall, intQbPosX, intQbPosY);
              }
            }

        // if ball is thrown ball will be processed onto screen 
        if (ShowBall){
          fill(102,52,0);
          ellipse((float)BallPosX,(float)BallPosY, 25,15);
        }
    
      }else{
        // control screen will be displayed if ball is not yet snapped 
        image(controls, 0, 0);
      }

      // if ball is caught, and player gets into endzone, touchdown will be made 
      for(int i = 0; i < 4; i ++){
      if (intWRposx[i] < 250 && BallPosX < 250 && Catchmade){
        touchdown = true;
      }
    }

    // if touchdown is made, touchdown screen will be displayed 
    if (touchdown){
      delay(750);
      image(TouchdownScreen, 0,0);
    }

    // if qb walks off safe zone, out of bounds screen will be shown 
      if(!ballthrown){
      if (intQbPosY <= 120 || intQbPosY >= 700){
        intQbPosY = 100000;
        image(out, 0, 0);
      }
    }

    // if player is holding ball and gets too close to a defender, a tackle will be made 
    for(int i = 0; i < 4; i++){
      if (blnBallCaught[i] && intDefposx[i] <= intWRposx[i] + 5 && intDefposx[i] >= intWRposx[i] -5 && intDefposY[i] <= intWRposY[i] + 5 && intDefposY[i] >= intWRposY[i] -5){
        TackleMade = true;
      }
    }

    // if tackle is made, tackle screen will be shown 
    if (TackleMade){
      delay(750);
      image(Tackle, 0, 0);
    }

}

  /**
   * method to run the burner route to partner with the game mechanics to run the game
   */
  public void Burner(){
    // processes specific movement based on location on screen for route
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

   /**
   * method to run the cut route to partner with the game mechanics to run the game
   */
  public void cut(){
    if(snapball && cut){
          // processes specific movement based on location on screen for route
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

 /**
   * method to run the hail mary route to partner with the game mechanics to run the game
   */
  public void HailMary(){
    if (snapball && HailMary){
          // processes specific movement based on location on screen for route
      for(int i = 0; i<4; i++){
      intWRposx[i]-= 2;
      }
  }
  }

   /**
   * method to run the slant route to partner with the game mechanics to run the game
   */
  public void slant(){
    if (snapball && slant){
          // processes specific movement based on location on screen for route
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
        intWRposx[0]-= 3;
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

   /**
   * method to show pregame screen where users see each route run, and select which route they want to run 
   */
  public void Pregame(){
    image(SelectBackround, 0, 0);
    image(FieldPrev, 150, 100);
    image(FieldPrev, 150, 475);
    image(FieldPrev, 750, 100);
    image(FieldPrev, 750, 475);

    image(HailMarryline, 150, 100);
    image(CutRouteline, 150, 475);
    image(BurnerRouteline, 750, 100);
    image(SlantRouteline, 750, 475);

    
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
      if(intWRposXHailMary[i] <= 150){
         intWRposXHailMary[i] = 460;
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
      intWRposYBurner[3] = 290;
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

    if(intWRposXCut[0] <= 382){
      intWRposYCut[0]++;
      intWRposXCut[0]--;
    }

    if(intWRposXCut[1] <= 432 && intWRposYCut[1] <= 625){
      intWRposYCut[1]++;
    }

    if(intWRposXCut[2] <= 432 && intWRposYCut[2] >= 565){
      intWRposYCut[2]--;
    }
    
    if(intWRposXCut[0] <= 150){
      intWRposYCut[0] = 515;
      intWRposYCut[1] = 565;
      intWRposYCut[2] = 625;
      intWRposYCut[3] = 675;
      intWRposXCut[0] = 465;
      intWRposXCut[1] = 465;
      intWRposXCut[2] = 465;
      intWRposXCut[3] = 465;
      }


    //Slant Route text
    if(mouseX > 700 && mouseY > 450){
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

  /**
   * method to set rules for the game to run based on which route is selected on the pregame screen 
   */
  public void RouteSelect(){
    // filters based on which route was selected 
    if (!RouteSelected){
    if (!firstScreen){
    if (!HailMary && !BurnerRoute){
      if(mousePressed){
        // if mouse is pressed within hail mary box, then procedures will be set 
        if(mouseX < 580 && mouseX > 95 && mouseY < 380 && mouseY > 100){
            HailMary = true;
            screenpass = true;
            RouteSelected = true;
          }
          // if mouse is pressed within burner box, then procedures will be set 
          if(mouseX > 748 && mouseX < 1235 && mouseY < 380 && mouseY > 100){
            BurnerRoute = true;
            screenpass = true;
            RouteSelected = true;
          }
           // if mouse is pressed within cut box, then procedures will be set 
          if(mouseX < 580 && mouseX > 95 && mouseY > 465 && mouseY < 750){
            cut = true;
            screenpass = true;
            RouteSelected = true;
          }
           // if mouse is pressed within slant box, then procedures will be set 
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

/**
 * mouse clicked method that activates every time mouse is clicked, and is used for the user to get passed the intro screens
 */
public void mouseClicked(){

   if (!firstScreen && !IntroDone){
     IntroDone = true;
  }
   if (firstScreen){ 
    firstScreen = false;
   }
  }
}