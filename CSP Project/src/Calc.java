import javax.swing.*;
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
    private JButton

    private JButton clear = new JButton("Clear");

    public Calc(){
        super("Calculator");
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CalculatorLBL.setBounds(140,40,90,30);
        add(CalculatorLBL);

        textEntry.setBounds(105,70,160,30);
        add(textEntry);

        sine.setBounds(55,120,80,30);
        sine.addActionListener(e -> sineClicked());
        add(sine);
        cosine.setBounds(145,120,80,30);
        cosine.addActionListener(e-> cosineClicked());
        add(cosine);
        tangent.setBounds(235,120,80,30);
        tangent.addActionListener(e->tangentClicked());
        add(tangent);

        factorial.setBounds(55,160,80,30);
        factorial.addActionListener(e-> factorialClicked());
        add(factorial);
        square.setBounds(145,160,80,30);
        square.addActionListener(e-> squareClicked());
        add(square);
        squareRoot.setBounds(235,160,80,30);
        squareRoot.addActionListener(e -> sqrtClicked());
        add(squareRoot);

        setVisible(true);
    }

    private void sqrtClicked() {
        textEntry.setText(String.valueOf(Math.sqrt(Double.parseDouble(textEntry.getText()))));
    }

    private void squareClicked() {
        textEntry.setText(String.valueOf(Math.pow(Double.parseDouble(textEntry.getText()),2)));
    }

    private void factorialClicked() {
        textEntry.setText(String.valueOf(factorialMeth(Long.parseLong(textEntry.getText()))));
    }

    private void tangentClicked() {
        textEntry.setText(String.valueOf(Math.tan(Double.parseDouble(textEntry.getText()))));
    }

    private void cosineClicked() {
        textEntry.setText(String.valueOf(Math.cos(Double.parseDouble(textEntry.getText()))));
    }

    private void sineClicked() {
        textEntry.setText(String.valueOf(Math.sin(Double.parseDouble(textEntry.getText()))));
    }

    public long factorialMeth(long number){
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
