package spring;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MenuExample implements ActionListener{    
JFrame f;    
JMenuBar mb;    
JMenu file,font,help,color,style;  
JMenuItem fs1,fs2,fs3,fs4,fs5,fs6,fs7,fs8,fs9,fs10,save,bg,fg,open,bold,italic;
JTextArea ta=new JTextArea(47,150);    
MenuExample()
{
   f=new JFrame();  
   
   fs1=new JMenuItem("12");    
   fs2=new JMenuItem("14");    
   fs3=new JMenuItem("16");    
   fs4=new JMenuItem("18"); 
   fs5=new JMenuItem("20"); 
   fs6=new JMenuItem("22"); 
   fs7=new JMenuItem("24"); 
   fs8=new JMenuItem("28"); 
   fs9=new JMenuItem("36"); 
   fs10=new JMenuItem("72"); 
   
   bold=new JMenuItem("Bold");
   italic=new JMenuItem("Italic");
   
   
   save=new JMenuItem("Save");
   open=new JMenuItem("Open");

   bg=new JMenuItem("Background");
   fg=new JMenuItem("Foreground");
   
   fs1.addActionListener(this);    
   fs2.addActionListener(this);    
   fs3.addActionListener(this);    
   fs4.addActionListener(this);  
   fs5.addActionListener(this);  
   fs6.addActionListener(this);  
   fs7.addActionListener(this);  
   fs8.addActionListener(this);  
   fs9.addActionListener(this);  
   fs10.addActionListener(this);  
   save.addActionListener(this); 
   open.addActionListener(this); 
   bg.addActionListener(this);
   fg.addActionListener(this);
   bold.addActionListener(this);
   italic.addActionListener(this);
  
   
   
   f.getContentPane().setLayout(new FlowLayout());  
   JScrollPane scrollableTextArea = new JScrollPane(ta);  
   scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
   scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
   f.getContentPane().add(scrollableTextArea);  
   
  
   mb=new JMenuBar();    
   file=new JMenu("File");    
   font=new JMenu("Font Size");
   style=new JMenu("Font Style");
   color=new JMenu("Colour");
   help=new JMenu("Help");     
   font.add(fs1);font.add(fs2);font.add(fs3);font.add(fs4);font.add(fs5);font.add(fs6);font.add(fs7);
   font.add(fs8);font.add(fs9);font.add(fs10);
   style.add(bold);style.add(italic);
   file.add(save);file.add(open);
   color.add(bg);color.add(fg);
   mb.add(file);mb.add(font);mb.add(color);mb.add(style);mb.add(help);    
  
   f.add(mb);   
   f.setJMenuBar(mb);
   
   f.setSize(400,400);    
   f.setVisible(true);     
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
} 

public void actionPerformed(ActionEvent e) {  
	
  if(e.getSource()== save)
  {
	  JFileChooser save = new JFileChooser();
		
		int option = save.showSaveDialog(f);
		File file = new File(save.getSelectedFile().getPath());
		try
		{
		String source = ta.getText();
		char buffer[] = new char[source.length()];
		source.getChars(0,source.length(),buffer,0);

		FileWriter f1= new FileWriter(file+".txt");
		for(int i=0;i<buffer.length;i++)
		{
		f1.write(buffer[i]);
		}
		f1.close();
		}
		catch(Exception ae)
		{
			System.out.println("User Closed Unexpectedly");
		}
		}
  if(e.getSource()==open)
  {
	  JFileChooser open = new JFileChooser();
	  int option1=open.showOpenDialog(f);
	  if (option1 == JFileChooser.APPROVE_OPTION) {
	  File file = open.getSelectedFile();
      //This is where a real application would open the file.
	  String filepath=file.getPath();    
      try{  
      BufferedReader br=new BufferedReader(new FileReader(filepath));    
      String s1="",s2="";                         
      while((s1=br.readLine())!=null){    
      s2+=s1+"\n";    
      }    
      ta.setText(s2);    
      br.close();    
      }catch (Exception ex) {ex.printStackTrace();  }                 
  
	  }
  }
	
	
  if(e.getSource()== fs1)    
{
 
	  Font font = new Font("Calibri", Font.PLAIN, 12);
      ta.setFont(font);
}
  if(e.getSource()== fs2)  
{
	  Font font = new Font("Calibri", Font.PLAIN, 14);
      ta.setFont(font); 
}
  if(e.getSource() == fs3)    
{
	  Font font = new Font("Calibri", Font.PLAIN, 16);
      ta.setFont(font);   
}
  if(e.getSource() == fs4)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN, 18);
        ta.setFont(font); 
  }  
  if(e.getSource() == fs5)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN, 20);
        ta.setFont(font); 
  }  
  if(e.getSource() == fs6)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN, 22);
        ta.setFont(font); 
  }  
  if(e.getSource() == fs7)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN, 24);
        ta.setFont(font); 
  }  
  if(e.getSource() == fs8)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN, 28);
        ta.setFont(font); 
  }  
  if(e.getSource() == fs9)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN, 36);
        ta.setFont(font); 
  }  
  if(e.getSource() == fs10)   
  {
  	  Font font = new Font("Calibri", Font.PLAIN,72);
        ta.setFont(font); 
  } 
  if(e.getSource()==bold)
  {
	  Font font = new Font("Calibri", Font.BOLD,14);
      ta.setFont(font); 
  }
  if(e.getSource()==italic)
  {
	  Font font = new Font("Calibri", Font.ITALIC,14);
      ta.setFont(font); 
  }
  
  
  if(e.getSource()==bg)
  {
	  Color initialcolor=Color.WHITE;    
	  Color color=JColorChooser.showDialog(ta,"Select a color",initialcolor);    
	  ta.setBackground(color);
  }
  if(e.getSource()==fg)
  {
	  Color initialcolor=Color.WHITE;    
	  Color color=JColorChooser.showDialog(ta,"Select a color",initialcolor);  
	  ta.setForeground(color);
	
  }
  
  
}
public static void main(String[] args) {    
    new MenuExample();    
}    
}    