import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


//Author : Carlo Carabeo
@SuppressWarnings("serial")
public class Syanad_proto extends JFrame implements ActionListener{

	//For database
	java_sql js = new java_sql();
	
	//Variable declarations
	//Frame for interface
	private JFrame Syanad_Frame;
	
	//Labels
    private JLabel lblCourseCode;
    private JLabel lblDate;
    private JLabel lblProf;
    private JLabel lblSection;
    
    //Constant Tags
    private JLabel lblCourseCode_tag;
    private JLabel lblClassList_tag;
    private JLabel lblDate_tag;
    private JLabel lblProf_tag;
    private JLabel lblSection_tag;
    
    //LIST CONSTANT TAGS
    //private JLabel lblClassList_tag;
    private JLabel lblTimein_tag;
    private JLabel lblID_num_tag;
    private JLabel lblStudent_name_tag;
    
    //Lists
    private JList<String/*Student*/> lstClassList;
    private JList<String/*Student*/> lstTimein;
    private JList<String/*Student*/> lstID_num;
    private JList<String/*Student*/> lstStudent_name;
    private JList<String/*Student*/> lstAttendance;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Syanad_proto window = new Syanad_proto(); //creates the window
					window.Syanad_Frame.setVisible(true);//shows the window
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    
    
	public Syanad_proto() { //Starts the frame constructor for window and initiates values
		init();
                String[][] temp = js.query("SELECT * FROM attendance");
                String[] tIn = new String[30];
                
                for(int cnt = 0; cnt < temp.length; cnt++)
                {
                    tIn[cnt]    = temp[cnt][3].substring(11,16);
                }
                System.out.println(tIn[0]);
	}
	
	public void init() {						//Initiates the Frame for the GUI
		Syanad_Frame = new JFrame();
		Syanad_Frame.setTitle("Anti Truancy System");
//		Syanad_Frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image file name"));
		//Above line sets the icon when running
		Syanad_Frame.setBounds(100, 100, 582, 400); //Size of frame
		Syanad_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Syanad_Frame.getContentPane().setLayout(null);
		draw(); 								//Draws the GUI
	
	}
    

	public void draw() {					//draws the interface
		//Constant Labels
		//TAGS
		//"Course Code : " sets the placement and adds to the content pane
		this.lblCourseCode_tag = new JLabel("Course Code : ");
		lblCourseCode_tag.setBounds(10, 10, 100, 30);
		Syanad_Frame.getContentPane().add(lblCourseCode_tag);

		//"Section : " sets the placement and adds to the content pane
		this.lblSection_tag = new JLabel("Section : ");
		lblSection_tag.setBounds(10, 30, 100, 30);
		Syanad_Frame.getContentPane().add(lblSection_tag);
		
		//"Professor : " sets the placement and adds to the content pane
		this.lblProf_tag = new JLabel("Professor : ");
		lblProf_tag.setBounds(300, 10, 400, 30);
		Syanad_Frame.getContentPane().add(lblProf_tag);

		//"Date : " sets the placement and adds to the content pane
		//Is this a button?
		this.lblDate_tag = new JLabel("Date : ");
		lblDate_tag.setBounds(300, 30, 400, 30);
		Syanad_Frame.getContentPane().add(lblDate_tag);
		
		//VALUES
		//"<Course Code> " sets the placement and adds to the content pane
		//Query for Label text
		this.lblCourseCode = new JLabel("<Course Code>");
		lblCourseCode.setBounds(100, 10, 300, 30);
		Syanad_Frame.getContentPane().add(lblCourseCode);
		
		//"<Section>" sets the placement and adds to the content pane
		//Query for Label text
		this.lblSection = new JLabel("<Section number>");
		lblSection.setBounds(100, 30, 300, 30);
		Syanad_Frame.getContentPane().add(lblSection);
		
		//"<Professor name> " sets the placement and adds to the content pane
		//Query for Label text
		this.lblProf = new JLabel("<Professor name>");
		lblProf.setBounds(390, 10, 300, 30); //Fix positioning
		Syanad_Frame.getContentPane().add(lblProf);
		
		//"<Date_today>" sets the placement and adds to the content pane
		//Query for Label text
		this.lblDate = new JLabel("<Date today>");
		lblDate.setBounds(390, 30, 300, 30);
		Syanad_Frame.getContentPane().add(lblDate);
		
		//LISTS + LABELS
		//List of Students // Status of attended or not
		this.lstAttendance = new JList<String>();
		lstAttendance.setBounds(30, 100, 450, 240);
		Syanad_Frame.getContentPane().add(lstAttendance);
		
		listItems(lstAttendance);
		
		//LABELS
		this.lblStudent_name_tag = new JLabel("Student name");
		lblStudent_name_tag.setBounds(30, 30, 100, 90);
		Syanad_Frame.getContentPane().add(lblStudent_name_tag);

		this.lblID_num_tag = new JLabel("ID number");
		lblID_num_tag.setBounds(155, 30, 100, 90);
		Syanad_Frame.getContentPane().add(lblID_num_tag);

		this.lblTimein_tag = new JLabel("Time In");
		lblTimein_tag.setBounds(280, 30, 100, 90);
		Syanad_Frame.getContentPane().add(lblTimein_tag);
		
		this.lblClassList_tag = new JLabel("Classlist");
		lblClassList_tag.setBounds(405, 30, 100, 90);
		Syanad_Frame.getContentPane().add(lblClassList_tag);
		
		
		
		this.lstClassList = new JList<String>();
		lstClassList.setBounds(30, 100, 100, 240);
		Syanad_Frame.getContentPane().add(lstClassList);
		
		
		
		//Time In
		this.lstTimein = new JList<String>();
		lstTimein.setBounds(155, 100, 100, 240);
		Syanad_Frame.getContentPane().add(lstTimein);
		
		
		//ID Number
		this.lstID_num = new JList<String>();
		lstID_num.setBounds(280, 100, 100,240);
		Syanad_Frame.getContentPane().add(lstID_num);
		


		//Student name
		this.lstStudent_name = new JList<String>();
		lstStudent_name.setBounds(405, 100, 100,240);
		Syanad_Frame.getContentPane().add(lstStudent_name);
		
		
	
	    				
	}																	//end draw
	
	private void listItems(JList<String> lstAttendance){
		
		
		int numOfStudents = 17;
                Student[] x = new Student[numOfStudents];
		String[][] temp = new String[30][6];
		 //Constructs all students
		for(int i=0; i<numOfStudents; i++){
				temp=js.query("SELECT * FROM student");
				x[i] = new Student(temp[i][0], temp[i][1], temp[i][2], temp[i][3]);
		  }
                
		  String[] str = new String[numOfStudents];
		  //Sets strings from all students
		  for(int i=0; i<numOfStudents; i++){  
			  str[i] = x[i].getStudentID() + x[i].getFirstName() + x[i].getLastName() + x[i].getMiddleInitial();
		 
		  }
		  
		  //generated to from netbeans minodify ko ng konti di ko sure kung gagana
		  //pero add items sya sa list
//		  lstTimein.setModel(new javax.swing.AbstractListModel() {
//			  public int getSize()
//			  {
//				  return strings.length;
//			  }
//			  public Object getElementAt(int i)
//			  {
//				  return str[i];
//			  }
//        	}
//		  );
		 
		 
		 
		
	}

	
    
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
