package view;

/** 
 * This class is the main window of  editor.
 * 
 * */
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

public class CustomFrame implements PluginObserver {

	protected JFrame jFrame;
	protected JMenuBar jMenuBar;
	protected JMenu jmTools;
	protected JPanel jPanel = new JPanel();
	protected Map<String, Plugin> pluginlist;
	protected CustomTextArea textArea;
	protected ImageIcon picture;

	public CustomFrame() {
		pluginlist = new HashMap<String, Plugin>();
		jFrame = new JFrame("Extendable Editor");
		jMenuBar = new JMenuBar();
		jFrame.setJMenuBar(jMenuBar);
		textArea = new CustomTextArea();
		picture = new ImageIcon("java.gif");

		addJmenuFile();

		jmTools = new JMenu("Tools");
		jMenuBar.add(jmTools);

		addJmenuHelp();

		addJPanel();

		// Main Frame configuration //
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(new Dimension(300, 350));
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);

	}

	protected void addJmenuFile() {
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmiExit.setAccelerator(KeyStroke.getKeyStroke('Q', jMenuBar.getToolkit().getMenuShortcutKeyMask(), false));
		jmiExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
			}
		});
		jmFile.add(jmiExit);
		JMenuItem jmiUndo = new JMenuItem("Undo");
		jmiUndo.setAccelerator(KeyStroke.getKeyStroke('Z', jMenuBar.getToolkit().getMenuShortcutKeyMask(), false));
		jmiUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea.backToPreviousText();
			}
		});
		jmFile.add(jmiUndo);
		jMenuBar.add(jmFile);
	}

	protected void addJmenuHelp() {
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
				JOptionPane.showMessageDialog(jFrame, fla);
			}
		});
		jmHelp.add(jmihelp);

		JMenuItem jmiabout = new JMenuItem("About us");

		jmiabout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String abu = "The Extendable Edit\n" + "Version 15.8.4\n" + "\n" + "Made by :\n" + "    SOUFIANE \n"
						+ "    LEGRAND\n" + "   RAHCIDE\n" + "Sponsored by :\n" + "    JavaProjet";
				JOptionPane.showMessageDialog(jFrame, abu);
			}
		});
		jmHelp.add(jmiabout);
		jMenuBar.add(jmHelp);
	}

	protected void addJPanel() {
		JLabel lab = new JLabel(picture);
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

		jPanel.add(lab);
		jPanel.add(scrollPane);
		jPanel.add(example);
		jPanel.add(reset);
		jFrame.add(jPanel);
	}

	/**
	 * update the given plugins (file) to the plugin list.
	 * 
	 * @param plugins
	 *            list of file which are plugins
	 */
	@Override
	public void update(Set<File> plugins) {
		jmTools.removeAll();
		pluginlist.clear();
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

	public static void main(String[] args) throws IOException {
		PluginFinder pluginFinder = new PluginFinder(new File("dropins"), new PluginFilter());
		pluginFinder.addObserver(new CustomFrame());
		pluginFinder.startToFindPlugins();
	}

}
