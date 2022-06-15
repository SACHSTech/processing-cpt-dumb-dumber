import processing.core.PApplet;
import processing.core.PImage;

/**
 * code to play the greatets game of all time (CS bowl), refer to readme file for information about game 
 * @author: Jenusan Y & David U
 */
public class Sketch3 extends PApplet {

    // Initializing images 
    PImage field;
    PImage player;
    PImage hailMarryline;
    PImage cutRouteline;
    PImage burnerRouteline;
    PImage slantRouteline;
    PImage imgMenuScreen;
    PImage intro;
    PImage backGround;

    // Initializing booleans 
    Boolean introDone = false;
    Boolean menuScreen = true;
    Boolean secondIntroDone = false;
  
    // Hail Mary route WR starting positions
    int[] intWRposYHailMary = {140,190,250,300};
    int[] intWRposXHailMary = {465,465,465,465};

    // Burner route WR starting positions
    int[] intWRposYBurner = {140, 190, 250, 300};
    int[] intWRposXBurner = {1065, 1065, 1065, 1065};

    // Cut route WR starting positions 
    int[] intWRposXCut = {465, 465, 465, 465};
    int[] intWRposYCut = {515, 565, 625, 675};

    // Slant route WR strating positons
    int[] intWRposXSlant = {1065, 1065, 1065, 1065};
    int[] intWRposYSlant = {515, 565, 625, 675};

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
    background(0);

    // Load Staring Screen
    imgMenuScreen = loadImage("CsBowl.png");
    imgMenuScreen.resize(1400, 900);

    // load Intro Screen
    intro = loadImage("Intro.png");
    intro.resize(1400, 900);

    // Load Image of Football Field
    field = loadImage("Field.png");
    field.resize(475, 275);

    // Load Image of Player
    player = loadImage("Player.png");
    player.resize(30,30);

    // Load Hail Marry Lines
    hailMarryline = loadImage("HailMarryLine.png");
    hailMarryline.resize(475, 275);

    // Load Cut Route lines
    cutRouteline = loadImage("CutRoute .png");
    cutRouteline.resize(475, 274);

    // Load Burner Route lines
    burnerRouteline = loadImage("BurnerRoute.png");
    burnerRouteline.resize(475, 275);

    // Load Slant Route lines
    slantRouteline = loadImage("SlantRoute.png");
    slantRouteline.resize(475, 275);

    // Load pregame backround
    backGround = loadImage("SelectBackround.png");
    backGround.resize(1400, 900);

  }
    
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    if(menuScreen){
      image(imgMenuScreen, 0, 0);
    }

    if(introDone){
      image(intro, 0, 0);
    }

    if(keyPressed && introDone){
      secondIntroDone = true;
    }

    // Runs pregame method if second intro screen is done 
    if(secondIntroDone){
      preGame();
    }

  }
  /**
   * Method that runs pregame route options
   */
  public void preGame(){

    image(backGround, 0, 0);

    // Pregame Feilds
    image(field, 150, 100);
    image(field, 150, 475);
    image(field, 750, 100);
    image(field, 750, 475);
 
    // Route lines
    image(hailMarryline, 150, 100);
    image(cutRouteline, 150, 475);
    image(burnerRouteline, 750, 100);
    image(slantRouteline, 750, 475);

    
    // Hail Mary Text
    if(mouseX < 700 && mouseY < 450){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Hail Mary", 225, 85);
    

    // Hail mary route preview
    for(int i = 0; i < 4; i++){
      image(player, intWRposXHailMary[i], intWRposYHailMary[i]);
    }

    for(int i = 0; i < 4; i++){
      intWRposXHailMary[i]-= 1;
    }

    for(int i = 0; i < 4; i ++){
      if(intWRposXHailMary[i] <= 150){
         intWRposXHailMary[i] = 465;
      }
    }

    // Burnen route text
    if(mouseX > 700 && mouseY < 450){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Burner route", 785, 85);

    // Burner route preview
    for(int i = 0; i < 4; i++){
      image(player, intWRposXBurner[i], intWRposYBurner[i]);
    }
  
    for(int i = 0; i < 4; i++){
      intWRposXBurner[i]-=1;
    }
    
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

    // Cut route text
    if(mouseX < 700 && mouseY > 450){
      fill(0, 240, 0);
    }
    else{
      fill(255); 
    }
    text("Cut Route", 225, 465);

    // Cut route preview 
    for(int i = 0; i < 4; i++){
      image(player, intWRposXCut[i], intWRposYCut[i]);
    }
    
    for(int i = 0; i < 4; i++){
      intWRposXCut[i]-=1;
    }

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

    // Slant Route text
    if(mouseX > 700 && mouseY > 450){
      fill(0, 240, 0);
    }
    else{
      fill(255); 
    }
    text("Slant Route", 800, 465);
 
    // Slant route preview 
    for(int i = 0; i < 4; i++){
      image(player, intWRposXSlant[i], intWRposYSlant[i]);
    }

     for(int i = 0; i < 4; i++){
      intWRposXSlant[i]-=1;
    }

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
      
  }

  /**
   * Method that performs intructions for when the muouse is clicked
   */
  public void mouseClicked(){

    if(menuScreen){
      menuScreen = false;
    }

    if(!menuScreen){
      introDone = true;
    }
    
  }
  
}
