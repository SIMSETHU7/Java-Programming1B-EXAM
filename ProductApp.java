package productapp;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {

    private final JTextField txtCustomer;
    private final JComboBox<String> cmbProduct;
    private final JTextField txtPrice;
    private final JButton btnProcess;

    public ProductApp() {

        setTitle("Product App");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Create form components
        JLabel lblCustomer = new JLabel("Customer Name:");
        JLabel lblProduct = new JLabel("Select Product:");
        JLabel lblPrice = new JLabel("Enter Price:");

        txtCustomer = new JTextField(20);

        cmbProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        });

        txtPrice = new JTextField(20);

        btnProcess = new JButton("PROCESS");

        // Create layout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));

        panel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        panel.add(lblCustomer);
        panel.add(txtCustomer);

        panel.add(lblProduct);
        panel.add(cmbProduct);

        panel.add(lblPrice);
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);

        // Process button
        btnProcess.addActionListener(e -> processProduct());

        // Process menu item
        processItem.addActionListener(e -> processProduct());

        // Clear menu item
        clearItem.addActionListener(e -> clearForm());

        // Exit menu item
        exitItem.addActionListener(e -> System.exit(0));
    }

    private void processProduct() {

        String customer = txtCustomer.getText().trim();

        String product = (String) cmbProduct.getSelectedItem();

        try {

            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, "Please enter customer name."
                );
                return;
            }

            double price = Double.parseDouble(
                txtPrice.getText().trim()
            );

            if (price <= 0) {
                JOptionPane.showMessageDialog(
                    this, "Please enter a valid price."
                );
                return;
            }

            // Create calculation object
            ProductCalculations calculation =
                new ProductCalculations(price);

            double vat = calculation.GetVat();

            double commission = calculation.GetCommission();

            double total = calculation.GetTotal();

            // Display results
            String message =
                "Customer Name: " + customer +
                "\nProduct: " + product +
                "\nVAT: R " + String.format("%.2f", vat) +
                "\nCOMMISSION: R " +
                String.format("%.2f", commission) +
                "\nTOTAL: R " + String.format("%.2f", total);

            JOptionPane.showMessageDialog(
                this, message, "Message",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Save information to data.txt
            saveToFile(customer, product, vat, commission, total);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this, "Please enter a valid numeric price."
            );

        }
    }

    private void saveToFile(
        String customer,
        String product,
        double vat,
        double commission,
        double total
    ) {

        try (PrintWriter writer =
             new PrintWriter(new FileWriter("data.txt", true))) {

            writer.println("DATA LOG");
            writer.println("-----------------------------");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.println("VAT: R " + String.format("%.2f", vat));
            writer.println("COMMISSION: R " +
                    String.format("%.2f", commission));
            writer.println("TOTAL: R " +
                    String.format("%.2f", total));
            writer.println("-----------------------------");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                this, "Error saving data to file."
            );

        }
    }

    private void clearForm() {

        txtCustomer.setText("");
        txtPrice.setText("");

        cmbProduct.setSelectedIndex(0);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });

    }
}
