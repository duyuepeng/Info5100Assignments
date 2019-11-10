package A8_5100.StudentInfo;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import javax.jws.Oneway;
import javax.swing.*;
import java.awt.*;

import static A8_5100.StudentInfo.StudentInfoModel.GENDERS;
import static A8_5100.StudentInfo.StudentInfoModel.HEADERS;

public class SInfoSystemView extends JFrame {
    private StudentInfoModel model = new StudentInfoModel();
    private JTextField name = new JTextField(8);
    private JTextField address = new JTextField(10);
    private JTextField id = new JTextField(5);
    private JComboBox gender = new JComboBox(GENDERS);
    private SInfoSystemController controller;

    public SInfoSystemView(String title) throws HeadlessException {
        super(title);
        this.setLayout(new BorderLayout());
        JTable table = new JTable(this.model);
        JPanel addPanel = new JPanel();
        JComponent[] components = new JComponent[]{this.id, this.name, this.gender, this.address};
        controller = new SInfoSystemController(this, this.model, components);

        addPanel.setLayout(new FlowLayout());
        for (int i = 0; i < components.length; i++) {
            addPanel.add(new JLabel((String) HEADERS[i]));
            addPanel.add(components[i]);
            components[i].setSize(new Dimension(20, components[i].getHeight()));
        }

        JButton addButton = new JButton("Add");
        addPanel.add(addButton);
        addButton.addActionListener(controller);

        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        this.add(addPanel, BorderLayout.NORTH);
        this.add(tableScrollPane, BorderLayout.CENTER);
        this.pack();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            final SInfoSystemView sInfoSystem = new SInfoSystemView("Student Information System");
            sInfoSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sInfoSystem.setVisible(true);
        });
    }
}
