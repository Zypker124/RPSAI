package other_programs;
import java.awt.*; //Import packages
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class RPSAI extends JFrame{ //inherit JFrame, initiate class
    
	public static void main(String[]args){ //initiate main method
    	RPSAI ai = new RPSAI(); //Instantiate a version of the class
	}
    
	public RPSAI(){ //Initialize a constructor
	super("RPSAI.java"); //Name the reference to the JFrame
 	setSize(1350, 750); //Set the size of the panel.
 	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Dispose the window upon exiting the terminal / console.
 	RPSAI2 rps = new RPSAI2(); // Initiate Garden class
 	setContentPane(rps); //Set the content pane according to Garden
 	setLocation(0, 0); //Set the location of the JPanel.
 	setResizable(false); //Prohibit resizing
 	setVisible(true); //Make the content pane visible
	}
}
class RPSAI2 extends JPanel implements MouseListener, FocusListener, ActionListener{ //inherit JPanel and events
    
	//MOST IMPORTANT ONE: Control AI difficulty!
	//lower #s = easier AIs
	//higher #s = harder AIS
	private int segLength=5;
    
	//ALSO IMPORTANT: Decide when the AI starts analyzing moves instead of randomly generating outputs.
	//This number MUST be greater than SegLength.
	private int start=12;
    
    
	//Other variables - please do not change
    
	private Timer timer;
	private JButton rock;
	private JButton paper;
	private JButton scissors;
	private boolean lockNum=false;
	private String P1rps;
	private String P2rps;
	private int randNum;
	private String[] previous;
	private int rounds;
	private int index, index2;
	private int win,draw,lose;
	private int finalPlay;
	private String previousPlays;
	private String previousSegments;
	private String concat;
	private String predict;
	private boolean matchFound;
	private boolean youWin, youDraw, youLose;
	private boolean aiMODE;
	Graphics g;
	public RPSAI2(){ //Instantiate constructor
    	rounds=index=index2=win=draw=lose=0;
    	P1rps="-";
    	P2rps="-";
    	previousPlays=previousSegments=predict="";
    	previous = new String[1000];
    	setLayout(new FlowLayout(FlowLayout.LEFT,300,650)); //Set the layout
    	rock = new JButton("Rock");//instantiate buttons
    	add(rock);
    	rock.addActionListener(this);//add listener
    	paper = new JButton("Paper");//instantiate buttons
    	add(paper);
    	paper.addActionListener(this);//add listener
    	scissors = new JButton("Scissors");//instantiate buttons
    	add(scissors);
    	scissors.addActionListener(this);//add listener
addFocusListener(this); //Add a focus listener
  RepaintAction action = new RepaintAction();
  timer = new Timer(4,action); //Initialize and set parameters to timer
timer.start(); //Start the timer
    	setBackground(Color.WHITE); //set background color to black
	addMouseListener(this); //Write methods to add the listeners
	addFocusListener(this);
	}
    
 	private class RepaintAction implements ActionListener { //Private class nested in JPanel class to act on ActionListener and repaint
     	public void actionPerformed(ActionEvent evt) { //Call the actionPerformed method
        	repaint();  // Call the repaint() method in the panel class.
     	}
  	}
    
	public void mousePressed(MouseEvent e){ //Write the event handler methods.
   	 
	}
	public void mouseReleased(MouseEvent e){
   	 
	}
	public void mouseClicked(MouseEvent e){
   	 
	}
	public void mouseEntered(MouseEvent e){
	requestFocus();
	}
	public void mouseExited(MouseEvent e){
    
	}
	public void focusLost(FocusEvent f){
     	// timer.start();
      	repaint();
   	}
   	public void focusGained(FocusEvent f){
   	// timer.stop();
       	repaint();
   	}
  	 
    
	public void actionPerformed(ActionEvent e){
   	 
    	youWin=false;
    	youDraw=false;
    	youLose=false;
    	lockNum=false;
    	P1rps="-";
    	P2rps="-";
    	matchFound=false;
    	previousPlays=previousSegments=concat="";
    	if(e.getSource()==rock){
        	P1rps="rock";
        	previous[index2]="R";
    	}else if(e.getSource()==paper){
        	P1rps="paper";
        	previous[index2]="P";
    	}else if(e.getSource()==scissors){
        	P1rps="scissors";
        	previous[index2]="S";
    	}
    	index2++;
    	for(int i = 0; i<20; i++){
       	 
    	}
   	 
   	 
    	if(index<=start){
        	randNum=(int)(Math.random()*3+1);
        	if(randNum==1){
            	P2rps="rock";
        	}else if(randNum==2){
            	P2rps="paper";
        	}else if(randNum==3){
            	P2rps="scissors";
        	}
    	}else{
        	aiMODE=true;
        	for(int i = 0; i<previous.length;i++){
           	 
            	if(previous[i]!=null){
               	 
                	finalPlay=i;
            	}
        	}
       	 
        	for(int z = finalPlay; z>finalPlay-segLength;z--){
           	 
            	previousPlays+=previous[z];
        	}
        	for(int t = finalPlay-2; t>=segLength;t--){
           	 
            	if(matchFound==false){
               	 
                	if(previousSegments.length()>=segLength){
                    	concat=previousSegments.substring(1);
                    	previousSegments=concat+previous[t];
                	}else{
                    	previousSegments+=previous[t];
                	}
                	if(previousPlays.equals(previousSegments)){
   					 System.out.println(previousPlays);
                    	System.out.println(previousSegments);
                    	matchFound=true;
                    	predict=previous[t+segLength-1];
                    	if(predict=="R"){
                        	P2rps="paper";
                    	}else if(predict=="P"){
                        	P2rps="scissors";
                    	}else if(predict=="S"){
                        	P2rps="rock";
                    	}
                    	System.out.println(P1rps);
                    	System.out.println(P2rps);
                    	System.out.println();
                	}
            	}
           	 
        	}
    	}
    	index++;
   	 
    	if(segLength<3){
       	 
    	}else if(matchFound==false){
        	segLength--;
    	}
   	 
    	if(matchFound==false){
        	randNum=(int)(Math.random()*3+1);
        	if(randNum==1){
            	P2rps="rock";
        	}else if(randNum==2){
            	P2rps="paper";
        	}else if(randNum==3){
            	P2rps="scissors";
        	}
    	}
   	 
    	if(lockNum==false){
        	if( P1rps==P2rps && !(P1rps.equals("")) ){
            	draw++;
            	youDraw=true;
            	lockNum=true;
        	}else if(P1rps=="rock"&&P2rps=="paper"){
            	lose++;
            	youLose=true;
            	lockNum=true;
        	}else if(P1rps=="rock"&&P2rps=="scissors"){
            	win++;
            	youWin=true;
            	lockNum=true;
        	}else if(P1rps=="paper"&&P2rps=="scissors"){
            	lose++;
            	youLose=true;
            	lockNum=true;
        	}else if(P1rps=="paper"&&P2rps=="rock"){
            	win++;
            	youWin=true;
            	lockNum=true;
        	}else if(P1rps=="scissors"&&P2rps=="paper"){
            	win++;
            	youWin=true;
            	lockNum=true;
        	}else if(P1rps=="scissors"&&P2rps=="rock"){
            	lose++;
            	youLose=true;
            	lockNum=true;
        	}
        	}
   	 
   	 
   	 
	}
    
	public void paintComponent(Graphics g){
   	 
	super.paintComponent(g);
    
	Image rock = Toolkit.getDefaultToolkit().getImage("Rock.png");//summon images of rock, paper and scissors
  	Image paper = Toolkit.getDefaultToolkit().getImage("Paper.png");//summon images of rock, paper and scissors
  	Image scissors = Toolkit.getDefaultToolkit().getImage("Scissors.png");//summon images of rock, paper and scissors
   	 
	//Prompt
	g.setColor(Color.BLACK);
	Font font = new Font("Comic San",Font.BOLD,50);
	g.setFont(font);
	g.setColor(Color.GREEN);
	g.drawString("Pick rock, paper, or scissors",300,60);
    
	//Player 1
	g.setColor(Color.CYAN);
	g.fillOval(100, 300, 200, 200);
	Font fontBig = new Font("Comic San",Font.BOLD,45);
	g.setFont(fontBig);
	g.setColor(Color.BLACK);
	g.drawString("P1", 160, 410);
    
	//Player 2
	g.setColor(Color.RED);
	g.fillOval(1000, 300, 200, 200);
	g.setColor(Color.BLACK);
	g.drawString("P2", 1060, 410);
    
	//Scores
	g.drawString("Wins", 450, 200);
	g.drawString(win+"", 450, 250);
    
	g.drawString("Draws", 650, 200);
	g.drawString(draw+"", 650, 250);
    
	g.drawString("Losses", 850, 200);
	g.drawString(lose+"", 850, 250);
    
	//Statements
	if(youWin==true){
    	Color green = new Color(10,240,10);
    	g.setColor(green);
    	g.drawString("You win!", 600, 600);
	}else if(youDraw==true){
    	g.setColor(Color.ORANGE);
    	g.drawString("You draw.", 600, 600);
	}else if(youLose==true){
    	g.setColor(Color.RED);
    	g.drawString("You lose.", 600, 600);
	}
    
	//Tell user AI starts predicting moves
	if(aiMODE==true){
   	 Font regBig = new Font("Comic San", Font.BOLD, 20);
   	 g.setFont(regBig);
   	 g.setColor(Color.BLUE);
   	 g.drawString("AI now predicting moves.",1100,100);
   	 }
   	 
	//Show symbols each player picked
	if(P1rps=="rock"){
   	   g.drawImage(rock,400,300,800,700,0,0,300,300,this);
   	 }else if(P1rps=="paper"){
   	   g.drawImage(paper,400,300,800,700,0,0,300,300,this);
   	 }else if(P1rps=="scissors"){
   	   g.drawImage(scissors,400,300,800,700,0,0,300,300,this);
   	 }
  	if(P2rps=="rock"){
   	   g.drawImage(rock,800,300,1200,700,0,0,300,300,this);
   	 }else if(P2rps=="paper"){
   	   g.drawImage(paper,800,300,1200,700,0,0,300,300,this);
   	 }else if(P2rps=="scissors"){
   	   g.drawImage(scissors,800,300,1200,700,0,0,300,300,this);
   	 }
   	 
	}
}

