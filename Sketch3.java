import processing.core.PApplet;
import processing.core.PImage;

public class Sketch3 extends PApplet {

    PImage Field;
    PImage Player;

    //Hail Mary route WR starting positions
    int[] intWRposYHailMary = {140,190,250,300};
    int[] intWRposXHailMary = {415,415,415,415};

    //Burner route WR starting positions
    int[] intWRposYBurner = {140, 190, 250, 300};
    int[] intWRposXBurner = {1065, 1065, 1065, 1065};

    //Cut route WR starting positions 
    int[] intWRposXCut = {415, 415, 415, 415};
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
    
  }
    
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    image(Field, 100, 100);
    image(Field, 100, 475);
    image(Field, 750, 100);
    image(Field, 750, 475);

    
    //Hail Mary Text
    if(mouseX < 700 && mouseY < 450){
      fill(0, 204, 0);
    }
    else{
      fill(255);
    }

    textSize(75);
    text("Hail Mary", 175, 85);
    

    //Hail mary route preview
    for(int i = 0; i < 4; i++){
      image(Player, intWRposXHailMary[i], intWRposYHailMary[i]);
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
    if(mouseX < 700 && mouseY > 450){
      fill(0, 240, 0);
    }
    else{
      fill(255); 
    }
    text("Cut Route", 175, 465);

    //Cut route preview 
    for(int i = 0; i < 4; i++){
      image(Player, intWRposXCut[i], intWRposYCut[i]);
    }

    intWRposXCut[0]-= 1;
    intWRposXCut[1]-= 1;
    intWRposXCut[2]-= 1;
    intWRposXCut[3]-= 1;

    if(intWRposXCut[0] <= 332){
      intWRposYCut[0]++;
      intWRposXCut[0]-=2;
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

      
  }
  
  // define other methods down here.
}
