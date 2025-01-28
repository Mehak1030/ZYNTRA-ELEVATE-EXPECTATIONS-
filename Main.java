import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ZyntraWelcomeWithUnifiedMenu {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ZyntraWelcomeWithUnifiedMenu::createWelcomeGUI);
    }

    public static void createWelcomeGUI() {
        // Create the main frame
        JFrame frame = new JFrame("ZYNTRA: ELEVATE EXPECTATIONS");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Add a background image
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 800, 500); // Set size of the background to match the frame
        frame.add(backgroundLabel);

        JLabel titleLabel = new JLabel("ZYNTRA LOUNGE ");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        titleLabel.setForeground(Color.black);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 30, 700, 50); // Position and size of the title
        backgroundLabel.add(titleLabel);

        JLabel messageLabel1 = new JLabel("\"UNIFY..! SIMPLIFY..! CONNECT..!\"");
        JLabel messageLabel3 = new JLabel("\"CONNECT EFFORTLESSLY, LIVE MEANINGFULLY\".");
        messageLabel1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 24));
        messageLabel3.setFont(new Font("Montserrat", Font.PLAIN, 18));
        messageLabel1.setForeground(Color.darkGray);
        messageLabel3.setForeground(Color.blue);
        messageLabel1.setBounds(200, 100, 400, 30); // Position and size
        messageLabel3.setBounds(200, 180, 600, 30);
        backgroundLabel.add(messageLabel1);
        backgroundLabel.add(messageLabel3);

        // Add "Get Started" button
        JButton startButton = new JButton("LAUNCH");
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Serif font
        startButton.setBounds(250, 300, 120, 40); // Position and size of the button
        startButton.setBackground(new Color(72, 120, 220)); // Button color
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        backgroundLabel.add(startButton);

        // Add "Exit" button
        JButton exitButton = new JButton("SYNC ");
        exitButton.setFont(new Font("Avenir:", Font.BOLD, 16));
        exitButton.setBounds(400, 300, 120, 40); // Position and size of the button
        exitButton.setBackground(new Color(220, 72, 72)); // Button color
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        backgroundLabel.add(exitButton);

        // Add button actions
        startButton.addActionListener(e -> {
            // Show "ENTER THE WORLD OF SEAMLESS CONNECTIVITY!" message
            JOptionPane.showMessageDialog(frame, "ENTER THE WORLD OF SEAMLESS CONNECTIVITY...!", "ZYNTRA", JOptionPane.INFORMATION_MESSAGE);
            // Now dispose the welcome window and show the main app window
            frame.dispose();
            ZyntraAppPrototype.createGUI();  // Navigate to the main application
        });

        exitButton.addActionListener(e -> {
            // Ask the user which platform they would like to sync with
            String[] platforms = {"INSTAGRAM", "SNAPCHAT", "FACEBOOK", "WHATSAPP" ,"PHONE NUMBER"};
            String selectedPlatform = (String) JOptionPane.showInputDialog(frame,
                    " PLATFORM FOR SYNC:",
                    "SYNCING OPTIONS...!!",
                    JOptionPane.QUESTION_MESSAGE,
                    null, platforms, platforms[0]);

            if (selectedPlatform != null) {
                // For the sake of simplicity, using hardcoded user data
                String username = "MEHAK-ALI";  // Replace with actual user input from your app
                String email = "mehakalisyed10030@gmail.com";  // Replace with actual email input

                // Save user data to the database
                saveUserDataToDatabase(username, email, selectedPlatform);

                // Show confirmation message
                JOptionPane.showMessageDialog(frame, "SYNCING WITH " + selectedPlatform + "...");
            } else {
                JOptionPane.showMessageDialog(frame, "SYNC CANCELLED...!");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to save user data to the database
    public static void saveUserDataToDatabase(String username, String email, String platform) {
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ZyntraDB", "root", "12345");

            // Prepare SQL query to insert user data
            String sql = "INSERT INTO Users (username, email, platform) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, platform);

            // Execute the insert
            pstmt.executeUpdate();

            // Close the connection
            pstmt.close();
            conn.close();

            System.out.println(" DATA SAVED SUCCESSFULLY..!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ZyntraAppPrototype {

    public static void createGUI() {
        // Create the main frame
        JFrame frame = new JFrame("ZYNTRA: ELEVATE EXPECTATIONS");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(72, 120, 220));
        headerPanel.setPreferredSize(new Dimension(900, 150));
        headerPanel.setLayout(new BorderLayout(0, 10));
        // Back arrow button
        JButton backButton = new JButton("");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(72, 120, 220));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

// Add action listener to back button
        backButton.addActionListener(e -> {
            // Code for back button functionality
        });

// Add back button to header panel
        headerPanel.add(backButton, BorderLayout.WEST);


        // Title label in header
        JLabel titleLabel = new JLabel("\"UNIFY..! CONNECT..! SIMPLIFY..!\"");
        titleLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(72, 120, 220));
        titlePanel.add(titleLabel);

        // Buttons for "Work," "Family," "Group," "Friends"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(72, 120, 220));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        String[] sections = {"FAMILY", "FRIENDS", "PROFESSION", "COMMUNITY"};
        for (String section : sections) {
            JButton sectionButton = new JButton(section);
            sectionButton.setFont(new Font("Arial", Font.BOLD, 14));
            sectionButton.setForeground(Color.WHITE);
            sectionButton.setBackground(new Color(100, 160, 255));
            sectionButton.setFocusPainted(false);
            sectionButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            sectionButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, section + " SECTION  CLICKED..!"));
            buttonPanel.add(sectionButton);
        }

        headerPanel.add(titlePanel, BorderLayout.NORTH);
        headerPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(headerPanel, BorderLayout.NORTH);

        // Sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setBackground(new Color(240, 240, 240));
        sidebarPanel.setPreferredSize(new Dimension(200, 600));

        // Sidebar content panel
        JPanel sidebarContent = new JPanel(new GridLayout(7, 1, 10, 10));
        sidebarContent.setBackground(new Color(240, 240, 240));

        String[][] menuItems = {
                {"SNAPCHAT", "INSTAGRAM", "WHATSAPP", "THREADS", "TWITTER"},
                {"BIRTHDAYS", "HOLIDAYS", "ISLAMIC-DAYS"},
                {"DAILY OVERVIEW", "WEEKLY OVERVIEW"},
                {"REFLEX ACTION", "SMART AI RESPONSES"},
                {"PERSONAL INSIGHT", "DATA ANALYSIS"},
                {"MEETING RECAP", "MISSED HIGHLIGHT"},
                {"ENABLE MEETING MODE", "CALENDAR SYNC"}
        };

        String[] sidebarButtons = {"CLOUD SYNC", "PRIORITY ALERTS", "QUICK-BRIEF", "INSTANT REPLIES", "DASHBOARD", "IN CASE YOU MISSED IT", "MEETING MODE"};

        for (int i = 0; i < sidebarButtons.length; i++) {
            JButton button = new JButton(sidebarButtons[i]);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(72, 120, 220));
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            // Create a final copy of i (index) so that the lambda can capture it correctly
            final int index = i;

            button.addActionListener(e -> showDropdownMenu(frame, button, menuItems[index]));
            sidebarContent.add(button);
        }

        sidebarPanel.add(sidebarContent, BorderLayout.CENTER);

        // Add Exit button to the bottom of the sidebar (footer)
        JButton footerExitButton = new JButton("SIGN OUT");
        footerExitButton.setFont(new Font("Arial", Font.BOLD, 14));
        footerExitButton.setForeground(Color.WHITE);
        footerExitButton.setBackground(new Color(220, 72, 72));
        footerExitButton.setFocusPainted(false);
        footerExitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        footerExitButton.addActionListener(e -> System.exit(0));

        // Footer panel for EXIT button
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(72, 120, 220));
        footerPanel.add(footerExitButton);
        sidebarPanel.add(footerPanel, BorderLayout.SOUTH);

        frame.add(sidebarPanel, BorderLayout.WEST);

        // Main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        JLabel welcomeMessage = new JLabel("<html><div style='text-align: center;'>*CHAT BOX*<br> <br> <br>SIMPLIFY DIGITAL ERA:<br> SOLO PLATFORM, ENDLESS CONNECTIONS..!</div></html>", SwingConstants.CENTER);
        welcomeMessage.setFont(new Font("Bahnschrift Light Condensed", Font.PLAIN, 18));
        contentPanel.add(welcomeMessage, BorderLayout.CENTER);

        frame.add(contentPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to show a dropdown menu
    private static void showDropdownMenu(JFrame frame, JButton button, String[] options) {
        JPopupMenu menu = new JPopupMenu();
        for (String option : options) {
            JMenuItem menuItem = new JMenuItem(option);
            menuItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, option + " SELECTED..!"));
            menu.add(menuItem);
        }
        menu.show(button, button.getWidth() / 2, button.getHeight());
    }
}
