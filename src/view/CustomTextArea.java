package view;

import javax.swing.JTextArea;

import modele.Plugin;

public class CustomTextArea extends JTextArea {

	private static final long serialVersionUID = -5241332484345322791L;
	private String[] randomTexts;
	private String previousText;

	public CustomTextArea() {
		super(5, 20);
		randomTexts = new String[] { "Hello World", "This a an example",
				"Pikachu > all" };
	}

	public void updateTextArea(Plugin p) {
		previousText = getText();
		setText(p.transformString(previousText));
	}

	public void setRandomText() {
		int i = (int) (Math.random() * randomTexts.length);
		previousText = getText();
		setText(randomTexts[i]);
	}

	public void clear() {
		setText("");
	}

	public boolean backToPreviousText() {
		if (previousText == null)
			return false;
		setText(previousText);
		return true;
	}

}
