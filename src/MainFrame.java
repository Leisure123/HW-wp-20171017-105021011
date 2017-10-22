import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame{
    Random rnd = new Random();
    private Container cp;
    private JButton btns[] = new JButton[12];
    private JTextField tf = new JTextField();
    private JPanel pan = new JPanel(new GridLayout(4,3,3,3));
    private LoginFrame log;
    private int btnList[] = new int [10];
    private boolean check1;

    public MainFrame(LoginFrame login) {
        log = login;
        initComp();
    }

    private void initComp(){
        this.setBounds(100,100,500,500);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(tf, BorderLayout.NORTH);
        cp.add(pan, BorderLayout.CENTER);
        tf.setEditable(false);

        for(int i = 0 ; i < 10; i++){
            btnList[i] = 10;
        }

        for(int i = 0 ; i < 10 ; i++){
            check1 = true;
            while(check1) {
                check1 = false;
                int tmp = rnd.nextInt(10);
                for (int j = 0; j < btnList.length; j++) {
                    if (tmp == btnList[j]) {
                        check1 =true;
                    }
                }
                btnList[i] = tmp;
            }
        }

        for(int i = 0; i < 9; i++){
            btns[i] = new JButton();
            pan.add(btns[i]);
            btns[i].setText(Integer.toString(btnList[i]));
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpBtn = (JButton) e.getSource();
                    tf.setText(tf.getText() + tmpBtn.getText());
                }
            });
        }

        btns[9] = new JButton();
        pan.add(btns[9]);
        btns[9].setText(".");
        btns[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpBtn = (JButton) e.getSource();
                tf.setText(tf.getText() + tmpBtn.getText());
            }
        });

        btns[10] = new JButton();
        pan.add(btns[10]);
        btns[10].setText(Integer.toString(btnList[9]));
        btns[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton tmpBtn = (JButton) e.getSource();
                tf.setText(tf.getText() + tmpBtn.getText());
            }
        });

        btns[11] = new JButton();
        pan.add(btns[11]);
        btns[11].setText("C");
        btns[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                log.setVisible(true);
                dispose();
            }
        });
    }
}
