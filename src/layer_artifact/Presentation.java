package layer_artifact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Presentation implements ActionListener{
	
	JFrame f;
	JButton create,read,replace,delete;
	JLabel layer,agroup,artifact;
	JTextField t1,t2,t3;
	JButton submit;
	JPanel p2;
	
	Presentation(){
		f = new JFrame();
		
		p2 = new JPanel();
		
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
		
		p2.setBounds(450,150, 1000, 1000);
		p2.setVisible(true);
		p2.setLayout(null);
		f.add(p2);
		
		
		create.setBounds(30,50,80,30);
		//create.setVisible(false);
		p2.add(create);
		create.addActionListener(this);
		
		read.setBounds(130, 50, 80, 30);
		//read.setVisible(false);
		p2.add(read);
		read.addActionListener(this);
		
		replace.setBounds(230, 50, 80, 30);
		//replace.setVisible(false);
		p2.add(replace);
		replace.addActionListener(this);
		
		delete.setBounds(350, 50, 80, 30);
		//delete.setVisible(false);
		p2.add(delete);
		delete.addActionListener(this);
		
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
		submit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==create){
			create.setVisible(false);
			read.setVisible(false);
			replace.setVisible(false);
			delete.setVisible(false);
			
			layer.setVisible(true);
			agroup.setVisible(true);
			artifact.setVisible(true);
			t1.setVisible(true);
			t2.setVisible(true);
			t3.setVisible(true);
			submit.setVisible(true);
			
		}
		else if(e.getSource()==submit){
			int t=0;
			String layer = t1.getText().toString();
			String group = t2.getText().toString();
			String artifact = t3.getText().toString();
			
			System.out.println(layer);
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			try {
				Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/lay_at","root","root");
				Statement st = con.createStatement();
				String q = "SELECT * FROM layer;";
				ResultSet rs = st.executeQuery(q);
				
				//ArrayList<String> arrayList = new ArrayList<String>();
				
				while(rs.next()){
					String lay = rs.getString("layers");
					System.out.println(lay);
					if(lay.equals(layer)){
						t=1;
					}
				}
				
				if(t!=0){
					JOptionPane.showMessageDialog(f, "The specified layer already exist!");
				}
				else{
					String query = "INSERT INTO layer (layers)"+ "values(?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, layer);
					ps.execute();
					
					query = "INSERT INTO artifactGroup (aGroup)"+ "values(?)";
					ps = con.prepareStatement(query);
					ps.setString(1, group);
					ps.execute();
					
					query = "INSERT INTO artifact (artifact,aGroup,layer)"+ "values(?,?,?)";
					ps = con.prepareStatement(query);
					ps.setString(1, artifact);
					ps.setString(2, group);
					ps.setString(3, layer);
					ps.execute();
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
		}
		
	}

	

}
