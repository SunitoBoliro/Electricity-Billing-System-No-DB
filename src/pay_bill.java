import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

public class pay_bill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l8;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    Choice c1;
    JPanel p1 = new JPanel();
    pay_bill(){
        super("PAY BILL");
        c1 = new Choice();
        setLocation(350,200);
        setSize(650,600);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));

        p.setBackground(Color.WHITE);
        c1 = new Choice();

        l1 = new JLabel("Name");
        t1 = new JTextField();
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        t2 = new JTextField();
        p.add(l2);
        p.add(t2);

//        c1.add();
        l3 = new JLabel("Units");
        t3 = new JTextField();
        p.add(l3);
        p.add(t3);
//        p.add()

        c1.add("PAID");
        c1.add("NOT-PAID");
        l4= new JLabel("STATUS");
        p.add(l4);
        p.add(c1);


        b1 = new JButton("Pay");
        b2 = new JButton("Cancel");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("images/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 280,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){

        String a = t1.getText();
        String c = t2.getText();
        String d = t3.getText();
        String p = c1.getSelectedItem();

        int l = 0;
        for (int i = 0; i < 20; i++) {
            String fil_name = "pay_bill"+i+".txt";
            File myObj = new File(fil_name);
            try{
                if(myObj.exists()){
                    l = l+1;
                }else{
                    String se = "pay_bill"+l+".txt";
                    FileWriter myWriter = new FileWriter(se);
                    int p1 = Integer.parseInt(d);

                    int p2 = p1*7;
                    int p3 = p2+50+12+102+20+50;
                    String s = a + ", " + c + ", " + d + ", " + p + ", " + p3 + "\n";
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                    myWriter.append(s);
                    myWriter.close();

                    JOptionPane.showMessageDialog(null,"Your Bill amounting to : Rs. " + p3);
                    this.setVisible(false);
                    System.out.println("Successfully wrote to the file.");
                    break;
                }
            }catch (Exception n){
                n.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new pay_bill().setVisible(true);
    }
}