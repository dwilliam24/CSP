import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calc extends JFrame {
    private JLabel CalculatorLBL = new JLabel("Enter a number:");
    private JTextField textEntry = new JTextField();

    private JButton sine = new JButton("sin(x)");
    private JButton cosine = new JButton("cos(x)");
    private JButton tangent = new JButton("tan(x)");
    private JButton factorial = new JButton("!x");
    private JButton square = new JButton("x²");
    private JButton squareRoot = new JButton("√x");
    private JButton arcSine = new JButton("arcsin(x)");
    private JButton arcCosine = new JButton("arccos(x)");
    private JButton arcTangent = new JButton("arctan(x)");
    private JButton log = new JButton("log(x)");
    private JButton E = new JButton("e^x");
    private JButton naturalLog = new JButton("ln(x)");

    private JButton clear = new JButton("clear");

    private ArrayList<String> history = new ArrayList<>();

    private DefaultListModel<String> historyModel = new DefaultListModel<>();
    private JList<String> historyList = new JList<>(historyModel);

    public Calc(){
        super("Calculator");
        setSize(400,450);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CalculatorLBL.setBounds(140,40,90,30);
        add(CalculatorLBL);

        textEntry.setBounds(105,70,160,30);
        textEntry.setHorizontalAlignment(SwingConstants.CENTER);
        add(textEntry);

        sine.setBounds(40,120,90,30);
        sine.addActionListener(e -> sineClicked());
        add(sine);

        cosine.setBounds(140,120,90,30);
        cosine.addActionListener(e-> cosineClicked());
        add(cosine);

        tangent.setBounds(240,120,90,30);
        tangent.addActionListener(e->tangentClicked());
        add(tangent);

        factorial.setBounds(40,160,90,30);
        factorial.addActionListener(e-> factorialClicked());
        add(factorial);

        square.setBounds(140,160,90,30);
        square.addActionListener(e-> squareClicked());
        add(square);

        squareRoot.setBounds(240,160,90,30);
        squareRoot.addActionListener(e -> sqrtClicked());
        add(squareRoot);

        arcSine.setBounds(40,200,90,30);
        arcSine.addActionListener(e-> arcSineClicked());
        add(arcSine);

        arcCosine.setBounds(140,200,90,30);
        arcCosine.addActionListener(e-> arcCosineClicked());
        add(arcCosine);

        arcTangent.setBounds(240,200,90,30);
        arcTangent.addActionListener(e-> arcTangentClicked());
        add(arcTangent);

        log.setBounds(40,240,90,30);
        log.addActionListener(e -> logClicked());
        add(log);

        E.setBounds(140,240,90,30);
        E.addActionListener(e-> EClicked());
        add(E);

        naturalLog.setBounds(240,240,90,30);
        naturalLog.addActionListener(e-> naturalLogClicked());
        add(naturalLog);

        clear.setBounds(140, 280, 90, 30);
        clear.addActionListener(e->clearClicked());
        add(clear);

        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setBounds(40, 320, 290, 80);
        add(scrollPane);

        setVisible(true);
    }

    //adds a calculation to the history arraylist
    private void addToHistory(String operation, double result) {
        String entry = operation + " = " + result;

        history.add(entry);

        if (history.size() > 10) {
            history.remove(0);
        }

        updateHistoryDisplay();
    }

    private void updateHistoryDisplay() {
        historyModel.clear();

        for (String item : history) {
            historyModel.addElement(item);
        }
    }

    //clears the textbox
    private void clearClicked() {
        textEntry.setText("");
    }

    //sets the textbox to the natural log of x
    private void naturalLogClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.log(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("ln(" + input + ")", result);
    }

    //sets the textbox to e to the power of x
    private void EClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.pow(Math.E, input);
        textEntry.setText(String.valueOf(result));
        addToHistory("e^(" + input + ")", result);
    }

    //sets the textbox to the arc tangent of x
    private void arcTangentClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.atan(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("atan(" + input + ")", result);
    }

    //sets the textbox to the arc cosine of x
    private void arcCosineClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.acos(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("acos(" + input + ")", result);
    }

    //sets the textbox to the arc sine of x
    private void arcSineClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.asin(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("asin(" + input + ")", result);
    }

    //sets the textbox to the log10 of x
    private void logClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.log10(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("log(" + input + ")", result);
    }

    //sets textbox to the square root of x
    private void sqrtClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.sqrt(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("√(" + input + ")", result);
    }

    //sets the textbox to the square of x
    private void squareClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.pow(input,2);
        textEntry.setText(String.valueOf(result));
        addToHistory(input + "^2", result);
    }

    //sets textbox to the factorial of x
    private void factorialClicked() {
        if (textEntry.getText().isEmpty()) return;
        long input = Long.parseLong(textEntry.getText());
        long result = factorialMeth(input);
        textEntry.setText(String.valueOf(result));
        addToHistory(input + "!", result);
    }

    //sets textbox to tan(x) in radians
    private void tangentClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.tan(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("tan(" + input + ")", result);
    }

    //sets textbox to the cos(x) in radians
    private void cosineClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.cos(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("cos(" + input + ")", result);
    }

    //sets textbox to the sin(x) in radians
    private void sineClicked() {
        if (textEntry.getText().isEmpty()) return;
        double input = Double.parseDouble(textEntry.getText());
        double result = Math.sin(input);
        textEntry.setText(String.valueOf(result));
        addToHistory("sin(" + input + ")", result);
    }

    //returns factorial of an input
    private long factorialMeth(long number){
        if (number == 0) return 1;

        long result = 1;
        for (long i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}