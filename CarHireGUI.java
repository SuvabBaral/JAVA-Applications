


import java.awt.FlowLayout;
import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class CarHireGUI extends JFrame implements ActionListener
{
		
        private JLabel nameLabel=new JLabel("Customer name");
        private JLabel licenseLabel=new JLabel("License number");
	    private JLabel daysLabel=new JLabel("Hired days");

	    private JTextField nameField=new JTextField(28);
        private JTextField licenseField=new JTextField(14);
        private JTextField daysField=new JTextField(7);

        private JButton enterButton=new JButton("Enter");   //
	    private JButton displayButton=new JButton("Display");
        private JButton searchButton= new JButton("Search");

        private JButton exitButton=new JButton("Exit");
        private JTextArea textArea=new JTextArea(16,38);
        private JScrollPane scrollPane; // scroll pane for the text area

        final int MAX_NUM=10;
		private CarHire carHireArray[]=new CarHire[MAX_NUM];
		private int currentCustomer=0;

        private static final int FRAME_WIDTH = 490;// window size
        private static final int FRAME_HEIGHT = 430;

        
        public CarHireGUI()
        {
           super("  XYZ Car Hire App   ");
           setLayout(new FlowLayout());  //FlowLayout

           add(nameLabel);            
           add(nameField);
           add(licenseLabel);
           add(licenseField);
           add(daysLabel);
           add(daysField);

           scrollPane = new JScrollPane(textArea); 	
		   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
	       add(scrollPane);

           add(enterButton);
           add(displayButton);
           add(searchButton);
           add(exitButton);

           add(textArea);
           enterButton.addActionListener(this);  //listen to event
           displayButton.addActionListener(this);
           searchButton.addActionListener(this);
           exitButton.addActionListener(this);
        }

        //event handling method
        public void actionPerformed(ActionEvent e)
        {
			String actionString=e.getActionCommand();
			switch(actionString)
			{
				case "Enter":
					enterData();
					break;
				case "Display":
					displayAll();
					break;
				case "Search":
					search();
					break;
				case "Exit":
					exit();
					break;
				default:
					System.out.println("invalid input");
			}
		}

        
        public void enterData()
        {	
        	if (nameField.getText().compareTo("")==0){
        		JOptionPane.showMessageDialog(null,"You must enter a customer name", "XYZ Car Hire App",JOptionPane.ERROR_MESSAGE);
        		nameField.requestFocus();
        	}
        	else if(licenseField.getText().compareTo("")==0){
        		JOptionPane.showMessageDialog(null,"You must enter a license number","XYZ Car Hire App", JOptionPane.ERROR_MESSAGE);
        		licenseField.requestFocus();
        	}
        	else if(daysField.getText().compareTo("")==0){
        		JOptionPane.showMessageDialog(null,"You must enter the days hired","XYZ Car Hire App", JOptionPane.ERROR_MESSAGE);
        		daysField.requestFocus();
        	}
			else{
			displayHeading();
			
			//getting the field value
			String customerName=nameField.getText();
			String licenseNumber=licenseField.getText();
			int days=Integer.parseInt(daysField.getText());
			
			        
            
            carHireArray[currentCustomer]=new CarHire(customerName,licenseNumber,days);
            //carHireArray[currentCustomer].setcustomerName(customerName);
            //carHireArray[currentCustomer].setlicenseNumber(licenseNumber);
            //carHireArray[currentCustomer].setDays(days);
            double rental=carHireArray[currentCustomer].calculateHireRental();
            carHireArray[currentCustomer].setRental(rental);

            textArea.append(String.format("%-35s%-36s%-28s%-26s\n",carHireArray[currentCustomer].getcustomerName(),carHireArray[currentCustomer].getlicenseNumber(),carHireArray[currentCustomer].getdaysHired(),carHireArray[currentCustomer].getRental()));
            nameField.setText("");
            licenseField.setText("");
            daysField.setText("");
            
            nameField.requestFocus();
           	
           	//Incrementing the index after entry of each customer
           	currentCustomer++;

			}
		}
		/*public void displayAll(){
			int i;
			for(i=0;i<currentCustomer;i++){
				textArea.append(String.format("%-23s%-25s%-28s%-26s\n",carHireArray[i].getcustomerName(),carHireArray[i].getlicenseNumber(),carHireArray[i].getdaysHired(),carHireArray[i].calculateHireRental()));
			}
			
			System.out.println(i);
		}*/

        // Display all bookings
		public void displayAll()
		{
			if (currentCustomer==0){
				JOptionPane.showMessageDialog(null,"No Customer Entered","XYZ Car Hire App",JOptionPane.ERROR_MESSAGE);
			}
			else{
				textArea.setText("");
		    	displayHeading();
            	int i=0;
            	for (i=0;i< currentCustomer;i++){
           			textArea.append(String.format("%-23s%-25s%-30s%-28s\n",carHireArray[i].getcustomerName(),carHireArray[i].getlicenseNumber(),carHireArray[i].getdaysHired(),carHireArray[i].getRental()));
           		}
           		textArea.append("----------------------------------------------------------------------------------------------------\n");
           		textArea.append(String.format("%d entires\nAverage Days Hired: %d\nTotal rental received: $%s\n",CarHire.getTotalEntries(),(CarHire.getAvgDays()),CarHire.getTotalRental()));
           }
           
		}
		

        //search a particular customer booking
	    public void search()
	    {
	    	//getting the customer name
            String search_name=JOptionPane.showInputDialog(null,"Enter a customer name","XYZ Car Hire App",JOptionPane.QUESTION_MESSAGE);
            int i;

            for(i=0;i<currentCustomer;i++){
            	// search for the entered customer name
            	if (search_name.toLowerCase().equals(carHireArray[i].getcustomerName().toLowerCase())){
            		displayHeading();
            		textArea.append(String.format("%-23s%-25s%-28s%-26s\n",carHireArray[i].getcustomerName(),carHireArray[i].getlicenseNumber(),carHireArray[i].getdaysHired(),carHireArray[i].getRental()));
	           		break;
	           	}
	        }
	        	// if no customer is found 
	            if(i==currentCustomer){
	           		JOptionPane.showMessageDialog(null,"No such a customer found","XYZ Car Hire App",JOptionPane.ERROR_MESSAGE);
	           	}
            }
			
   
	   public void exit()
	   {
         JOptionPane.showMessageDialog(null,"Thank you for using XYZ Car Hire App","XYZ Car Hire App",JOptionPane.INFORMATION_MESSAGE);// To display the exit message
         System.exit(0);
	   }

       
       private void displayHeading()
       {
            textArea.setText(String.format("%-23s%-25s%-28s%-26s\n", "Customer name", "License number", "Days hired", "Rental"));
            textArea.append("----------------------------------------------------------------------------------------------------\n");
	   }

       public static void main(String[] args)
       {
		   JFrame frame = new CarHireGUI();
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		   frame.setVisible(true);
		   frame.setResizable(false);
	   }

}
