package sb;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class TestJFilePicker extends JFrame {

    private static final long serialVersionUID = -1306503706164574884L;

    public TestJFilePicker() {
        super("Test using JFilePicker");

        setLayout(new FlowLayout());

        // set up a file picker component
        final JFilePicker filePicker = new JFilePicker("Pick a file", "Browse...");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".jpg", "JPEG Images");
        filePicker.addFileTypeFilter(".mp4", "MPEG-4 Videos");
        final String locationMyProfiles = "D:\\HibSpring";

        // access JFileChooser class directly
        final JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("D:/"));

        JButton jButton = new JButton("enter");

        add(jButton);
        // add the component to the frame
        add(filePicker);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 100);
        setLocationRelativeTo(null);    // center on screen

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ProcessBuilder processBuilder = new ProcessBuilder("mv "+fileChooser.getCurrentDirectory()+locationMyProfiles);
                    processBuilder.start();
                }catch (Exception e1){
                    System.err.println("Didn't add cert to profile");
                }
            }
        });

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestJFilePicker().setVisible(true);
            }
        });


//        ProcessBuilder processBuilder = new ProcessBuilder("%userprofile%\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\%randomalphanum%.default\\");
//        try {
//            processBuilder.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}