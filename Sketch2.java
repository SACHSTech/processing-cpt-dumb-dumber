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
  }


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

  public void draw() {
  }
}

