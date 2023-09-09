package edu.Formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {
    private JPanel jPanelPrincipal;
    private JComboBox comboBoxToppings;
    private JTextField txtPizza;
    private JButton btnAgregarIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btbPrepararPizza;
    private List<Topping> ingredientes = new ArrayList<>();
    private DefaultListModel modeloLista = new DefaultListModel();
    private double total = 0;

    public frmPizza() {
        cargarToppings();
        btnAgregarIngrediente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();
                DefaultListModel modeloLista = new DefaultListModel();
                modeloLista.addElement(ingrediente);
                lista1.setModel(modeloLista);
                 total += ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));
            }
        });
        btbPrepararPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for ( int i = 0; i<lista1.getModel().getSize();i++){
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();

                JOptionPane.showMessageDialog(null, "Pizza preparada: " + txtPizza.getText() + " Total: " + total);
                    //mostrar el nombre de la pizza y el total

//                Pizza pizza = new Pizza(txtPizza.getText());
//                Topping topi;

//                for( int  i = 0; i<lista1.getModel().getSize();i++);
//                {
//
//                    topi = (Topping) lista1.getModel().getElementAt(i);
//                    pizza.addTopping(topi);
//
//                }
//                pizza.prepare();
//           //     JOptionPane.showMessageDialog(null, "Pizza preparada: " + nombrePizza + " Total: " + total);
//
            }
        });
    }

    //cargar toppings
    private void cargarToppings(){
        ingredientes.add(new Topping("champinoes", 10));
        ingredientes.add(new Topping("jamon", 20));
        ingredientes.add(new Topping("peperoni", 30));
        ingredientes.add(new Topping("salchicha", 40));
        ingredientes.add(new Topping("Cebolla", 50));
        ingredientes.add(new Topping("Aceitunas negras", 60));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxToppings.setModel(model);


    }

    public JPanel getjPanelPrincipal() {
        return jPanelPrincipal;

    }
}
