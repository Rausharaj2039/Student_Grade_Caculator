
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gradeGui extends JFrame {
    private JTextField englishField, hindiField, mathsField, socialField, scienceField;
    private JLabel totalLabel, percentageLabel, gradeLabel;

    public gradeGui() {
        setTitle("Grade Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Enter the marks of English:"));
        englishField = new JTextField();
        add(englishField);

        add(new JLabel("Enter the marks of Hindi:"));
        hindiField = new JTextField();
        add(hindiField);

        add(new JLabel("Enter the marks of Maths:"));
        mathsField = new JTextField();
        add(mathsField);

        add(new JLabel("Enter the marks of Social Science:"));
        socialField = new JTextField();
        add(socialField);

        add(new JLabel("Enter the marks of Science:"));
        scienceField = new JTextField();
        add(scienceField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });
        add(calculateButton);

        totalLabel = new JLabel("Total: ");
        add(totalLabel);

        percentageLabel = new JLabel("Total Percentage: ");
        add(percentageLabel);

        gradeLabel = new JLabel("Overall Grade: ");
        add(gradeLabel);
    }

    private void calculateGrades() {
        int en = Integer.parseInt(englishField.getText());
        int hn = Integer.parseInt(hindiField.getText());
        int mt = Integer.parseInt(mathsField.getText());
        int ss = Integer.parseInt(socialField.getText());
        int sci = Integer.parseInt(scienceField.getText());
        int sum = en + hn + mt + ss + sci;
        int percentage = sum / 5;
        char overallGrade = Grade(percentage);

        totalLabel.setText("Total: " + sum);
        percentageLabel.setText("Total Percentage: " + percentage + "%");
        gradeLabel.setText("Overall Grade: " + overallGrade);

        JOptionPane.showMessageDialog(this, createResultsString(en, hn, mt, ss, sci, sum, percentage, overallGrade), "Results", JOptionPane.INFORMATION_MESSAGE);
    }

    private String createResultsString(int en, int hn, int mt, int ss, int sci, int sum, int percentage, char overallGrade) {
        return "------------------------------------------------\n" +
                "|  Subject  |  Marks  |  percentage  |  Grade  |\n" +
                "------------------------------------------------\n" +
                "|  English  |  " + en + "     |    " + en + "%       |    " + Grade(en) + "    |\n" +
                "|  Hindi    |  " + hn + "     |    " + hn + "%       |    " + Grade(hn) + "    |\n" +
                "|  Maths    |  " + mt + "     |    " + mt + "%       |    " + Grade(mt) + "    |\n" +
                "|  Social   | " + ss + "      |    " + ss + "%       |    " + Grade(ss) + "    |\n" +
                "|  Science  |  " + sci + "     |    " + sci + "%       |    " + Grade(sci) + "    |\n" +
                "------------------------------------------------\n" +
                "     Total: " + sum + "    Total Percentage: " + percentage + "%\n" +
                "             Overall Grade: " + overallGrade + "\n" +
                "------------------------------------------------";
    }

    static char Grade(int num) {
        if (num > 90)
            return 'O';
        else if (num > 80)
            return 'A';
        else if (num > 70)
            return 'B';
        else if (num > 60)
            return 'C';
        else if (num > 50)
            return 'D';
        else if (num > 40)
            return 'F';
        else
            return 'E';
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gradeGui().setVisible(true);
            }
        });
    }
}