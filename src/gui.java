import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import menu.AboutDialog;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.awt.Font;
import java.awt.Frame;

public class gui extends JFrame{

	private JFrame frame;
	String line;
	
	//dialog box
	private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
	
	public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem, menuItem1;
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //File menu
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
 
        //quit sub
        menuItem = new JMenuItem("Quit",
                                 KeyEvent.VK_T);
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
 
        //Help menu
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);
        
        //help sub
        menuItem1 = new JMenuItem("About",
                                 KeyEvent.VK_T);
        menuItem1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AboutDialog aboutDialog = new AboutDialog(mainFrame);
	            aboutDialog.setVisible(true);
        	}
        });
        menuItem1.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem1);
 
        return menuBar;
    }
	
	//show dialog box
	private void showDialogDemo(){
	      
	      //controlPanel.add(showAboutDialogButton);
	      frame.setVisible(true);  
	   }
	
	//About dialog box
	class AboutDialog extends Dialog {
	      public AboutDialog(Frame parent){
	         super(parent, true);         
	         setBackground(Color.gray);
	         setLayout(new BorderLayout());
	         Panel panel = new Panel();
	         panel.add(new Button("Close"));
	         add("South", panel);
	         setSize(500,200);

	         addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent windowEvent){
	               dispose();
	            }
	         });
	      }

	      public boolean action(Event evt, Object arg){
	         if(arg.equals("Close")){
	            dispose();
	            return true;
	         }
	         return false;
	      }

	      public void paint(Graphics g){
	         g.setColor(Color.white);
	         g.drawString("Just Dance Automation Kit v1.0", 170,70 );
	         g.drawString("This is created for Just Dance to", 60, 110); 
	         g.drawString("automate stuff you are tired of doing, doing, doing! ;)", 60, 130);      
	         g.drawString("For suggestions and ideas, please contact me at aniket.katkar@ubisoft.com ", 60,150);
	      }
	   }
	
	//adb detection method
		public void check_adb() {
			String cmd = "adb devices";
			try {
				Runtime run = Runtime.getRuntime();
				Process pr = run.exec(cmd);
		
				pr.waitFor();
		
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				while ((line=buf.readLine())!=null) {
				System.out.println(line);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
					window.showDialogDemo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	    
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Just Dance Testing Kit");
		frame.setIconImage(getFDImage());
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//gui demo = new gui();
		frame.setJMenuBar(createMenuBar());
		
		//dialogbox
		headerLabel = new Label();
	      headerLabel.setAlignment(Label.CENTER);
	      //statusLabel = new Label();        
	      //statusLabel.setEnabled(false);
	      //statusLabel.setAlignment(Label.CENTER);
	      //statusLabel.setSize(350,100);

	      controlPanel = new Panel();
	      controlPanel.setLayout(new FlowLayout());

	      frame.getContentPane().add(headerLabel);
	      frame.getContentPane().add(controlPanel);
	      //frame.getContentPane().add(statusLabel);
	      frame.setVisible(true);  

		//Just Dance Label
		JLabel lblNewLabel = new JLabel("JUST DANCE");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(154, 21, 142, 36);
		frame.getContentPane().add(lblNewLabel);
		
		//verifying adb label
		JLabel verify_adb = new JLabel("");
		verify_adb.setForeground(new Color(0, 102, 0));
		verify_adb.setBounds(188, 58, 77, 14);
		verify_adb.setText(line);
		frame.getContentPane().add(verify_adb);
		
		//FTUE
		Button button = new Button("Complete FTUE");
		button.setBackground(new Color(153, 204, 255));
		button.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				check_adb();
				ftue();
			}
		});
		button.setBounds(50, 90, 147, 46);
		frame.getContentPane().add(button);
		
		//Gift Machine
		Button button_1 = new Button("Unlock Level 200");
		button_1.setBackground(new Color(153, 204, 255));
		button_1.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				check_adb();
				gift_machine();
			}
		});
		button_1.setBounds(50, 166, 147, 46);
		frame.getContentPane().add(button_1);
		
		//Level 200
		Button button_2 = new Button("Unlock Gift Machine");
		button_2.setBackground(new Color(153, 204, 255));
		button_2.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				check_adb();
				unlock_level_200();
			}
		});
		button_2.setBounds(247, 90, 147, 46);
		frame.getContentPane().add(button_2);
		
		//Smoke
		Button button_3 = new Button("Smoke Test");
		button_3.setBackground(new Color(153, 204, 255));
		button_3.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				check_adb();
				smoke();
			}
		});
		button_3.setBounds(247, 166, 147, 46);
		frame.getContentPane().add(button_3);
		
		check_adb();
	}
	
	

    //Returns an Image or null.
    protected static Image getFDImage() {
        java.net.URL imgURL = gui.class.getResource("logo.png");
        if (imgURL != null) {
            return new ImageIcon(imgURL).getImage();
        } else {
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    															//Directions//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  //move up
  	public void up() {
  		String up = "adb shell swipe 560 1525 540 880";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(up);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  //move down
  	public void down() {
  		String down = "adb shell swipe 540 880 560 1525";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(down);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  //move right
  	public void right() {
  		String right = "adb shell swipe 247 1220 907 1176";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(right);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  //move left
  	public void left() {
  		String left = "adb shell swipe 907 1176 247 1220";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(left);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  // touch
  	public void up() {
  		String touch = "adb shell tap 532 1260";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(touch);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  //key 1
  	public void key1() {
  		String key1 = "adb shell swipe 907 1176 247 1220";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(key1);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  //key 2
  	public void key2() {
  		String key2 = "adb shell swipe 907 1176 247 1220";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(key2);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  //key 3
  	public void key3() {
  		String key3 = "adb shell swipe 907 1176 247 1220";
  		try {
  			Runtime run = Runtime.getRuntime();
  			Process pr = run.exec(key3);
  	
  			pr.waitFor();
  	
  			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
  			while ((line=buf.readLine())!=null) {
  			System.out.println(line);
  		}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  												//Main Functions//
  	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	public void ftue() {
  		
  	}
  	
	public void gift_machine() {
	  		
	}
	
	public void unlock_level_200() {
  		
  	}

	public void smoke() {
		
	}
}


//make methods for swipe up, swipe down touch and tap. simple af
