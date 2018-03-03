package L1_00;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private String title;
    private Dimension dimension;

    private JPanel panelLeft = new JPanel();
    private JPanel panelLeftOne = new JPanel(new GridBagLayout());
    private JPanel panelLeftTwo = new JPanel(new GridBagLayout());
    private JPanel panelLeftThree = new JPanel(new GridBagLayout());

    private JPanel panelRight = new JPanel();

    private JButton bulkSulutionButton = new JButton();
    private JButton massOfDryMatterButton = new JButton();

    private JLabel bulkSolutionLabel = new JLabel("Масса раствора");
    private JLabel percentageLabel = new JLabel("Процентное содержание");
    private JLabel massOfDryMatterLabel = new JLabel("Масса сухого вещества");

    private JTextField bulkSolutionTextField = new JTextField();
    private JTextField percentageTextField = new JTextField();
    private JTextField massOfDryMatterTextField = new JTextField();

    //JFrame frame = new JFrame("LabWork 1");
    public MyFrame(String title, Dimension dimension){
        this.title = title;
        this.dimension = dimension;
    }

    public void init() {
        setTitle(title);
        setSize(dimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new GridLayout(1, 2));
        setLayout(new GridBagLayout());

        setLocationRelativeTo(null); // расположение по середине экрана
        setResizable(false); // запрет развертывания
        setUndecorated(true); // убрать "шапку" с заголовком, крестиком, свернуть...

        //panelLeft.add(panelLeftOne);
        //panelLeft.add(panelLeftTwo);
        //panelLeft.add(panelLeftThree);

        panelRight.setLayout(new FlowLayout());
        panelLeft.setLayout(new GridLayout(3, 1));

        //add(panelLeft);
        //add(panelRight);

        bulkSulutionButton.setText("Узнать массу раствора");

        bulkSulutionButton.addActionListener(new bulkSulutionButtonActionListener());
        massOfDryMatterButton.addActionListener(new massOfDryMatterButtonActionListener());

        massOfDryMatterButton.setText(" Узнать массу сухого вещества");

        //panelRight.add(bulkSulutionButton);
        //panelRight.add(massOfDryMatterButton);

        bulkSolutionTextField.setEditable(true); // разрешение ввода(по умолчанию true)
        percentageTextField.setEditable(true); // разрешение ввода(по умолчанию true)
        massOfDryMatterTextField.setEditable(true); // разрешение ввода(по умолчанию true)

        panelLeftOne.add(bulkSolutionLabel, new GridBagConstraints(0, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 0), 0, 0));
        panelLeftOne.add(bulkSolutionTextField, new GridBagConstraints(1, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));

        panelLeftTwo.add(percentageLabel, new GridBagConstraints(0, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 0), 0, 0));
        panelLeftTwo.add(percentageTextField, new GridBagConstraints(1, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));

        panelLeftThree.add(massOfDryMatterLabel, new GridBagConstraints(0, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 0), 0, 0));
        panelLeftThree.add(massOfDryMatterTextField, new GridBagConstraints(1, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0));

        //////////////////////////

        add(panelLeftOne, new GridBagConstraints(0, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 0), 0, 0));
        add(panelLeftTwo, new GridBagConstraints(0, 1, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 0), 0, 0));
        add(panelLeftThree, new GridBagConstraints(0, 2, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 0), 0, 0));
        add(bulkSulutionButton, new GridBagConstraints(1, 0, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 15), 0, 0));
        add(massOfDryMatterButton, new GridBagConstraints(1, 1, 1, 1,
                1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 15, 5, 15), 0, 0));

        //////////////////////////
        setVisible(true);
    }

    public int isPositiveNumber(String str){
        if(str.length() == 0) return -1;

        int res = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') return -1;
            res *= 10;
            res += str.charAt(i) - '0';
        }
        return res;
    }

    public double isPositiveDoubleNumber(String str){
        if(str.length() == 0) return -1;
        int c = 1;
        double res = 0;
        boolean fl = true;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' || str.charAt(i) <= '9') {
                if (fl) {
                    res *= 10;
                    res += str.charAt(i) - '0';
                }
                else {
                    c /= 10;
                    res += (str.charAt(i) - '0') * c;
                }
            }
            else {
                if(str.charAt(i) == '.' || str.charAt(i) == ',') {
                    if(fl) fl = false;
                    else return -1; }
                else{
                    return -1;
                }
            }
        }
        return res;
    }

    // масса раствора
    public class bulkSulutionButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("bulkSulutionButtonActionListener");

            massOfDryMatterTextField.setBackground(Color.WHITE);
            percentageTextField.setBackground(Color.WHITE);
            bulkSolutionTextField.setBackground(Color.WHITE);

            int per = isPositiveNumber(percentageTextField.getText());
            int mas = isPositiveNumber(massOfDryMatterTextField.getText());
            boolean fl = true;
            if(per < 0 || per > 100) {
                fl = false;
                percentageTextField.setText("");
                percentageTextField.setBackground(Color.YELLOW);
            }
            if(mas < 0) {
                fl = false;
                massOfDryMatterTextField.setText("");
                massOfDryMatterTextField.setBackground(Color.YELLOW);
            }
            if(fl) {
                int res = (int)((double)mas* 100/ (double) per);
                bulkSolutionTextField.setText(String.valueOf(res));
            }
        }
    }

    // масса сухого вещества
    public class massOfDryMatterButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("massOfDryMatterButtonActionListener");

            massOfDryMatterTextField.setBackground(Color.WHITE);
            percentageTextField.setBackground(Color.WHITE);
            bulkSolutionTextField.setBackground(Color.WHITE);

            int per = isPositiveNumber(percentageTextField.getText());
            int mas = isPositiveNumber(bulkSolutionTextField.getText());
            boolean fl = true;
            if(per < 0 || per > 100) {
                fl = false;
                percentageTextField.setText("");
                percentageTextField.setBackground(Color.YELLOW);
            }
            if(mas < 0) {
                fl = false;
                bulkSolutionTextField.setText("");
                bulkSolutionTextField.setBackground(Color.YELLOW);
            }
            if(fl) {
                int res = (int)((double)mas/(double)100*(double)per);
                massOfDryMatterTextField.setText(String.valueOf(res));
            }
        }
    }
}
