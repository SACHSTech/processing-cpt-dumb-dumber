import processing.core.PApplet;
import processing.core.PImage;

public class Sketch3 extends PApplet {

    PImage Field;
    PImage Player;
    PImage HailMarryline;
    PImage CutRouteline;
    PImage BurnerRouteline;
    PImage SlantRouteline;

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

    //Load Image of Football Field
    Field = loadImage("Field.png");
    Field.resize(475, 275);

    //Load Image of Player
    Player = loadImage("Player.png");
    Player.resize(30,30);

    //Load Hail Marry Lines
    HailMarryline = loadImage("HailMarryLine.png");
    HailMarryline.resize(475, 275);

    //Load Cut Route lines
    CutRouteline = loadImage("CutRoute .png");
    CutRouteline.resize(475, 274);

    //Load Burner Route lines
    BurnerRouteline = loadImage("BurnerRoute.png");
    BurnerRouteline.resize(475, 275);

    //Load Slant Route lines
    SlantRouteline = loadImage("SlantRoute.png");
    SlantRouteline.resize(475, 275);

  }
    
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    image(Field, 150, 100);
    image(Field, 150, 475);
    image(Field, 750, 100);
    image(Field, 750, 475);

    //Route lines
    image(HailMarryline, 150, 100);
    image(CutRouteline, 150, 475);
    image(BurnerRouteline, 750, 100);
    image(SlantRouteline, 750, 475);

    
    //Hail Mary Text
    if(mouseX < 700 && mouseY < 450){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Hail Mary", 225, 85);
    

    //Hail mary route preview
    for(int i = 0; i < 4; i++){
      image(Player, intWRposXHailMary[i], intWRposYHailMary[i]);
    }

    for(int i = 0; i < 4; i++){
      intWRposXHailMary[i]-= 1;
    }

    for(int i = 0; i < 4; i ++){
      if(intWRposXHailMary[i] <= 150){
         intWRposXHailMary[i] = 465;
      }
    }

    //Burnen route text
    if(mouseX > 700 && mouseY < 450){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Burner route", 785, 85);



    //Burner route preview
    for(int i = 0; i < 4; i++){
      image(Player, intWRposXBurner[i], intWRposYBurner[i]);
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

    //Cut route text
    if(mouseX < 700 && mouseY > 450){
      fill(0, 240, 0);
    }
    else{
      fill(255); 
    }
    text("Cut Route", 225, 465);

    //Cut route preview 
    for(int i = 0; i < 4; i++){
      image(Player, intWRposXCut[i], intWRposYCut[i]);
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
      image(Player, intWRposXSlant[i], intWRposYSlant[i]);
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
  
  // define other methods down here.
}
