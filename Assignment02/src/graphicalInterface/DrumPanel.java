package graphicalInterface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domain.Drum;
import domain.FlammableDrum;
import domain.ToxicDrum;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the main panel/container object for the application GUI widgets.
 * This is a java Swing application.
 */
public class DrumPanel extends JPanel {

	/*Label prompting the user to enter the number of drums to create*																	*/
	private JLabel drumPrompt;
	/** thsi is a text field to enter the nuber of drums to create																*/
	private JTextField numberToCreate;
	/** 	radio button for flammable drum type																*/
	private JRadioButton flammableDrumType;
	/** 	radio button for toxic drum type																	*/
	private JRadioButton toxicDrumType;
	/** 	button for create drums based on user input																	*/
	private JButton createDrums;
	/**   button for showing results on the created drums																*/
	private JButton runTests;
	/** TODO:	text area for displaying test results 																*/
	private JTextArea testResults;
	/** display status and error messages																	*/
	private JLabel statusField;

	/** List of drums creates.														*/
	List<Drum> listOfDrums = new ArrayList<Drum>();
	
	/** Serial version required. */
	private static final long serialVersionUID = 1L;

	/**
	 * Create and populate the main drum panel with appropriate GUI widgets.
	 */
	public DrumPanel() {
		initGUI();
	}

	/**
	 * Create and populate the panel with appropriate GUI components.
	 */
	private void initGUI() {
		setToolTipText("When finished with the application click the 'X' on the top bar, right side to close the application");
		setLayout(new FlowLayout());	
		
		JPanel p = new JPanel();

		p.add(createDrumTypePanel());
		p.add(createDrumNumberPanel());
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(p);
		
		box.add(createButtonPanel());

		add(box,TOP_ALIGNMENT);
		add(createResultsPanel(),CENTER_ALIGNMENT);
		statusField = new JLabel("Status field for errors etc.");
		add(statusField,BOTTOM_ALIGNMENT);
	}

	/**
	 * creating the panel for displaying results
	 * @return  the test result text area
	 */
	private JPanel createResultsPanel()	{
		JPanel trp = new JPanel();
		testResults = new JTextArea(25, 50);
		testResults.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Results"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		testResults.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane sp = new JScrollPane(testResults);
		trp.add(sp);
		return trp;
	}
	
	/**
	 * Create the drum number panel.
	 * 
	 * @return the number input field and label.d
	 */
	private JPanel createDrumNumberPanel() {
		drumPrompt = new JLabel("Number of drums to create ");
		drumPrompt.setToolTipText("The number of drums to create");
		numberToCreate = new JTextField(10);
		numberToCreate.setToolTipText("Enter the number of drums to create");
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		numberPanel.add(drumPrompt);
		numberPanel.add(numberToCreate);
		numberPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return numberPanel;
	}

	/**
	 * Create the drum button panel.
	 * 
	 * @return	The panel object containing the action buttons.
	 */
	/*
	 * TODO: retrieve the value of the "numberToCreate" and the drum type (radio button selection)
	 * 	and create the requested number of drums.
	 * 	Store a reference to each drum created in an ArrayList of drums.
	 * 	Add each drum created to the array list of drums. (do not reset the size of the array array values, rather add
	 * 	the new drums to the array list.
	 */
	private JPanel createButtonPanel() {
		createDrums = new JButton("Create Drums");
		createDrums.setToolTipText("Click me to create the specified number and type of drums to create");
		createDrums.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		        
		        testResults.setText("");  // Clear previous results

		        String inputText = numberToCreate.getText().trim();
		        if (inputText.isEmpty() || !inputText.matches("\\d+")) {
		            statusField.setText("Invalid number of drums!");
		            return;
		        }

		        int numDrums = Integer.parseInt(inputText);
		        if (numDrums <= 0) {
		            statusField.setText("Number must be greater than zero!");
		            return;
		        }

		        boolean isFlammableSelected = flammableDrumType.isSelected();
		        boolean isToxicSelected = toxicDrumType.isSelected();

		        if (!isFlammableSelected && !isToxicSelected) {
		            statusField.setText("Select a drum type!");
		            return;
		        }

		        // Create drums based on selection
		        if (isFlammableSelected) {
		            for (int i = 0; i < numDrums; i++) {
		                listOfDrums.add(new FlammableDrum(36, 24, "Petroleum", -43));
		            }
		        }
		        if (isToxicSelected) {
		            for (int i = 0; i < numDrums; i++) {
		                listOfDrums.add(new ToxicDrum(36, 24, "Radioactive", ToxicDrum.CLASS_IA));
		            }
		        }

		        // Display the created drum types in the result area
		        String message = "Creating [" + numDrums + "] ";
		        if (isFlammableSelected && isToxicSelected) {
		            message += "Flammable & Toxic Drums";
		        } else if (isFlammableSelected) {
		            message += "Flammable Drums";
		        } else if (isToxicSelected) {
		            message += "Toxic Drums";
		        }

		        testResults.append(message + "\n");
		        statusField.setText("Drums created!");
		    }
		});


				
		runTests = new JButton("Run Tests");
		runTests.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		        // Clear the previous results
		        testResults.setText("");

		        // Check if drums are created
		        if (listOfDrums.isEmpty()) {
		            testResults.append("No drums have been created yet.\n");
		            return;
		        }

		        // Append the number and type of drums created
		        int numDrums = listOfDrums.size();
		        String drumType;
		        if (flammableDrumType.isSelected()) {
		            drumType = "Flammable Drums";
		            testResults.append("Creating [" + numDrums + "] " + drumType + "\n");
		        } else {
		            drumType = "Toxic Drums";
		            testResults.append("Creating [" + numDrums + "] " + drumType + "\n");
		        }
		       

		        // Iterate through the list of drums and display their details
		        for (int i = 0; i < numDrums; i++) {
		            Drum drum = listOfDrums.get(i);
		           
		            testResults.append("[" + (i + 1) + "]: " + drum.getClass().getName() + ": " + drum.getClass().getSimpleName() + "\n");
		            testResults.append("::height: " + drum.getHeight() + " diameter: " + drum.getDiameter() +
		                " contents: " + drum.getContents() + "  Isotopes capacity: " + drum.calculateCapacity() 
		            );
		            if (drum instanceof FlammableDrum) {
		                testResults.append(":: Flashpoint: " + ((FlammableDrum) drum).getFlashpoint() + "°C\n");
		            } else if (drum instanceof ToxicDrum) {
		                testResults.append(":: Toxicity: " + ((ToxicDrum) drum).getToxicity() + "\n");
		            }
		            testResults.append("\n");
		        
		         	
		        }

		        // Set the status message
		        statusField.setText("Test results displayed.");
		    }
		});


		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		buttonPanel.add(createDrums);
		buttonPanel.add(runTests);
		
		buttonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Action"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return buttonPanel;
	}

	
	/**
	 * Create the drum creation panel.
	 * 
	 * @return JPanel containing radio buttons for selecting the drum type
	 */
	private JPanel createDrumTypePanel() {
		flammableDrumType = new JRadioButton("Flammable Drum");
		toxicDrumType = new JRadioButton("Toxic Drum");
		ButtonGroup group = new ButtonGroup();
		group.add(toxicDrumType);
		group.add(flammableDrumType);
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.add(flammableDrumType);
		typePanel.add(toxicDrumType);
		typePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Types of Drums"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		typePanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return typePanel;
	}

}
