package Project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;


class IDLogin {
	
	public static Object Ok;

	public IDLogin() {
			JFrame MyFrame = new JFrame("�α���â");
			MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MyFrame.setSize(300, 150);
			MyFrame.setLocationRelativeTo(null);
			MyFrame.setLayout(new FlowLayout());
			
			JLabel Label1 = new JLabel("��ǥ �г����� �������ּ���!");
			JTextField tf = new JTextField(20);
			JButton Ok = new JButton("Ȯ��");  	
			
			JRootPane  rootPane  =  MyFrame.getRootPane();
			rootPane.setDefaultButton(Ok); 
			
			MyFrame.add(Label1);
			MyFrame.add(tf);
			MyFrame.add(Ok);
			
			MyFrame.setVisible(true);
			
			Ok.addActionListener(new ActionListener() {

				@Override

				public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Ok) {
					
					MyFrame.hide();
					MainUI mainUi = new MainUI();
					mainUi.show();
				}
			}
		});
	}

	public static void main(String[]args) {
		 new IDLogin();
	}
	
	
	
//       public static void main(String args[]){
//    	   
//    	   	JFrame MyFrame = new JFrame("�α���â");
//   			MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//   			MyFrame.setSize(300, 150);
//   			MyFrame.setLocationRelativeTo(null);
//   			MyFrame.setLayout(new FlowLayout());
//   			
//   			JLabel Label1 = new JLabel("��ǥ �г����� �������ּ���!");
//   			JTextField tf = new JTextField(20);
//   			JButton Ok = new JButton("Ȯ��");  	
//   			
//   			JRootPane  rootPane  =  MyFrame.getRootPane();
//   			rootPane.setDefaultButton(Ok); 
//   			
//   			MyFrame.add(Label1);
//   			MyFrame.add(tf);
//   			MyFrame.add(Ok);
//   			add(MyFrame);
//   			
//            MyFrame.setVisible(true);
//            
//       }
}

//class MyAactionLstener implements ActionListener{
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		}	
//}