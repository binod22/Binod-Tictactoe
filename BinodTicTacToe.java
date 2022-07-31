import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class BinodTicTacToe extends JFrame implements  ActionListener{

    int i,j,ii,jj,x,y,yesnull; 

    // boundary for button
    int a[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
     int a1[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
				
      boolean state,type,set;

      //store image
      Icon cross,Circle,icon,cross1,Circle2;
      Checkbox c1,c2;
      JLabel l1,l2;
      //clickable buttons
      JButton b[]=new JButton[9];
      //Playagain button
      JButton Playagain;

      
public void showButton(){

  x=10; 
  y=10;j=0;

  for(i=0;i<=8;i++,x+=100,j++){
     b[i]=new JButton();

     if(j==3){
      j=0; y+=100; x=10;
    }
    b[i].setBounds(x,y,100,100);
    add(b[i]);
    // add listener to every button
    b[i].addActionListener(this);
}

  Playagain=new JButton("Playagain");
  Playagain.setBounds(100,350,100,50);
  add(Playagain);
  //add event listener for Playagain button
  Playagain.addActionListener(this);

}
public  void check(int num1){
for(ii=0;ii<=7;ii++){
   for(jj=1;jj<=3;jj++){
        if(a[ii][jj]==num1){ a[ii][4]=11;  
        }
      }
    }
}

//main constructor
BinodTicTacToe(){
    super("tic tac toe by Binod");
    state=true;type=true;set=true;
    cross=new ImageIcon("cross.jpg");
    Circle=new ImageIcon("Circle.jpg");
    cross1=new ImageIcon("cross1.jpg");
    Circle2=new ImageIcon("Circle2.jpg");

    setLayout(null);
    setSize(330,450);
    setVisible(true);
    showButton();
    // cross click vayo vane exit
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}


// button click huda k garne vanera define gareko
public void actionPerformed(ActionEvent e){

if(type==true){
  //Playagain button thicda sabai image remove garne
if(e.getSource()==Playagain){
 for(i=0;i<=8;i++){
   b[i].setIcon(null);
  } 
}
else{ 
  for(i=0;i<=8;i++){
      if(e.getSource()==b[i]){
       
           if(b[i].getIcon()==null){
              if(state==true){ icon=Circle;         
               state=false;} else{ icon=cross; state=true; }
            b[i].setIcon(icon);
            }
          } 
      }
    }
}
else if(type==false){                                    
      if(e.getSource()==Playagain){
          for(i=0;i<=8;i++){
            b[i].setIcon(null);
          }
       for(i=0;i<=7;i++)
         for(j=0;j<=4;j++)
		        a[i][j]=a1[i][j];
        }
    }

    // checking for winner
for(i=0;i<=7;i++){
  
  Icon icon1=b[(a[i][1]-1)].getIcon();
  Icon icon2=b[(a[i][2]-1)].getIcon();
  Icon icon3=b[(a[i][3]-1)].getIcon();
     if((icon1==icon2)&&(icon2==icon3)&&(icon1!=null)){
               if(icon1==cross){ 
                 b[(a[i][1]-1)].setIcon(cross1);
                 b[(a[i][2]-1)].setIcon(cross1); 
                 b[(a[i][3]-1)].setIcon(cross1);
                 //display winner name
	              JOptionPane.showMessageDialog(BinodTicTacToe.this,"Cross win");	
  		           break;
           }
             else if(icon1==Circle){ 
             b[(a[i][1]-1)].setIcon(Circle2);
             b[(a[i][2]-1)].setIcon(Circle2);
             b[(a[i][3]-1)].setIcon(Circle2); 
             // display winner name
               JOptionPane.showMessageDialog(BinodTicTacToe.this,"Circle win");
                break;			 
               }
         }
    }  
}
public static void main(String []args){
  // call constructor
    new BinodTicTacToe();
   }
}