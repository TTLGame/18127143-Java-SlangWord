import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.border.Border;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.EmptyBorder;

//import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;


public class source{
    // create a hashmap
    public static class Slang { // create 2 hashmap, 1 ID is the slangword, 1 ID is the meaning
        HashMap<String, String> word = new HashMap<String, String>();
        HashMap<String, String> definition = new HashMap<String, String>();
    }
    public static void create_button(JButton button,String text){
        button.setText(text);
        button.setFocusable(false);// delete the box arount the text
        button.setSize(200, 200);
        button.setPreferredSize(new Dimension(300,100));
        button.setMaximumSize(button.getPreferredSize());
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    public static void main_screen() {
        // screen
        
        JFrame screen = new JFrame();
        JLabel header = new JLabel();
        JButton button_1 = new JButton();
        JButton button_2 = new JButton();
        JButton button_3 = new JButton();
        JButton button_4 = new JButton();
        JButton button_5 = new JButton();
        JButton button_6 = new JButton();
        JButton button_7 = new JButton();
        JButton button_8 = new JButton();
        JButton button_9 = new JButton();
        JButton button_10 = new JButton();
        
        JPanel panel_1 = new JPanel();
        JPanel panel_2 = new JPanel();
       
        //
        

        panel_1.setBackground(Color.GREEN);
        panel_2.setBackground(Color.BLACK);
        
        panel_1.setBounds(0, 0, 1000, 100);
        panel_2.setBounds(0, 100, 1000, 900);
        
        panel_1.add(header);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
        
        //
        panel_2.add(button_1);
        panel_2.add(button_2);
        panel_2.add(button_3);
        panel_2.add(button_4);
        panel_2.add(button_5);
        panel_2.add(button_6);
        panel_2.add(button_7);
        panel_2.add(button_8);
        panel_2.add(button_9);
        panel_2.add(button_10);
        
        
        //
        screen.setVisible(true); // display the screen
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("Slangword");
        screen.setSize(1000, 1000);
        screen.setLayout(null);
        screen.add(panel_1);
        screen.add(panel_2);
        //screen.add(scrollBar);
        // header
        header.setText("Slang-Word");
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));// font size
        header.setForeground(Color.white);// font color
        // button -----------
        create_button(button_1, "1. Search by Slang-word");
        create_button(button_2, "2. Search by Definition");
        create_button(button_3, "3. Search by Slang-word");
        create_button(button_4, "4. Search by Definition");
        create_button(button_5, "5. Search by Slang-word");
        create_button(button_6, "6. Search by Definition");
        create_button(button_7, "7. Search by Slang-word");
        create_button(button_8, "8. Search by Definition");
        create_button(button_9, "9. Search by Slang-word");
        create_button(button_10, "10. Search by Definition");
        //panel_2.validate();
        button_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_2.remove(button_1);
                panel_2.validate();
            }
        });
    }

    // 1
    public static void Search_Slang(Slang slang_word, ArrayList<String> History_slang,
            ArrayList<String> History_definition) {
        Scanner take = new Scanner(System.in);
        String word = take.nextLine();
        System.out.print(slang_word.definition.get(word));
        // add to History
        History_slang.add(word);
        History_definition.add(slang_word.definition.get(word));
        take.close();
    }

    // 2
    public static void Search_Definition(Slang slang_word, ArrayList<String> History_slang,
            ArrayList<String> History_definition) {
        Scanner take = new Scanner(System.in);
        String word = take.nextLine();
        System.out.print(slang_word.word.get(word));
        // add to History
        History_slang.add(slang_word.word.get(word));
        History_definition.add(word);
        take.close();
    }

    public static void add_to_Slang(Slang slang_word, String read_data) {
        String string_div[];
        String word[];
        string_div = read_data.split("`");
        slang_word.definition.put(string_div[0], string_div[1]);
        word = string_div[1].split("\\| "); // "\\|" mean | symbols
        for (String Word : word) {
            if (slang_word.word.containsKey(Word)) {
                String temp = slang_word.word.get(Word) + "| " + string_div[0];
                slang_word.word.put(Word, temp);
            } else {
                slang_word.word.put(Word, string_div[0]);
            }
        }
    }

    // readFile
    public static void read_File(Slang slang_word) {
        try {
            String read_data = "";

            File readFile = new File("slang.txt");
            Scanner s = new Scanner(readFile);
            while (s.hasNextLine()) {
                read_data = s.nextLine();
                add_to_Slang(slang_word,read_data);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        main_screen();
        Slang slang_word = new Slang();
        ArrayList<String> History_slang = new ArrayList<String>();
        ArrayList<String> History_definition = new ArrayList<String>();
        // readfile
        read_File(slang_word);
        // ---------
        // Search_Slang(slang_word,History_slang,History_definition);
        Search_Definition(slang_word,History_slang,History_definition);

    }
}