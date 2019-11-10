package A8_5100.StudentInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SInfoSystemController implements ActionListener {
    private StudentInfoModel model;
    private JComponent[] components;
    private JFrame frame;

    public SInfoSystemController(JFrame frame, StudentInfoModel model, JComponent[] components) {
        this.frame = frame;
        this.model = model;
        this.components = components;
    }

    private boolean checkValue(String[] strings) {
        boolean r = true;
        String id = strings[0], name = strings[1], gender = strings[2], address = strings[3];
        if (id.length() != 9 || !id.matches("[0-9]+")) {
            this.showDialog("ID must be a string of 9 digits.");
            r = false;
        } else {
            for (int i = 0; i < this.model.getRowCount(); i++) {
                if (((String) this.model.getValueAt(i, 0)).equals(id)) {
                    this.showDialog("ID must be unique.");
                    r = false;
                    break;
                }
            }
        }
        if (name.length() <= 0) {
            this.showDialog("Name can not be empty.");
            r = false;
        }
        return r;
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(this.frame,
                message,
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] data = new String[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            if (components[i].getClass().equals(JTextField.class)) {
                data[i] = ((JTextField) components[i]).getText();
            } else {
                data[i] = (String) ((JComboBox) components[i]).getSelectedItem();
            }
        }

        if (this.checkValue(data)) {
            this.model.addRow(data);
            for (JComponent component : this.components) {
                if (component.getClass().equals(JTextField.class)) {
                    ((JTextField) component).setText("");
                } else {
                    ((JComboBox) component).setSelectedIndex(0);
                }
            }
        }
    }
}
