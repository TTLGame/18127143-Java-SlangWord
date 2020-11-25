import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class source {
    
    
    public static void main_screen() {
        // screen
        JFrame screen = new JFrame();
        JLabel header = new JLabel();
        JButton button_1 = new JButton();
        screen.setVisible(true); // display the screen
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.setTitle("Slangword");
        screen.setSize(400, 400);
        screen.setLayout(null);
        screen.add(header);
        screen.add(button_1);
        
        // header
        header.setText("SlangWord");
        header.setHorizontalTextPosition(JLabel.CENTER);
        header.setVerticalTextPosition(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.TOP);
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
        header.setForeground(Color.white);// font color
        header.setBackground(new Color(51, 204, 255)); // change background color
        header.setOpaque(true); // display Background
        //
        header.setBounds(20, 0, 300, 100);
        // button
        button_1.setText("Add");

        
        button_1.setFocusable(false);// delete the box arount the text
        button_1.setBounds(120, 120, 100, 50);
        button_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });   
    }
    public static void main(String[] args) {
        main_screen();
        String data = "";

        // readfile
        try {
            File readFile = new File("slang.txt");
            Scanner s = new Scanner(readFile);

            while (s.hasNextLine()) {
                data = s.nextLine();
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        System.out.println(data);
    }
}