package layer_artifact;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home implements ActionListener {
	
	JFrame f;
	JPanel p1,p2;
	JButton b1,b2,b3;
	JButton create,read,replace,delete;
	JLabel layer,agroup,artifact;
	JTextField t1,t2,t3;
	JButton submit;
	
	Home(){
		f = new JFrame();
		p1 = new JPanel();
		p2 = new JPanel();
		b1 = new JButton("Presentation");
		b2 = new JButton("Artifact Group");
		b3 = new JButton("Artifact");
		create = new JButton("Create");
		read = new JButton("Read");
		replace = new JButton("Replace");
		delete = new JButton("Delete");
		
		layer = new JLabel("Enter Layer Name:");
		agroup = new JLabel("Enter Artifact Group Name:");
		artifact = new JLabel("Enter Artifat Name:");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		
		submit = new JButton("Submit");
		
	}
	
	public void dis(){
		f.setSize(1800, 1000);
		f.setVisible(true);
		f.setLayout(null);
		
		p1.setBounds(0, 150, 200, 400);
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p1.setVisible(true);
		f.add(p1);
		
		b1.setSize(80, 100);
		b2.setSize(80, 100);
		b3.setSize(80, 100);
		
		b1.setFont(new Font("tahoma", Font.BOLD, 20));
		b2.setFont(new Font("tahoma", Font.BOLD, 20));
		b3.setFont(new Font("tahoma", Font.BOLD, 20));
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		p2.setBounds(450,150, 1000, 1000);
		p2.setVisible(false);
		p2.setLayout(null);
		f.add(p2);
		
		create.setBounds(30,50,80,30);
		//create.setVisible(false);
		p2.add(create);
		
		read.setBounds(130, 50, 80, 30);
		//read.setVisible(false);
		p2.add(read);
		
		replace.setBounds(230, 50, 80, 30);
		//replace.setVisible(false);
		p2.add(replace);
		
		delete.setBounds(350, 50, 80, 30);
		//delete.setVisible(false);
		p2.add(delete);
		
		layer.setBounds(30, 100, 120, 30);
		layer.setVisible(false);
		p2.add(layer);
		
		t1.setBounds(165, 100, 120, 30);
		t1.setVisible(false);
		p2.add(t1);
		
		agroup.setBounds(30, 150, 120, 30);
		agroup.setVisible(false);
		p2.add(agroup);
		
		t2.setBounds(165, 150, 120, 30);
		t2.setVisible(false);
		p2.add(t2);
		
		artifact.setBounds(30, 210, 120, 30);
		artifact.setVisible(false);
		p2.add(artifact);
		
		t3.setBounds(165, 210, 120, 30);
		t3.setVisible(false);
		p2.add(t3);
		
		submit.setBounds(80,260,80,30);
		submit.setVisible(false);
		p2.add(submit);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1){
			p2.setVisible(true);
			
		}
		
		else if(e.getSource()==b2){
			p2.setVisible(true);
		}
		
		else if(e.getSource()==b3){
			p2.setVisible(true);
		}
		
	}
	
	

}
