import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.awt.Font;

public class gui extends JFrame{

	private JFrame frame;
	String line;
	
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

		//Just Dance Label
		JLabel lblNewLabel = new JLabel("JUST DANCE 2019");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(123, 11, 193, 36);
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
