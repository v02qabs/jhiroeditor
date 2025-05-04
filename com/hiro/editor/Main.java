package com.hiro.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main extends JFrame {

    private JTextArea textArea;
    private JButton saveButton;
    private JButton saveAsButton;
    private JButton openButton;
    private JButton newButton;
    private JButton makeButton;       // For "make"
    private JButton makeAllButton;    // For "make all"
    private File currentFile = null;
    private File makefile = null;

    public static void main(String[] args) {
        System.out.println("Hello editor.");
        SwingUtilities.invokeLater(() -> new Main().initWindow());
    }

    public Main() {
        // コンストラクタ
    }

    private void initWindow() {
        setTitle("Hello Editor");
        setBounds(0, 0, 900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // UIパーツ初期化
        textArea = new JTextArea();
        saveButton = new JButton("上書き保存");
        saveAsButton = new JButton("名前を付けて保存");
        openButton = new JButton("開く");
        newButton = new JButton("新規");
        makeButton = new JButton("Make");          // Initialize "Make" button
        makeAllButton = new JButton("Make All");   // Initialize "Make All" button

        // ボタンのリスナー設定
        saveButton.addActionListener(e -> saveToCurrentFile());
        saveAsButton.addActionListener(e -> saveAsNewFile());
        openButton.addActionListener(e -> openFile());
        newButton.addActionListener(e -> newFile());
        makeButton.addActionListener(e -> executeMakeCommand());       // Listener for "Make"
        makeAllButton.addActionListener(e -> executeMakeAllCommand()); // Listener for "Make All"

        // レイアウト
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAsButton);
        buttonPanel.add(openButton);
        buttonPanel.add(newButton);
        buttonPanel.add(makeButton);       // Add "Make" button
        buttonPanel.add(makeAllButton);    // Add "Make All" button

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add a menu for Makefile selection
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem selectMakefileItem = new JMenuItem("Select Makefile");
        selectMakefileItem.addActionListener(e -> selectMakefile());
        fileMenu.add(selectMakefileItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    private void selectMakefile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Makefile");
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            makefile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Makefile selected: " + makefile.getAbsolutePath(), "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void saveToCurrentFile() {
        if (currentFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "上書き保存完了！");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "保存中にエラーが発生しました: " + ex.getMessage(), "エラー", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            saveAsNewFile();
        }
    }

    private void saveAsNewFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            saveToCurrentFile();
        }
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                currentFile = selectedFile;
                setTitle("Hello Editor - " + selectedFile.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "読み込み中にエラーが発生しました: " + ex.getMessage(), "エラー", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void newFile() {
        textArea.setText("");
        currentFile = null;
        setTitle("Hello Editor - 新規ファイル");
    }

    private void executeMakeCommand() { // For "make"
        executeMakeCommand(""); // Call the common method with empty target
    }

    private void executeMakeAllCommand() { // For "make all"
        executeMakeCommand("all"); // Call the common method with "all" target
    }

    private void executeMakeCommand(String target) { // Common make execution method
        if (currentFile == null) {
            JOptionPane.showMessageDialog(this, "ファイルを保存してください。", "エラー", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (makefile == null) {
            JOptionPane.showMessageDialog(this, "Makefile を選択してください。", "エラー", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Get the directory of the Makefile
            String makefileDirectory = makefile.getParent();

            // Build the make command
            String makeCommand = "make";
            if (!target.isEmpty()) {
                makeCommand += " " + target;
            }
            makeCommand += " -f " + makefile.getName();

            // Execute the make command
            Process process = Runtime.getRuntime().exec(makeCommand, null, new File(makefileDirectory));

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Read the error stream
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder errorOutput = new StringBuilder();
            while ((line = errorReader.readLine()) != null) {
                errorOutput.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Display the output and error messages
            String commandDescription = "Make";
            if (!target.isEmpty()) {
                commandDescription += " " + target;
            }

            if (exitCode == 0) {
                JOptionPane.showMessageDialog(this, commandDescription + " 実行完了!\n" + output.toString(), "成功", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, commandDescription + " 実行失敗 (終了コード: " + exitCode + "):\n" + output.toString() + "\n" + errorOutput.toString(), "エラー", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(this, "Make 実行中にエラーが発生しました: " + ex.getMessage(), "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
}
