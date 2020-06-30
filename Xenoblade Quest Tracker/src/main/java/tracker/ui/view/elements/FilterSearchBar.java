package tracker.ui.view.elements;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class FilterSearchBar extends PlainDocument
{
	private final JPanel panel;
	private final String matching = "^.*[\\+\\*\\[\\]\\{\\}\\\\].*$";
	private final String notAllowed = "+ * [ ] { } \\";

	public FilterSearchBar(JPanel panel)
	{
		this.panel = panel;
	}

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
	{
		if (!str.matches(this.matching))
			super.insertString(offs, str, a);
		else
		{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this.panel, "These characters are not allowed: " + this.notAllowed, "Error: Illegal Character(s)", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException
	{
		if (!text.matches(this.matching))
			super.replace(offset, length, text, attrs);
		else
		{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this.panel, "These characters are not allowed: " + this.notAllowed, "Error: Illegal Character(s)", JOptionPane.ERROR_MESSAGE);
		}
	}
}