import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;


public class myBrowser extends JFrame {
	private JCheckBox editable;
	private JPanel contentPane;
	private JTextField texturl;
	private JButton btnback;
	private JButton btnforward;
	private Stack urlStack = new Stack();
	private Stack urlStack2 = new Stack();
	private StringBuilder hist= new StringBuilder();

	//private JEditorPane myPane;
	private JLabel lblEditable;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					myBrowser frame = new myBrowser();
					frame.setVisible(true);
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public myBrowser() {
		

		
		
		setBackground(new Color(0, 153, 153));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Eclipse\\p\\src\\resources\\web-icon (1).png"));
		setForeground(new Color(47, 79, 79));
		setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		setTitle("My Browser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setForeground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUrl.setBounds(287, 11, 39, 14);
		contentPane.add(lblUrl);
		
		texturl = new JTextField();
		texturl.setBounds(323, 8, 239, 20);
		contentPane.add(texturl);
		texturl.setColumns(10);
		
		JButton btnload = new JButton("GO");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					urlStack.push(texturl.getText());  // for back button
					editorPane.setPage(texturl.getText());
					urlStack2.push(texturl.getText());
					hist.append(texturl.getText()+"\n");
					hist.append("<br>");
					}
					catch(Exception e)
					{
						editorPane.setText("Error: " +e);
					}
				
				
			}
		});
		btnload.setBackground(UIManager.getColor("activeCaption"));
		btnload.setForeground(new Color(51, 0, 102));
		btnload.setBounds(570, 9, 74, 23);
		contentPane.add(btnload);
	   // Icon back icon = new ImageIcon("button-round-arrow-left-icon.png");
		ImageIcon icon = new ImageIcon("resources\\button-round-arrow-left-icon.png",
               "a pretty but meaningless splat");
	    
		btnback = new JButton(icon);
		btnback.setBorder(null);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(urlStack.size()<=1) return;
				try
				{
				urlStack2.push(texturl.getText());
				urlStack.pop();
				String urlString = (String)urlStack.peek();
				texturl.setText(urlString);
				editorPane.setPage(urlString);
				
				}
				catch(IOException e2)
				{
					editorPane.setText("Error : " +e2);
				}
				
			}
		});
		btnback.setSelectedIcon(new ImageIcon("E:\\Eclipse\\p\\src\\resources\\web-icon (1).png"));
			/* try {
			    Image img = ImageIO.read(getClass().getResource("resources/button-round-arrow-left-icon.png"));
			    btnback.setIcon(new ImageIcon("E:\\Eclipse\\p\\src\\resources\\web-icon (2).png"));
			  } catch (Exception ex) {
			    System.out.println(ex);
			    System.out.println("fsdghjk");
			  }*/
		btnback.setForeground(new Color(0, 128, 128));
		btnback.setBackground(new Color(0, 153, 153));
		btnback.setIcon(new ImageIcon("E:\\Eclipse\\p\\src\\resources\\back-icon (1).png"));
		btnback.setBounds(10, 6, 39, 26);
		contentPane.add(btnback);
		
		btnforward = new JButton("");
		btnforward.setBorder(null);
		btnforward.setBackground(new Color(0, 153, 153));
		btnforward.setForeground(new Color(0, 128, 128));
		btnforward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(urlStack2.size()<=1) return;
				try
				{urlStack.push(texturl.getText());
				urlStack2.pop();
				
				String urlString = (String)urlStack2.peek();
				
				texturl.setText(urlString);
				editorPane.setPage(urlString);
			
				}
				catch(IOException e2)
				{
					editorPane.setText("Error : " +e2);
				}
			}
		});
		btnforward.setIcon(new ImageIcon("E:\\Eclipse\\p\\src\\resources\\forward-icon.png"));
		btnforward.setBounds(59, 6, 44, 26);
		contentPane.add(btnforward);
	/*	
		myPane = new JEditorPane();
		myPane.setDoubleBuffered(true);
		myPane.setBorder(null);
		myPane.setDragEnabled(true);
		myPane.setDropMode(DropMode.INSERT);
		myPane.setEditable(false);
		myPane.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent event) {
				
				
				if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
				{
				try
				{
				urlStack.push(event.getURL().toString());
				texturl.setText(event.getURL().toString());
				myPane.setPage(event.getURL());
				}
				catch(IOException e)
				{
				myPane.setText("Error: " + e);
				}
				
				}
			}
		});
		myPane.setBounds(0, 75, 5000, 5000);
		contentPane.add(myPane);
	*/
		lblEditable = new JLabel(" editable");
		lblEditable.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEditable.setBounds(162, 13, 66, 14);
		contentPane.add(lblEditable);
		
		 editable = new JCheckBox("");
		 editable.setBackground(new Color(0, 153, 153));
		 editable.setSelected(true);
		editable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editorPane.setEditable(editable.isSelected());
				
			}
		});
		editable.setBounds(215, 11, 39, 23);
		contentPane.add(editable);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(31, 50, 1307, 640);
		contentPane.add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				

				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
				{
				try
				{
				//urlStack.push(e.getURL().toString());
				//urlStack2.push(e.getURL().toString());
				texturl.setText(e.getURL().toString());
				editorPane.setPage(e.getURL());
				urlStack.push(texturl.getText());
				urlStack2.push(texturl.getText());
				hist.append(texturl.getText()+"\n");
				hist.append("<br>");
				}
				catch(IOException e3)
				{
					editorPane.setText("Error: " + e3);
				}
				
				}
				
			}
		});
		scrollPane.setViewportView(editorPane);
		
		JButton btnhome = new JButton("");
		btnhome.setBorder(null);
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String urlhome="https://www.google.com";
				texturl.setText(urlhome);
				
				// LocalDateTime now = LocalDateTime.now();
			        //System.out.println(dtf.format(now));
				hist.append(texturl.getText()+"\n");
				hist.append("<br>");

				try {
					editorPane.setPage(urlhome);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnhome.setForeground(new Color(0, 128, 128));
		btnhome.setBackground(new Color(0, 153, 153));
		btnhome.setIcon(new ImageIcon("E:\\Eclipse\\p\\src\\resources\\blue-home-icon.png"));
		btnhome.setBounds(108, 6, 44, 26);
		contentPane.add(btnhome);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				editorPane.setText(hist.toString());
				texturl.setText("History :/");
				
			}
		});
		button.setBackground(new Color(0, 153, 153));
		button.setForeground(new Color(0, 153, 153));
		button.setIcon(new ImageIcon("E:\\Eclipse\\p\\src\\resources\\folder-url-history-icon.png"));
		button.setBounds(702, 8, 39, 23);
		contentPane.add(button);
		

		
	}
}
