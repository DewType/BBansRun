package Project;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MainUI {	
	static String checkRadio1 = null;
	static String checkRadio2 = null;
	public void show() {
		this.main(null);
	}
	public static void main(String[] args) {
		JFrame JFmainUI = new JFrame("MAIN MENU");
		JPanel pn = new JPanel();
//		JFmainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFmainUI.setSize(900, 500);
		JFmainUI.setLocationRelativeTo(null);
		
		Container c = new Container();
		pn.setLayout(null); 		
		
		JButton option = new JButton("옵션");
		JButton exit = new JButton("나가기");
		JButton start = new JButton("게임시작");
		
		option.setLocation(0,0);
		option.setSize(140,70);
		pn.add(option);
		
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
						JLabel Label2 = new JLabel("화면 ");
						JRadioButton WindowMode = new JRadioButton("창모드");
						JRadioButton FullMode = new JRadioButton("전체화면");
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
		
		exit.setLocation(747,0);
		exit.setSize(140,70);
		pn.add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

			if(e.getSource() == exit) {
				System.exit(0);			
			}
		}
	});
		
		start.setLocation(350,363);
		start.setSize(200,100);
		pn.add(start);
        
		start.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

			if(e.getSource() == start) {
				
			}
		}
	});
		
		JFmainUI.setResizable(false);
		JFmainUI.add(pn);
		JFmainUI.setVisible(true);
		
    }	
}

	