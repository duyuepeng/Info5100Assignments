package A8_5100.StudentInfo;

import javax.swing.table.DefaultTableModel;

public class StudentInfoModel extends DefaultTableModel {
    public static final Object[] HEADERS = {"ID", "Name", "Gender", "Address"};
    public static final Object[] GENDERS = {"Male", "Female", "Other"};

    public StudentInfoModel(){
        super(null,HEADERS);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
