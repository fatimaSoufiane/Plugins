package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import modele.*;

public class CustomFrame extends JFrame implements PluginObserver {

	private static final long serialVersionUID = 1L;

	public static JFrame f;

	private JMenu jmTools;
	private Map<String, Plugin> pluginlist;

	CustomTextArea textArea;

	public CustomFrame() {
		super("Extendable Editor");
		f = this;

		// TOOLBAR
		JMenuBar jmBar = new JMenuBar();

		JMenu jmFile = new JMenu("File");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmiExit.setAccelerator(KeyStroke.getKeyStroke('Q', jmBar.getToolkit()
				.getMenuShortcutKeyMask(), false));
		jmiExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		jmFile.add(jmiExit);
		JMenuItem jmiUndo = new JMenuItem("Undo");
		jmiUndo.setAccelerator(KeyStroke.getKeyStroke('Z', jmBar.getToolkit()
				.getMenuShortcutKeyMask(), false));
		jmiUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.backToPreviousText();
			}
		});
		jmFile.add(jmiUndo);
		JMenu jmHelp = new JMenu("Help");
		JMenuItem jmihelp = new JMenuItem("About plugins");

		jmihelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel fla = new JPanel();
				fla.setLayout(new BoxLayout(fla, BoxLayout.PAGE_AXIS));
				for (String j : pluginlist.keySet()) {
					JLabel lab = new JLabel(pluginlist.get(j).getLabel());
					fla.add(lab);
					fla.add(new JLabel("   " + pluginlist.get(j).helpMessage()));
				}
				JOptionPane.showMessageDialog(f, fla);
			}
		});
		jmHelp.add(jmihelp);
		
		JMenuItem jmiabout = new JMenuItem("About us");

		jmiabout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String abu = "The Extendable Edit\n" +
						"Version 15.8.4\n" +
						"\n" +
						"Made by :\n" +
						"    SOUFIANE \n" +
						"    Oceane \n"+
						"\n" +
						"Sponsored by :\n" +
						"    Nintendo-Pokemon";
				JOptionPane.showMessageDialog(f, abu);
			}
		});
		jmHelp.add(jmiabout);

		jmTools = new JMenu("Tools");
		pluginlist = new HashMap<String, Plugin>();

		jmBar.add(jmFile);
		jmBar.add(jmTools);

		jmBar.add(jmHelp);
		setJMenuBar(jmBar);

		// /////////////////////
		ImageIcon picture = new ImageIcon("");
		JLabel lab = new JLabel(picture);
		JPanel jp = new JPanel();
		textArea = new CustomTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		JButton example = new JButton("Example");
		example.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.setRandomText();
			}
		});

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.clear();
			}
		});

		jp.add(lab);
		jp.add(scrollPane);
		jp.add(example);
		jp.add(reset);
		f.add(jp);

		// Main Frame configuration //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(300, 350));
		setLocationRelativeTo(null);
		setVisible(true);

		
	}

	/**
	 * Add the given plugin (file) to the plugin list.
	 * 
	 * @param f
	 *            file which is a plugin
	 */
	public void addPluginInList(File f) {

		final Plugin p;
		try {

			String classname = f.getName().replaceFirst("\\.class$", "");
			p = (Plugin) Class.forName("plugins." + classname).newInstance();

			JMenuItem jmi = new JMenuItem(p.getLabel());
			jmi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					textArea.updateTextArea(p);
				}
			});
			jmi.setToolTipText(p.helpMessage());
			pluginlist.put(p.getLabel(), p);
			jmTools.add(jmi);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Set<File> plugins) {
		for (File file : plugins) {
			try {
				final Plugin p;
				String classname = file.getName().replaceFirst("\\.class$", "");
				p = (Plugin) Class.forName("plugins." + classname).newInstance();

				JMenuItem jmi = new JMenuItem(p.getLabel());
				jmi.setToolTipText(p.helpMessage());
				pluginlist.put(p.getLabel(), p);
				jmTools.add(jmi);
				jmi.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textArea.updateTextArea(p);
					}
				});

			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		PluginFinder pluginFinder = new PluginFinder(new File("dropins"), new PluginFilter());
		pluginFinder.addObserver(new CustomFrame());
		pluginFinder.startToFindPlugins();		
	}

}
