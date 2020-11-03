package es.devone.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.jnlp.BasicService;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * 
 * @author luis.aguilar@devone.es
 *
 */
public class MyAppFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private transient BasicService basicService;
	private JButton button = new JButton("http://www.devone.es");

	private static final Logger LOG = Logger.getLogger(MyAppFrame.class.getName());

	public MyAppFrame(BasicService basicService) {
		this.basicService = basicService;
		init();
	}

	private void init() {
		setTitle("MyApp");
		ImageIcon favicon = getImage("favicon.png");
		if (favicon != null) {
			setIconImage(favicon.getImage());
		}
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container mainPanel = getContentPane();
		mainPanel.add(new JLabel(getImage("logo.png")), BorderLayout.CENTER);
		button.addActionListener(this);
		mainPanel.add(button, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	private ImageIcon getImage(String fileName) {
		try {
			return new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream(fileName)));
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == button) {
			try {
				URL url = new URL(event.getActionCommand());
				basicService.showDocument(url);
			} catch (MalformedURLException e) {
				LOG.severe(e.getMessage());
			}
		}
	}
}
