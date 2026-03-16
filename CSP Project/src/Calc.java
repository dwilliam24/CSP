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
    //initializes the class and sets up the window
    public Calc(){
        super("Calculator");
        setSize(400,400);
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

        setVisible(true);
    }
    //clears the textbox
    private void clearClicked() {
        textEntry.setText("");
    }
    //sets the textbox to the natural log of x
    private void naturalLogClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.log(Double.parseDouble(textEntry.getText()))));
    }
    //sets the textbox to e to the power of x
    private void EClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.pow(Math.E,Double.parseDouble(textEntry.getText()))));
    }
    //sets the textbox to the arc tangent of x
    private void arcTangentClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.atan(Double.parseDouble(textEntry.getText()))));
    }
    //sets the textbox to the arc cosine of x
    private void arcCosineClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.acos(Double.parseDouble(textEntry.getText()))));
    }
    //sets the textbox to the arc sine of x
    private void arcSineClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.asin(Double.parseDouble(textEntry.getText()))));
    }
    //sets the textbox to the log10 of x
    private void logClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.log10(Double.parseDouble(textEntry.getText()))));
    }
    //sets textbox to the square root of x
    private void sqrtClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.sqrt(Double.parseDouble(textEntry.getText()))));
    }
    //sets the textbox to the square of x
    private void squareClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.pow(Double.parseDouble(textEntry.getText()),2)));
    }
    //sets textbox to the factorial of x
    private void factorialClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(factorialMeth(Long.parseLong(textEntry.getText()))));
    }
    //sets textbox to tan sin(x) in radians
    private void tangentClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.tan(Double.parseDouble(textEntry.getText()))));
    }
    //sets textbox to the cos(x) in radians
    private void cosineClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.cos(Double.parseDouble(textEntry.getText()))));
    }
    //sets textbox to the sin(x) in radians
    private void sineClicked() {
        if (textEntry.getText().isEmpty()) return;
        textEntry.setText(String.valueOf(Math.sin(Double.parseDouble(textEntry.getText()))));
    }
    //returns factorial of an input
    private long factorialMeth(long number){
        if (textEntry.getText().isEmpty()) return 0;
        if (number==0) return 0;
        ArrayList<Integer> factors = new ArrayList<>();
        for (int x=1; x<=number; x++){
            factors.add(x);
        }
        long finalNum = 1;
        for (Integer factor : factors) {
            finalNum *= factor;
        }
        return finalNum;
    }
}