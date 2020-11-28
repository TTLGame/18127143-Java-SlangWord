import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
//import javax.swing.border.Border;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class source {
    // create a hashmap
    public static class Slang { // create 2 hashmap, 1 ID is the slangword, 1 ID is the meaning
        HashMap<String, String> word = new HashMap<String, String>();
        HashMap<String, String> definition = new HashMap<String, String>();
    }

    public static void create_button(JButton button, String text) {
        button.setText(text);
        button.setFocusable(false);// delete the box arount the text
        button.setSize(200, 200);
        button.setPreferredSize(new Dimension(300, 50));
        button.setMaximumSize(button.getPreferredSize());
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main_screen(Slang slang_word, ArrayList<String> History_slang,
            ArrayList<String> History_definition) {
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

        //
        panel_1.setBackground(Color.BLUE);
        panel_2.setBackground(Color.WHITE);

        panel_1.setBounds(0, 0, 1000, 100);
        panel_2.setBounds(0, 100, 1000, 900);

        panel_1.add(header);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

        //
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_1);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_2);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_3);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_4);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_5);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_6);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_7);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_8);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_9);
        panel_2.add(Box.createRigidArea(new Dimension(0, 30)));
        panel_2.add(button_10);

        //
        screen.setVisible(true); // display the screen
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setTitle("Slangword");
        screen.setSize(1000, 1000);
        screen.setLayout(null);
        screen.add(panel_1);
        screen.add(panel_2);
        // screen.add(scrollBar);
        // header
        header.setText("Slang-Word");
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));// font size
        header.setForeground(Color.white);// font color
        // button -----------
        create_button(button_1, "1. Search by Slang-word");
        create_button(button_2, "2. Search by Definition");
        create_button(button_3, "3. Search History");
        create_button(button_4, "4. Add a new Slang-word");
        create_button(button_5, "5. Edit a Slang-word");
        create_button(button_6, "6. Delete a Slang-word");
        create_button(button_7, "7. Reset into the original Slang-word list");
        create_button(button_8, "8. Random a slang-word");
        create_button(button_9, "9.Quiz by slang-word");
        create_button(button_10, "10. Quiz by definition");
        // panel_2.validate();

        // button1 -----------------------------------------------
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Search by Slang-word");
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //
                JLabel title = new JLabel();
                JLabel instruction_1 = new JLabel();
                JLabel instruction_2 = new JLabel();
                JTextField input = new JTextField();
                JTextArea output = new JTextArea();
                input.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                output.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                frame.setLayout(null);
                input.setBounds(100, 120, 300, 30);
                output.setBounds(100, 200, 300, 500);
                output.setEditable(false);

                title.setText("Search by Slang-Word");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                instruction_1.setText("Enter input: ");
                instruction_1.setBounds(20, 120, 100, 30);

                instruction_2.setText("Meaning: ");
                instruction_2.setBounds(20, 200, 100, 30);
                frame.add(input);
                frame.add(title);
                frame.add(instruction_1);
                input.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        output.setText("");
                        frame.add(instruction_2);

                        frame.add(output);
                        String searched_word = input.getText();
                        String[] temp = Search_Slang(searched_word, slang_word, History_slang, History_definition)
                                .split("\\| ");

                        for (String Word : temp) {
                            if (Word == "NULL") {
                                output.append("No Information\n");
                                break;
                            }
                            output.append(" . " + Word);
                            output.append("\n");
                        }

                    }
                });
            }
        });
        // button2 ------------------------------------------
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Search by Definition");
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //
                JLabel title = new JLabel();
                JLabel instruction_1 = new JLabel();
                JLabel instruction_2 = new JLabel();
                JTextField input = new JTextField();
                JTextArea output = new JTextArea();
                input.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                output.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                frame.setLayout(null);
                input.setBounds(100, 120, 300, 30);
                output.setBounds(100, 200, 300, 500);
                output.setEditable(false);

                title.setText("Search by Definition");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                instruction_1.setText("Enter input: ");
                instruction_1.setBounds(20, 120, 100, 30);

                instruction_2.setText("Meaning: ");
                instruction_2.setBounds(20, 200, 100, 30);
                frame.add(input);
                frame.add(title);
                frame.add(instruction_1);
                input.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        output.setText("");
                        frame.add(instruction_2);

                        frame.add(output);
                        String searched_word = input.getText();
                        String[] temp = Search_Definition(searched_word, slang_word, History_slang, History_definition)
                                .split("\\| ");

                        for (String Word : temp) {
                            if (Word == "NULL") {
                                output.append("No Information\n");
                                break;
                            }
                            output.append(" . " + Word);
                            output.append("\n");
                        }

                    }
                });
            }
        });
        // button3 -------------------------------------
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Search History");
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //
                JLabel title = new JLabel();
                JLabel instruction_1 = new JLabel();
                JLabel instruction_2 = new JLabel();
                JTextArea slang = new JTextArea();
                JTextArea definition = new JTextArea();
                frame.setLayout(null);
                slang.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                // slang.setBounds(20, 150, 180, 500);
                slang.setEditable(false);

                definition.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                // definition.setBounds(270, 150, 180, 500);
                definition.setEditable(false);

                title.setText("Search History");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                instruction_1.setText("Slang-word ");
                instruction_1.setBounds(80, 100, 100, 30);

                instruction_2.setText("Definition ");
                instruction_2.setBounds(350, 100, 100, 30);
                frame.add(slang);
                frame.add(definition);
                frame.add(title);
                frame.add(instruction_1);
                frame.add(instruction_2);
                JScrollPane scroller_slang = new JScrollPane(slang);
                JScrollPane scroller_def = new JScrollPane(definition);
                frame.add(scroller_slang);
                frame.add(scroller_def);
                scroller_slang.setBounds(20, 150, 180, 500);
                scroller_def.setBounds(270, 150, 180, 500);
                for (int i = 0; i < History_definition.size(); i++) {
                    slang.append(" . " + History_slang.get(i) + "\n");
                    definition.append(" . " + History_definition.get(i) + "\n");
                }
            }
        });
        // button4 ------------------------------------------
        button_4.addActionListener(new ActionListener() {
            JFrame frame = new JFrame("Add new Slang-word");
            JTextField input_1 = new JTextField();
            JTextField input_2 = new JTextField();

            public void Cancel_press(JTextArea info, JButton overwrite, JButton duplicate, JButton cancel) {
                input_1.setEditable(true);
                input_2.setEditable(true);
                input_1.setText("");
                input_2.setText("");
                frame.remove(info);
                frame.remove(overwrite);
                frame.remove(duplicate);
                frame.remove(cancel);
                frame.repaint();
            }

            public void route(String slang, String def) {
                // duplicate
                JTextArea info = new JTextArea();
                JButton overwrite = new JButton();
                JButton duplicate = new JButton();
                JButton cancel = new JButton();
                //
                overwrite.setText("Overwrite it");
                overwrite.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                overwrite.setBounds(10, 300, 100, 50);

                duplicate.setText("Duplicate it");
                duplicate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                duplicate.setBounds(130, 300, 100, 50);

                cancel.setText("Cancel");
                cancel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                cancel.setBounds(350, 300, 100, 50);

                info.setText(
                        "!Input Slang-word is already existed\nPlease choose whether you want to OVERWRITE or DUPLICATE it");
                info.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                info.setForeground(Color.RED);// font color
                info.setBounds(15, 200, 400, 50);
                if (slang_word.definition.containsKey(slang)) {
                    frame.add(info);
                    frame.add(overwrite);
                    frame.add(duplicate);
                    frame.add(cancel);
                    input_1.setEditable(false);
                    input_2.setEditable(false);
                    frame.repaint();
                    cancel.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            Cancel_press(info, overwrite, duplicate, cancel);
                        }
                    });

                    duplicate.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            add_to_Slang(slang_word, slang + "`" + slang_word.definition.get(slang) + "| " + def);
                            Cancel_press(info, overwrite, duplicate, cancel);
                            overwrite_file(slang_word, "slang.txt");
                            JOptionPane.showMessageDialog(frame, "Successfully duplicate new Slang-word");
                        }
                    });
                    overwrite.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            add_to_Slang(slang_word, slang + "`" + def);
                            Cancel_press(info, overwrite, duplicate, cancel);
                            overwrite_file(slang_word, "slang.txt");
                            slang_word.word.clear();
                            read_File(slang_word, "slang.txt");
                            JOptionPane.showMessageDialog(frame, "Successfully overwrite new Slang-word");
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(frame, "Successfully add new Slang-word");
                    add_to_Slang(slang_word, slang + "`" + def);

                    overwrite_file(slang_word, "slang.txt");
                    input_1.setText("");
                    input_2.setText("");
                }
            }

            public void actionPerformed(ActionEvent e) {

                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //
                JLabel title = new JLabel();
                JLabel instruction_1 = new JLabel();
                JLabel instruction_2 = new JLabel();

                frame.setLayout(null);

                input_1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                input_2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

                input_1.setBounds(120, 120, 300, 30);
                input_2.setBounds(120, 170, 300, 30);

                title.setText("Add new Slang-word");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                instruction_1.setText("Enter slang-word ");
                instruction_1.setBounds(5, 120, 100, 30);

                instruction_2.setText("Enter Definition: ");
                instruction_2.setBounds(5, 170, 100, 30);
                frame.add(input_1);
                frame.add(input_2);
                frame.add(title);
                frame.add(instruction_1);
                frame.add(instruction_2);
                //
                JLabel warning = new JLabel();
                warning.setText("!Please input both slang-word and Definition");
                warning.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                warning.setForeground(Color.RED);// font color
                warning.setBounds(15, 200, 400, 30);

                input_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (input_1.getText().equals("") || input_2.getText().equals("")) {
                            frame.add(warning);
                            frame.repaint();
                        } else {

                            frame.remove(warning);
                            frame.repaint();
                            route(input_1.getText(), input_2.getText());

                        }

                    }
                });
                input_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (input_1.getText().equals("") || input_2.getText().equals("")) {
                            frame.add(warning);
                            frame.repaint();
                        } else {

                            frame.remove(warning);
                            frame.repaint();
                            route(input_1.getText(), input_2.getText());

                        }
                    }
                });

            }
        });
        // button5 ------------------------------------------
        button_5.addActionListener(new ActionListener() {
            JFrame frame = new JFrame("Edit a Slang-word");
            JTextField input_1 = new JTextField();
            JTextField input_2 = new JTextField();

            public void Edit(String slang_change, JLabel warning, JLabel instruction) {
                slang_word.definition.remove(slang_change);
                add_to_Slang(slang_word, input_1.getText() + "`" + input_2.getText());
                overwrite_file(slang_word, "slang.txt");
                slang_word.word.clear();
                read_File(slang_word, "slang.txt");
                frame.remove(warning);
                frame.remove(instruction);
                frame.remove(input_2);
                input_1.setText("");
                input_2.setText("");
                frame.repaint();
                JOptionPane.showMessageDialog(frame, "Successfully edit a Slang-word");
            }

            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //
                JLabel title = new JLabel();
                JLabel instruction_1 = new JLabel();
                JLabel instruction_2 = new JLabel();

                frame.setLayout(null);

                input_1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                input_2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

                input_1.setBounds(120, 120, 300, 30);
                input_2.setBounds(120, 170, 300, 30);

                title.setText("Edit a Slang-word");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                instruction_1.setText("Enter slang-word ");
                instruction_1.setBounds(5, 120, 100, 30);

                instruction_2.setText("Enter Definition: ");
                instruction_2.setBounds(5, 170, 100, 30);
                frame.add(input_1);
                // frame.add(input_2);
                frame.add(title);
                frame.add(instruction_1);
                // frame.add(instruction_2);
                //
                JLabel warning = new JLabel();

                warning.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                warning.setForeground(Color.RED);// font color
                warning.setBounds(15, 200, 400, 30);
                input_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        String slang_change = input_1.getText();
                        if (input_1.getText().equals("")) {
                            warning.setText("!Please input a slang-word");
                            frame.add(warning);
                            frame.repaint();
                        } else {
                            if (slang_word.definition.get(input_1.getText()) == null) {
                                frame.add(warning);
                                warning.setText("Slang-word is invalid");
                                frame.repaint();
                            } else {
                                frame.remove(warning);
                                frame.add(instruction_2);
                                frame.add(input_2);
                                frame.repaint();
                                input_1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        if (input_1.getText().equals("") || input_2.getText().equals("")) {
                                            warning.setText("!Please enter both slang-word and definition");
                                            frame.add(warning);
                                            frame.repaint();
                                        } else {
                                            Edit(slang_change, warning, instruction_2);
                                        }
                                    }
                                });
                                input_2.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        if (input_1.getText().equals("") || input_2.getText().equals("")) {
                                            warning.setText("!Please enter both slang-word and definition");
                                            frame.add(warning);
                                            frame.repaint();
                                        } else {
                                            Edit(slang_change, warning, instruction_2);
                                        }
                                    }
                                });

                            }
                        }

                    }
                });

            }
        });

        // button6 ------------------------------------------
        button_6.addActionListener(new ActionListener() {
            JFrame frame = new JFrame("Edit a Slang-word");
            JTextField input_1 = new JTextField();

            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //
                JLabel title = new JLabel();
                JLabel instruction_1 = new JLabel();
                JLabel instruction_2 = new JLabel();

                frame.setLayout(null);

                input_1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size

                input_1.setBounds(120, 120, 300, 30);

                title.setText("Edit a Slang-word");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                instruction_1.setText("Enter slang-word ");
                instruction_1.setBounds(5, 120, 100, 30);

                instruction_2.setText("Enter Definition: ");
                instruction_2.setBounds(5, 170, 100, 30);
                frame.add(input_1);
                // frame.add(input_2);
                frame.add(title);
                frame.add(instruction_1);
                // frame.add(instruction_2);
                //
                JLabel warning = new JLabel();

                warning.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                warning.setForeground(Color.RED);// font color
                warning.setBounds(15, 200, 400, 30);
                input_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (input_1.getText().equals("")) {
                            warning.setText("Please input a slang word");
                            frame.add(warning);
                            frame.repaint();
                        } else if (slang_word.definition.get(input_1.getText()) == null) {
                            warning.setText("Slang word is invalid");
                            frame.add(warning);
                            frame.repaint();
                        } else {
                            frame.remove(warning);
                            input_1.setEditable(false);
                            JButton confirm = new JButton();
                            JButton cancel = new JButton();
                            JLabel instruct = new JLabel();
                            instruct.setText("Do you really wish to delete this slang word?");
                            instruct.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));// font size
                            instruct.setForeground(Color.BLACK);// font color
                            instruct.setBounds(15, 200, 400, 30);

                            confirm.setText("Confirm");
                            confirm.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                            confirm.setBounds(100, 300, 100, 50);

                            cancel.setText("Cancel");
                            cancel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                            cancel.setBounds(200, 300, 100, 50);
                            frame.add(confirm);
                            frame.add(cancel);
                            frame.add(instruct);
                            frame.repaint();
                            cancel.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    frame.remove(confirm);
                                    frame.remove(cancel);
                                    frame.remove(instruct);
                                    frame.repaint();
                                    input_1.setEditable(true);

                                }
                            });
                            confirm.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    slang_word.definition.remove(input_1.getText());
                                    overwrite_file(slang_word, "slang.txt");
                                    slang_word.word.clear();
                                    read_File(slang_word, "slang.txt");
                                    JOptionPane.showMessageDialog(frame, "Successfully delete a Slang-word");
                                    input_1.setText("");
                                    frame.remove(confirm);
                                    frame.remove(cancel);
                                    frame.remove(instruct);
                                    frame.repaint();
                                    input_1.setEditable(true);

                                }
                            });
                        }
                    }
                });

            }
        });
        // button7 ------------------------------------------
        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset_File(slang_word);
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Successfully reset Slang-word");
            }
        });
        // button8 ------------------------------------------
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset_File(slang_word);
                JFrame frame = new JFrame();

                Random random = new Random();
                int number = random.nextInt(slang_word.definition.size());
                int count = 0;
                for (String i : slang_word.definition.keySet()) {
                    if (number == count) {
                        JOptionPane.showMessageDialog(frame,
                                "Slang: " + i + " || " + "Definition: " + slang_word.definition.get(i));
                        break;
                    }
                    count++;
                }
            }
        });
        // button 9 ------------------------------------------
        button_9.addActionListener(new ActionListener() {
            String[] choice = new String[4];
            int pos;
            Random random = new Random();
            JFrame frame = new JFrame("Quiz by Slang-word");
            JTextArea question = new JTextArea();
            JButton ans_0 = new JButton();
            JButton ans_1 = new JButton();
            JButton ans_2 = new JButton();
            JButton ans_3 = new JButton();

            public void custom_button(String choice, JButton button) {
                button.setText("<html>"+choice+"</html");
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                button.setForeground(Color.BLACK);
            }

            public void Create_random() {
                pos = random.nextInt(4);
                for (int i = 0; i < 4; i++) {
                    choice[i] = "";
                }
                for (int i = 0; i < 4; i++) {
                    int count = 0;
                    int number = random.nextInt(slang_word.definition.size());
                    for (String j : slang_word.definition.keySet()) {
                        if (number == count) {

                            if (i == 0) {
                                choice[pos] = j;
                            } else {
                                if (choice[i] != "") {
                                    int temp = i + 1;
                                    if (temp == 4) {
                                        temp = 0;
                                    }
                                    choice[temp] = j;
                                } else {
                                    choice[i] = j;
                                }
                            }
                            break;
                        }
                        count++;
                    }
                }
                custom_button(slang_word.definition.get(choice[0]), ans_0);
                custom_button(slang_word.definition.get(choice[1]), ans_1);
                custom_button(slang_word.definition.get(choice[2]), ans_2);
                custom_button(slang_word.definition.get(choice[3]), ans_3);
                question.setText("What is the definition of the slang word:\n" + choice[pos]);
                frame.repaint();
            }

            public void Victory(JFrame frame) {
                JOptionPane.showMessageDialog(frame, "Correct answer, you WIN!");
                Create_random();
            }

            public void Lose(JFrame frame) {
                JOptionPane.showMessageDialog(frame, "you LOSE, better luck next time!");
                Create_random();
            }

            public void actionPerformed(ActionEvent e) {
                Create_random();

                ans_0.setBounds(10, 300, 180, 100);
                ans_1.setBounds(250, 300, 180, 100);
                ans_2.setBounds(10, 450, 180, 100);
                ans_3.setBounds(250, 450, 180, 100);
                question.setEditable(false);
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(null);
                //
                JLabel title = new JLabel();
                title.setText("Quiz by Slang-word");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                question.setBounds(10, 100, 450, 150);
                question.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                question.setForeground(Color.BLACK);

                frame.add(title);
                frame.add(question);
                frame.add(ans_0);
                frame.add(ans_1);
                frame.add(ans_2);
                frame.add(ans_3);
                

                // ans
                ans_0.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 0) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
                ans_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 1) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
                ans_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 2) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
                ans_3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 3) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
            }
        });
        // button 10 ------------------------------------------
        button_10.addActionListener(new ActionListener() {
            String[] choice = new String[4];
            int pos;
            Random random = new Random();
            JFrame frame = new JFrame("Quiz by Slang-word");
            JTextArea question = new JTextArea();
            JButton ans_0 = new JButton();
            JButton ans_1 = new JButton();
            JButton ans_2 = new JButton();
            JButton ans_3 = new JButton();

            public void custom_button(String choice, JButton button) {
                button.setText("<html>"+choice+"</html");
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));// font size
                button.setForeground(Color.BLACK);
            }

            public void Create_random() {
                pos = random.nextInt(4);
                for (int i = 0; i < 4; i++) {
                    choice[i] = "";
                }
                for (int i = 0; i < 4; i++) {
                    int count = 0;
                    int number = random.nextInt(slang_word.word.size());
                    for (String j : slang_word.word.keySet()) {
                        if (number == count) {

                            if (i == 0) {
                                choice[pos] = j;
                            } else {
                                if (choice[i] != "") {
                                    int temp = i + 1;
                                    if (temp == 4) {
                                        temp = 0;
                                    }
                                    choice[temp] = j;
                                } else {
                                    choice[i] = j;
                                }
                            }
                            break;
                        }
                        count++;
                    }
                }
                custom_button(slang_word.word.get(choice[0]), ans_0);
                custom_button(slang_word.word.get(choice[1]), ans_1);
                custom_button(slang_word.word.get(choice[2]), ans_2);
                custom_button(slang_word.word.get(choice[3]), ans_3);
                question.setText("What is the slang-word of this definition:\n" + choice[pos]);
                frame.repaint();
            }

            public void Victory(JFrame frame) {
                JOptionPane.showMessageDialog(frame, "Correct answer, you WIN!");
                Create_random();
            }

            public void Lose(JFrame frame) {
                JOptionPane.showMessageDialog(frame, "you LOSE, better luck next time!");
                Create_random();
            }

            public void actionPerformed(ActionEvent e) {
                Create_random();

                ans_0.setBounds(10, 300, 180, 100);
                ans_1.setBounds(250, 300, 180, 100);
                ans_2.setBounds(10, 450, 180, 100);
                ans_3.setBounds(250, 450, 180, 100);
                question.setEditable(false);
                frame.setVisible(true); // display the screen
                frame.setSize(500, 800);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(null);
                //
                JLabel title = new JLabel();
                title.setText("Quiz by Slang-word");
                title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));// font size
                title.setForeground(Color.BLACK);// font color
                title.setBounds(80, 0, 400, 100);

                question.setBounds(10, 100, 450, 150);
                question.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                question.setForeground(Color.BLACK);

                frame.add(title);
                frame.add(question);
                frame.add(ans_0);
                frame.add(ans_1);
                frame.add(ans_2);
                frame.add(ans_3);
                

                // ans
                ans_0.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 0) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
                ans_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 1) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
                ans_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 2) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
                ans_3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (pos == 3) {
                            Victory(frame);
                        } else {
                            Lose(frame);
                        }
                    }
                });
            }
        });
    }

    // 1
    public static String Search_Slang(String word, Slang slang_word, ArrayList<String> History_slang,
            ArrayList<String> History_definition) {
        // add to History
        if (History_slang.size() == 20) {
            History_definition.remove(0);
            History_slang.remove(0);
        }
        History_slang.add(word);
        if (slang_word.definition.get(word) == null) {
            History_definition.add("NULL");
            return "NULL";
        } else {
            History_definition.add(slang_word.definition.get(word));
        }
        return slang_word.definition.get(word);
    }

    // 2
    public static String Search_Definition(String word, Slang slang_word, ArrayList<String> History_slang,
            ArrayList<String> History_definition) {
        // add to History
        if (History_slang.size() == 20) {
            History_definition.remove(0);
            History_slang.remove(0);
        }
        History_definition.add(word);
        if (slang_word.word.get(word) == null) {
            History_slang.add("NULL");
            return "NULL";
        }
        History_slang.add(slang_word.word.get(word));

        return slang_word.word.get(word);
    }

    // overwrite_file
    public static void overwrite_file(Slang slang_word, String file_name) {
        try {
            FileWriter writer = new FileWriter(file_name);
            for (String i : slang_word.definition.keySet()) {
                writer.write(i + "`" + slang_word.definition.get(i) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // 7
    public static void reset_File(Slang slang_word) {
        slang_word.definition.clear();
        slang_word.word.clear();
        read_File(slang_word, "slang-original.txt");
        overwrite_file(slang_word, "slang.txt");
    }

    public static void add_to_Slang(Slang slang_word, String read_data) {
        String[] string_div;
        String[] word;
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
    public static void read_File(Slang slang_word, String file_name) {
        try {
            String read_data = "";

            File readFile = new File(file_name);
            Scanner s = new Scanner(readFile);
            while (s.hasNextLine()) {
                read_data = s.nextLine();
                add_to_Slang(slang_word, read_data);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {

        Slang slang_word = new Slang();
        ArrayList<String> History_slang = new ArrayList<String>();
        ArrayList<String> History_definition = new ArrayList<String>();
        // readfile
        read_File(slang_word, "slang.txt");
        // reset_File(slang_word);
        // ---------
        main_screen(slang_word, History_slang, History_definition);

    }
}