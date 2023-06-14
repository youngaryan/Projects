import javax.swing.*;
import java.awt.*;
import java.util.*;


public class GuiHome extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private int point = 0;



    //constructor
    public GuiHome() {
        setTitle("ToDoList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);


        //adding button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        addButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        deleteButton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        JLabel motivationalQuote = new JLabel("History repeats itself, first as tragedy, second as farce.");
        motivationalQuote.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        motivationalQuote.setHorizontalAlignment(SwingConstants.CENTER);
        motivationalQuote.setForeground(Color.WHITE);



        JPanel comboBoxPanel = new JPanel();
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Low");
        comboBox.addItem("Mid");
        comboBox.addItem("High");
        comboBoxPanel.setBackground(Color.BLACK);
        comboBoxPanel.add(comboBox);

        JButton checkBox = new JButton("Task Done");
        checkBox.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        comboBoxPanel.add(checkBox);

        taskListModel = new DefaultListModel<>();
        taskListModel.addElement("Task 1");

        taskList = new JList<>(taskListModel);
        taskList.setBackground(Color.BLACK);
        taskList.setForeground(Color.WHITE);
        taskList.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        JPanel suggestionAndPoints = new JPanel();
        suggestionAndPoints.setLayout(new BoxLayout(suggestionAndPoints, BoxLayout.PAGE_AXIS));
        suggestionAndPoints.setBackground(Color.BLACK);


        JLabel pointAwarded = new JLabel("Points: 0");
        pointAwarded.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        pointAwarded.setForeground(Color.WHITE);
        suggestionAndPoints.add(pointAwarded);


        JButton suggestionButton = new JButton("Suggestions For Your Free Time");
        suggestionButton.setBackground(Color.BLACK);
        suggestionButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        suggestionButton.setForeground(Color.WHITE);
        suggestionAndPoints.add(suggestionButton);

        JLabel suggestionLabel = new JLabel();
        suggestionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        suggestionLabel.setForeground(Color.WHITE);
        suggestionAndPoints.add(suggestionLabel);

        JTextField notesToYourSelf = new JTextField("Notes");
        notesToYourSelf.setBackground(Color.BLACK);
        notesToYourSelf.setForeground(Color.WHITE);
        suggestionAndPoints.add(notesToYourSelf);

        add(suggestionAndPoints,BorderLayout.WEST);
        add(motivationalQuote, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(comboBoxPanel, BorderLayout.EAST);



        addButton.addActionListener(e -> {
            String newTask = JOptionPane.showInputDialog(GuiHome.this, "Enter a new task:");
            if (newTask != null && !newTask.isEmpty()) {
                taskListModel.addElement(newTask);
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.removeElementAt(selectedIndex);
            }
        });

        suggestionButton.addActionListener(e -> {
            String[] suggestionList = new String[]{"Exercise", "Walk", "Watch a Film", "Talk to a Family Member", "Cook", "Play an Instrument", "Read", "Journal", "Yoga", "Push Up"};
            Random r = new Random();
            suggestionLabel.setText(suggestionList[r.nextInt(9)]);
        });

        checkBox.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.removeElementAt(selectedIndex);
                pointAwarded.setText("Point: " + (point+=10));

            }
        });

        comboBox.addActionListener(e -> {
            Object selectedItem = comboBox.getSelectedItem();
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedItem != null && selectedIndex != -1) {
                String task = taskListModel.getElementAt(selectedIndex);
                task += " (" + selectedItem + ")";
                taskListModel.setElementAt(task, selectedIndex);
            }
        });
    }
}
