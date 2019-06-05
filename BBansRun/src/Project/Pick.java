package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


	

public class Pick extends JFrame implements ActionListener {
	JButton pick, pick1, pick2, pick3;
	Pick() {
		JPanel pn = new JPanel();
		setLocationRelativeTo(null);
		setLayout(null); 
		

		
		pick = new JButton(new ImageIcon("img/btLogin.png"));//이미지 여기다 넣기
		pick1 = new JButton(new ImageIcon("img/btLogin.png"));//이미지 여기다 넣기
		pick2 = new JButton(new ImageIcon("img/btLogin.png"));//이미지 여기다 넣기
		pick3 = new JButton("게임 시작");
		
		pick.setLocation(20, 120);
		pick.setSize(130, 130);
		
		pick1.setLocation(250, 120);
		pick1.setSize(130, 130);
		
		pick2.setLocation(475, 120);
		pick2.setSize(130, 130);
		
		pick3.setLocation(220, 350);
		pick3.setSize(200,100);
		
		add(pick);
		add(pick1);
		add(pick2);	
		add(pick3);	
		
		pick.addActionListener(this);
		pick1.addActionListener(this);
		pick2.addActionListener(this);
		pick3.addActionListener(this);
		
		setSize(640, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public Pick(String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pick){//케릭터 선택
			
			} 
		if(e.getSource()==pick1){//케릭터 선택
			
		} 
		if(e.getSource()==pick2){//케릭터 선택
			
		}
		if(e.getSource()==pick3){//게임시작버튼
			MainUI mainUi = new MainUI();
			MainGame.Game.Han();
			setVisible(false);
		}
	}
	public static void main(String[] args){
		new Pick(); 
		}
	public static void Cheol() {
		main(null);
	}
}
