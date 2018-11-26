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
import javax.swing.JTextArea;
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
import javax.swing.SwingConstants;

public class gui extends JFrame {

	private JFrame frmJustDanceAutomatipon;
	String line;

	private Label headerLabel;
	private Panel controlPanel;
	JTextArea textAreaoutput;
	String nl = "\n";

	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem, menuItem1;
		// Create the menu bar.
		menuBar = new JMenuBar();

		// File menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);

		// quit sub
		menuItem = new JMenuItem("Quit", KeyEvent.VK_T);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu.add(menuItem);

		// Help menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
		menuBar.add(menu);

		// help sub
		menuItem1 = new JMenuItem("About", KeyEvent.VK_T);
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog aboutDialog = new AboutDialog(frmJustDanceAutomatipon);
				aboutDialog.setVisible(true);
			}
		});
		menuItem1.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menu.add(menuItem1);

		return menuBar;
	}

	// show dialog box
	private void showDialogDemo() {

		// controlPanel.add(showAboutDialogButton);
		frmJustDanceAutomatipon.setVisible(true);
	}

	// About dialog box
	class AboutDialog extends Dialog {
		public AboutDialog(Frame parent) {
			super(parent, true);
			setBackground(Color.gray);
			setLayout(new BorderLayout());
			Panel panel = new Panel();
			panel.add(new Button("Close"));
			add("South", panel);
			// setSize(500,200);
			setBounds(500, 300, 500, 200);
			setTitle("About");

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent) {
					dispose();
				}
			});
		}

		public boolean action(Event evt, Object arg) {
			if (arg.equals("Close")) {
				dispose();
				return true;
			}
			return false;
		}

		public void paint(Graphics g) {
			g.setColor(Color.white);
			g.drawString("Just Dance Automation Kit v1.0", 170, 70);
			g.drawString("This is created for Just Dance to automate stuff", 40, 110);
			g.drawString("you are tired of doing, doing, doing! ;)", 40, 130);
			g.drawString("For suggestions and ideas, please contact me at aniket.katkar@ubisoft.com ", 40, 150);
		}
	}

	// adb detection method
	public void check_adb() {
		String cmd = "adb devices";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(cmd);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
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
					window.frmJustDanceAutomatipon.setVisible(true);
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
		frmJustDanceAutomatipon = new JFrame("Just Dance Testing Kit");
		frmJustDanceAutomatipon.setTitle("JDMCA Automation Kit - Nascent ");
		frmJustDanceAutomatipon.setIconImage(getFDImage());
		frmJustDanceAutomatipon.setResizable(false);
		frmJustDanceAutomatipon.setBounds(500, 300, 450, 400);
		frmJustDanceAutomatipon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJustDanceAutomatipon.getContentPane().setLayout(null);

		// gui demo = new gui();
		frmJustDanceAutomatipon.setJMenuBar(createMenuBar());

		// dialogbox
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		frmJustDanceAutomatipon.getContentPane().add(headerLabel);
		frmJustDanceAutomatipon.getContentPane().add(controlPanel);
		frmJustDanceAutomatipon.setVisible(true);

		// Just Dance Label
		JLabel lblNewLabel = new JLabel("JUST DANCE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UbisoftTitleTwo Bold", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(126, 23, 191, 36);
		frmJustDanceAutomatipon.getContentPane().add(lblNewLabel);

		// verifying adb label
		JLabel verify_adb = new JLabel("");
		verify_adb.setForeground(new Color(0, 102, 0));
		verify_adb.setBounds(188, 58, 77, 14);
		verify_adb.setText(line);
		frmJustDanceAutomatipon.getContentPane().add(verify_adb);

		// FTUE
		Button button = new Button("Complete FTUE");
		button.setBackground(new Color(153, 204, 255));
		button.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t1 = new Thread(new Runnable() {

					@Override
					public void run() {
						check_adb();
						ftue();
					}
				});
				t1.start();
			}
		});
		button.setBounds(50, 90, 155, 46);
		frmJustDanceAutomatipon.getContentPane().add(button);

		// Gift Machine
		Button button_1 = new Button("Unlock Level 200");
		button_1.setBackground(new Color(153, 204, 255));
		button_1.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t1 = new Thread(new Runnable() {

					@Override
					public void run() {
						// check_adb();
						System.out.print("came here");
						unlock_level_200();
					}
				});
				t1.start();
			}
		});
		button_1.setBounds(50, 166, 155, 46);
		frmJustDanceAutomatipon.getContentPane().add(button_1);

		// Level 200
		Button button_2 = new Button("Unlock Gift Machine");
		button_2.setBackground(new Color(153, 204, 255));
		button_2.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t1 = new Thread(new Runnable() {

					@Override
					public void run() {
						check_adb();
						gift_machine();
					}
				});
				t1.start();
			}
		});
		button_2.setBounds(239, 90, 155, 46);
		frmJustDanceAutomatipon.getContentPane().add(button_2);

		// Stop
		Button button_3 = new Button("Stop Test");
		button_3.setBackground(new Color(153, 204, 255));
		button_3.setFont(new Font("Alien Encounters", Font.BOLD, 14));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t1 = new Thread(new Runnable() {

					@Override
					public void run() {
						// check_adb();
						stop();
					}
				});
				t1.start();
			}
		});
		button_3.setBounds(239, 166, 155, 46);
		frmJustDanceAutomatipon.getContentPane().add(button_3);

		check_adb();

		textAreaoutput = new JTextArea();
		textAreaoutput.setEditable(false);
		textAreaoutput.setBounds(51, 243, 343, 96);
		textAreaoutput.setAutoscrolls(true);
		frmJustDanceAutomatipon.getContentPane().add(textAreaoutput);
	}

	// Returns an Image or null.
	protected static Image getFDImage() {
		java.net.URL imgURL = gui.class.getResource("logo.png");
		if (imgURL != null) {
			return new ImageIcon(imgURL).getImage();
		} else {
			return null;
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Directions//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// move up
	public void up() {
		String up = "adb shell input swipe 560 1525 540 880";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(up);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// move down
	public void down() {
		String down = "adb shell input swipe 540 880 560 1525";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(down);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// move right
	public void right() {
		String right = "adb shell input swipe 247 1220 907 1176";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(right);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// move left
	public void left() {
		String left = "adb shell input swipe 907 1176 247 1220";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(left);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// touch
	public void touch() {
		String touch = "adb shell input tap 532 1260";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(touch);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key 1
	public void key1() {
		String key1 = "adb shell input swipe 907 1176 247 1220";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key1);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key 2
	public void key2() {
		String key2 = "adb shell input tap 544 333";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key2);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key 3
	public void key3() {
		String key3 = "adb shell input swipe 907 1176 247 1220";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key for q
	public void q() {
		String key3 = "adb shell input tap 45 1290";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key for p
	public void p() {
		String key3 = "adb shell input tap 1015 1280";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key for okay 1
	public void okay1() {
		String key3 = "adb shell input tap 1015 820";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// key for ok 2
	public void okay2() {
		String key3 = "adb shell input tap 920 965";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep1
	public void sleep1() {
		String key3 = "adb shell sleep 1";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep2
	public void sleep2() {
		String key3 = "adb shell sleep 2";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep3
	public void sleep3() {
		String key3 = "adb shell sleep 3";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep4
	public void sleep4() {
		String key3 = "adb shell sleep 4";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep5
	public void sleep5() {
		String key3 = "adb shell sleep 5";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep6
	public void sleep6() {
		String key3 = "adb shell sleep 6";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep7
	public void sleep7() {
		String key3 = "adb shell sleep 7";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep8
	public void sleep8() {
		String key3 = "adb shell sleep 8";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep9
	public void sleep9() {
		String key3 = "adb shell sleep 9";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep10
	public void sleep10() {
		String key3 = "adb shell sleep 10";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sleep120
	public void sleep120() {
		String key3 = "adb shell sleep 120";
		try {
			Runtime run = Runtime.getRuntime();
			Process pr = run.exec(key3);

			pr.waitFor();

			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Main Functions//
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void ftue() {
		// tap to continue
		// touch();
		// sleep1();

		// avatar selection page
		// right();
		// right();
		// touch();
		// sleep1();

		// flag
		// touch();
		// sleep7();

		// mode selection page
		textAreaoutput.setText("FTUE started");
		touch();
		sleep8();
		// tutorial
		touch();
		sleep6();

		// onboarding 1
		touch();
		sleep1();

		// songstab
		right();
		sleep1();
		right();
		sleep1();
		right();
		sleep1();
		down();
		sleep1();

		// printf( \n"dance to poco loco (1st time)");
		touch();
		sleep4();

		// continue
		touch();
		sleep4();

		// dance
		touch();
		sleep10();
		sleep5();

		// tutorial (got it)
		touch();
		sleep120();
		sleep10();
		sleep10();
		textAreaoutput.setText("First song ended.");

		// score recap
		touch();
		sleep8();
		sleep2();

		// gender skip
		right();
		sleep1();
		touch();
		// key2();
		sleep4();

		// age skip
		right();
		sleep1();
		touch();
		// key2();
		sleep4();

		// nickname
		touch();
		sleep4();

		// name giving q
		q();
		sleep1();

		// okay1
		okay1();
		sleep1();

		// okay2
		okay2();
		sleep1();

		// avatar
		touch();
		sleep5();
		touch();
		sleep5();

		// title
		touch();
		sleep3();
		touch();
		sleep5();

		// save n quit
		touch();
		sleep7();
		sleep2();
		textAreaoutput.setText("Dancer card created.");

		// second dnace poco loco

		// dance poco loco
		touch();
		sleep5();

		// dance
		touch();
		sleep120();
		sleep10();
		sleep10();
		textAreaoutput.setText("Second song ended.");

		// score recap
		touch();
		sleep8();
		sleep2();

		// continue (my mojo)
		touch();
		sleep10();
		sleep4();

		// continue (my level)
		touch();
		sleep4();

		// continue (my challenges)
		touch();
		sleep5();

		// gift machine
		touch();
		sleep10();

		// continue (gift received)
		touch();
		sleep4();

		// continue (gift mahine again)
		touch();
		sleep5();
		sleep4();

		// autodance
		touch();
		sleep9();

		// onboarading2
		touch();
		sleep4();

		// songstab
		left();
		sleep1();
		left();
		sleep1();
		left();
		sleep1();
		left();
		sleep1();
		left();
		sleep1();

		// songstab to search
		down();
		sleep1();

		// search to songstab
		up();
		sleep1();

		// in songstab
		right();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		// sleep1();
		// right();
		sleep3();

		// launch poco loco (3rd time)

		// dance
		touch();
		sleep6();

		// dance
		touch();
		sleep120();
		sleep10();
		sleep10();
		textAreaoutput.setText("Third song ended");

		// score recap
		touch();
		sleep10();
		sleep2();
		sleep2();

		// my challenges
		touch();
		sleep5();

		// auto dance
		touch();
		sleep8();

		// songstab
		left();
		sleep1();

		// goto search
		down();
		sleep1();

		// go to songstab
		up();
		sleep1();

		// in songstab
		right();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		// sleep1();
		// right();
		sleep3();

		// launch poco loco (4th time)

		// dance
		touch();
		sleep5();

		// dance
		touch();
		sleep120();
		sleep10();
		sleep10();
		textAreaoutput.setText("Fourth song ended.");

		// score recap
		touch();
		sleep10();
		sleep10();
		sleep2();

		// my challenges
		touch();
		sleep10();

		// gift machine
		right();
		sleep2();
		touch();
		sleep5();

		// autodance
		touch();
		sleep9();

		// onboarding
		touch();
		sleep1();

		// home tan
		left();
		sleep1();

		// go to songstab
		down();
		sleep1();
		down();
		sleep1();

		// in songstab
		right();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		sleep1();
		down();
		// sleep1();
		// right();
		sleep3();

		// launch poco loco (5th time)

		// dance
		touch();
		sleep5();

		// dance
		touch();
		sleep120();
		sleep10();
		sleep10();
		textAreaoutput.setText("Fifth song ended.");

		// score recap
		touch();
		sleep10();
		sleep10();
		sleep2();

		// my challenges
		touch();
		sleep5();

		// autodance
		touch();
		sleep8();

		// onboarding
		touch();
		sleep2();
		textAreaoutput.setText("FTUE ended.");
	}

	public void gift_machine() {
		for (int i = 0; i < 700; i++) {
			touch();
			sleep5();
		}
	}

	public void unlock_level_200() {
		textAreaoutput.setText("Started playing till Level 200..." + nl);
		for (int i = 0; i < 15000; i++) {
			touch();
			sleep5();
		}
		textAreaoutput.setText("Level 200 completed." + nl);
	}

	public void stop() {
		textAreaoutput.setText("Closing Application...");
		sleep3();
		System.exit(1);
	}
}

//make methods for swipe up, swipe down touch and tap. simple af
