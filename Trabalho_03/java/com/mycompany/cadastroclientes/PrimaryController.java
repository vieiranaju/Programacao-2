package com.mycompany.cadastroclientes;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField cepField;
    @FXML
    private TextField ruaField;
    @FXML
    private TextField numeroField;
    @FXML
    private TextField cidadeField;
    @FXML
    private TextField estadoField;
    @FXML
    private TextField telefoneField;
    @FXML
    private Button buscarButton;
    @FXML
    private Button limparButton;
    @FXML
    private Button gravarButton;

    private Buscador buscador = new Buscador();
    
    private ArrayList<Cliente> clientesList = new ArrayList<>();

    @FXML
    private void buscarCep() {
        String cep = cepField.getText();
        try {
            Endereco endereco = buscador.buscar(cep);
            ruaField.setText(endereco.getRua());
            cidadeField.setText(endereco.getCidade());
            estadoField.setText(endereco.getEstado());
        } catch (IllegalArgumentException e) {
            mostrarMensagemErro("Formato de CEP inválido.");
        } catch (IOException e) {
            mostrarMensagemErro("Erro ao buscar o CEP: " + e.getMessage());
        } catch (Exception e) {
            mostrarMensagemErro("Erro desconhecido: " + e.getMessage());
        }
    }
    
     private void mostrarMensagemErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void limparCampos() {
        nomeField.clear();
        cepField.clear();
        ruaField.clear();
        numeroField.clear();
        cidadeField.clear();
        estadoField.clear();
        telefoneField.clear();
    }

    @FXML
    private void gravarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(nomeField.getText());
        cliente.setTelefone(telefoneField.getText());
        cliente.setEndereco(new Endereco(cepField.getText(), ruaField.getText(), numeroField.getText(), cidadeField.getText(), estadoField.getText()));
        clientesList.add(cliente);
        mensagemConfirmacao("Cliente cadastrado com sucesso!");
    }
    
    private void mensagemConfirmacao(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
