/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.Segment;

/**
 *
 * @author My PC
 */
public class PrefixTextField extends JTextField {

    public PrefixTextField(String prefix) {
      setPrefix(prefix);
    }

    public void setPrefix(String prefix) {
      ((ExDocument) getDocument()).setPrefix(prefix);
    }

    @Override
    protected Document createDefaultModel() {
      return new ExDocument();
    }
  }

class ExDocument extends PlainDocument {
    private String prefix = "";

    @Override
    public String getText(int offset, int length) throws BadLocationException {
      StringBuilder text = new StringBuilder(super.getText(offset, length));
      if (offset == 0) {
        text.insert(0, prefix);
      }
      return text.toString();
    }

    @Override
    public void getText(int offset, int length, Segment txt) throws BadLocationException {
      super.getText(offset, length, txt);
      if (offset == 0) {
        StringBuilder text = new StringBuilder();
        text.append(prefix.toCharArray());
        text.append(txt.array);
        txt.array = text.toString().toCharArray();
        txt.count += prefix.length();
      }
    }

    public String getPrefix() {
      return prefix;
    }

    public void setPrefix(String prefix) {
      this.prefix = prefix;
      if (this.prefix == null) {
        this.prefix = "";
      }
      super.fireChangedUpdate(new DefaultDocumentEvent(0, getLength(),
          DocumentEvent.EventType.CHANGE));
    }
  }
