package Project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Option {
	
	public void Opt() {
		
	}
	public static void main(String[] args) {
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
		
		On.setSelected(true);
		WindowMode.setSelected(true);
		MyFrame.setResizable(false);
		
		Ok.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
		    
			if(e.getSource() == Ok) {
							
			}
		}
	});
		
	}
}