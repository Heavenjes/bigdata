package StringManipulation;


import javax.swing.*;
import java.awt.event.*;

public class Watch extends JFrame {

   
  JLabel labelMessage;
  JLabel labelTimer;
  int timePassed;
  JButton buttonStart;
  JButton buttonStop;
  Timer timer;
  JPanel panel;
 public Watch()
  {
   super("Timer");
   panel=new JPanel();
   labelMessage=new JLabel("Time passed");
   labelTimer=new JLabel("");
   buttonStart=new JButton("Start");
   buttonStart.addActionListener(new StartListener());
   buttonStop=new JButton("Stop");
   buttonStop.addActionListener(new StopListener());
   timer=new Timer(100,new TimerListener());
   getContentPane().add(panel);
   panel.add(labelMessage);
   panel.add(labelTimer);
   panel.add(buttonStart);
   panel.add(buttonStop);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setVisible(true);
   setSize(200,200);
 }
  public static void main(String args[])
   {
    new Watch();
   }
  class StartListener implements ActionListener
   { 
    public void actionPerformed(ActionEvent e)
   {
     timer.start();  
    } 
    }
  class StopListener implements ActionListener
   {
    public void actionPerformed(ActionEvent e)
    {
     timer.stop();
     timePassed=0;
     }
    }
  class TimerListener implements ActionListener
   {  
    public void actionPerformed(ActionEvent e)
     {
      timePassed++;
      int hours =(int) Math.floor(timePassed / 1000.0 / 60.0 / 60.0);
      int minutes =(int) Math.floor((timePassed - hours * 60 * 60 * 1000) / 1000.0 / 60.0); 
      int seconds = (int) Math.floor((timePassed - hours * 60 * 60 * 1000 - minutes * 60 * 1000) / 1000.0);
      labelTimer.setText(hours+":"+minutes+":"+seconds);
     }
    }
}
