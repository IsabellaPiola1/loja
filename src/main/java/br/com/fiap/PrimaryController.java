package br.com.fiap;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.fiap.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML
    private TextField TextFieldNome;
    @FXML
    private TextField TextFieldEmail;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private ChoiceBox<String> choiceBoxPerfil;

    
    public void salvar() {
        var usuario = carregardadosDoformulario();
        System.out.println(usuario);

        // conexao (servidor,  usuario, senha, base)
        String servidor = "oracle.fiap.com.br";
        //String baseDeDados = "";
        String username = "RM93960";
        String senha = "260703";
        String url = "jdbc:oracle:thin:@" + servidor + ":1521/orcl";

        try{
            System.out.println("Conectando...")
            Connection conexao = DriverManager.getConnection(url, username, senha);
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private Usuario carregardadosDoformulario(){
        var usuario = new Usuario(
            TextFieldNome.getText(),
            TextFieldEmail.getText(),
            PasswordField.getText(),
            choiceBoxPerfil.getValue()
        );
        return usuario;
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBoxPerfil.getItems().addAll("Vendedor", "Gerente", "administrador");     
    }
}
