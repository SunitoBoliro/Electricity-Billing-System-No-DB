import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class customer_details extends JFrame implements ActionListener{

    JTable t1;
    JButton b1;
    String[] x = {"Consumer Name","Meter No","Address","State","City","Email","Phone"};
    String[][] y = new String[20][8];
    customer_details(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(200,200);

        ArrayList<String> ok = new ArrayList<>();
        try {
            for (int i = 0; i < 20; i++) {
                String fil_name = "custom_data" + i + ".txt";
                File myObj = new File(fil_name);
                try {
                    if (myObj.exists()) {
                        ok.add(fil_name);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            Object[] objects = ok.toArray();

            // Printing array of objects
            int len = objects.length;
            Scanner myReader;
            try {
                myReader = null;
                String data = "";
                for (int i = 0; i < len; i++) {
                    File myObj = new File(ok.get(i));
                    myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        data = data + myReader.nextLine();
//                        data_1[i] = data_02.split(", ");
                        System.out.println(data);
//                        data_01 = data_01 + data.split(", ");
//                        storage.addAll(Arrays.asList(arr).subList(0, (arr).length));
                    }
                    data = data + ", ";
                }
                String[] work = data.split(", ");
                System.out.println(work[6]);
                int j = 0;
                for (int i = 0; i < len;) {
                    y[i][0] = work[j];
                    y[i][1] = work[j+1];
                    y[i][2] = work[j+2];
                    y[i][3] = work[j+3];
                    y[i][4] = work[j+4];
                    y[i][5] = work[j+5];
                    y[i][6] = work[j+6];
                    j = j + 7;
                    if ( j % 7 == 0 ){
                        i++;
                    }
                }
            myReader.close();
        } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
        }

            t1 = new JTable(y,x);

        }catch(Exception e){
            e.printStackTrace();
        }


        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception ignored){}
    }

    public static void main(String[] args){
        new customer_details().setVisible(true);
    }

}