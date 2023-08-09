package org.example;


import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(Main::createAndShowGUI);
        }

        private static void createAndShowGUI() {
            JFrame frame = new JFrame("Async Array and Buttons");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel();
            frame.add(buttonPanel, BorderLayout.CENTER);

            List<String> data = new ArrayList<>();

            // Создаем отдельный поток для заполнения массива
            Thread fillArrayThread = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000); // Имитация задержки при добавлении элемента в массив
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String element = "Button " + (i + 1);
                    data.add(element);
                    SwingUtilities.invokeLater(() -> addButton(buttonPanel, element)); // Отрисовка кнопки в основном потоке
                }
            });

            fillArrayThread.start();

            frame.pack();
            frame.setVisible(true);
        }

        private static void addButton(JPanel panel, String text) {
            JButton button = new JButton(text);
            panel.add(button);
            //panel.revalidate(); // Обновление панели для отображения новой кнопки
        }

        private void print(){
            System.out.println("SSSSSSSSSSSSSSSSSSSOOOOOOOOOOOOOOOOOSSSSSSSSSSSSSSSSSS");
        }
    }

