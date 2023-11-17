package br.com.exercicio;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

            //Inserir dados
            String id_isbn, nm_titulo, cod_excluir, buscaTitulo;
            int id_categoria, id_editora;
            Double vl_preco, buscaValor;

            id_isbn = JOptionPane.showInputDialog("Digite ISBN");
            nm_titulo = JOptionPane.showInputDialog("Digite título");
            id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Digite código do categoria"));
            id_editora = Integer.parseInt(JOptionPane.showInputDialog("Digite código da editora"));
            vl_preco = Double.parseDouble(JOptionPane.showInputDialog("Digite preco do livro"));
            Inserir inserir = new Inserir(id_isbn, id_categoria, id_editora, nm_titulo, vl_preco);

        //Excluir Dados
        cod_excluir = JOptionPane.showInputDialog("Digite o código:");
            Excluir excluir = new Excluir(cod_excluir);


        //Consultar Dados
        //Consulta titulo
        Consultar busca = new Consultar();
        buscaTitulo = JOptionPane.showInputDialog("Digite Titutlo para buscar");
        busca.BuscaTitulo(buscaTitulo);

        //Consulta por valor
        buscaValor =Double.parseDouble( JOptionPane.showInputDialog("Digite Titutlo para buscar"));
        busca.BuscaValor(buscaValor);
    }
}

