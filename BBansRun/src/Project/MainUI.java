package Project;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MainUI {	
	private static final InputStream Sound = null;
	static String checkRadio1 = null;
	static String checkRadio2 = null;
	private static Image im;
	
	public void show() {
		this.main(null);
	}
	public static void main(String[] args) {
		JFrame JFmainUI = new JFrame("MAIN MENU");
		JPanel pn = new JPanel();
		JFmainUI.setSize(640, 480);	//MainGame.Game.WIDTH ,MainGame.Game.HEIGHT
		JFmainUI.setLocationRelativeTo(null);
		Container c = new Container();
		pn.setLayout(null); 		
		
		JButton option = new JButton("옵션");
		JButton exit = new JButton("나가기");
		JButton start = new JButton("케릭터 선택창");
		
	
		option.setLocation(0,0);
		option.setSize(140,70);
		
		option.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

			if(e.getSource() == option) {															
						JFrame MyFrame = new JFrame("옵션");
						MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						MyFrame.setSize(300, 150);
						MyFrame.setLocationRelativeTo(null);
						MyFrame.setLayout(new FlowLayout());
						MyFrame.setLayout(new GridLayout(3, 3));
						
						JLabel Label1 = new JLabel("볼륨 ");
						JRadioButton On = new JRadioButton("켜기");
						JRadioButton Off = new JRadioButton("끄기");
						JLabel Label2 = new JLabel("모드");
						JRadioButton WindowMode = new JRadioButton("창모드");
						JRadioButton FullMode = new JRadioButton("전체모드");
						JButton Ok = new JButton("확인");
						JLabel Label3 = new JLabel("");
						JLabel Label4 = new JLabel("");
						
						
						ButtonGroup Group1 = new ButtonGroup();
						ButtonGroup Group2 = new ButtonGroup(); 
						
						
						Group1.add(On);
						Group1.add(Off);
						Group2.add(WindowMode);
						Group2.add(FullMode);
						
						MyFrame.add(Label1);
						MyFrame.add(On);
						MyFrame.add(Off);
						MyFrame.add(Label2);
						MyFrame.add(WindowMode);
						MyFrame.add(FullMode);
						MyFrame.add(Label3);
						MyFrame.add(Ok);
						MyFrame.add(Label4);
						MyFrame.setVisible(true);
						
						if(checkRadio1 == null) {
							On.setSelected(true);
						}else {
							Off.setSelected(true);
						}
						if(checkRadio2 == null) {
							WindowMode.setSelected(true);
						}else {
							FullMode.setSelected(true);
						}
						MyFrame.setResizable(false);
						
						Ok.addActionListener(new ActionListener() {

							@Override

							public void actionPerformed(ActionEvent e) {

							if(e.getSource() == Ok) {
								if(Off.isSelected() == true) {
									checkRadio1 = "Y";
								}else {
									checkRadio1 = null;
									
								}
								
								if(WindowMode.isSelected() == true) {
									checkRadio2 = null;
								}else {
									checkRadio2 = "Y";
								}
								

								MyFrame.hide();
								
							}
						}
					});										
			}
		}
	});
		
		exit.setLocation(487,0);
		exit.setSize(140,70);
		
		exit.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

			if(e.getSource() == exit) {
				System.exit(0);			
			}
		}
	});
		
		start.setLocation(220, 350);
		start.setSize(200,100);
        
		start.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

			if(e.getSource() == start) {
				MainUI mainUi = new MainUI();
				Project.Pick.Cheol();
				JFmainUI.hide();
			}
		}
	});
		
		ImageIcon image = new ImageIcon("C:\\Users\\Cheol\\git\\BBansRun\\BBansRun\\res\\BackGround.jpg");	
		JLabel img = new JLabel(image);
		img.setBounds(0, 0, 640, 480);
		pn.add(img);
		
		class pn extends JPanel{
            
	        public void paintComponent(Graphics g){
	            super.paintComponent(g);
	            g.drawImage(im,0,0,getWidth(),getHeight(),this);
	        }
	    }
		
		
		pn.add(option);
		pn.add(exit);
		pn.add(start);
		
		JFmainUI.setResizable(false);
		JFmainUI.add(pn);
		JFmainUI.setVisible(true);
		
		
    }
}



	