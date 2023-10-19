package com.example.restaurantedevapi.dto;

import com.example.restaurantedevapi.model.Usuario;

public class UsuarioDTO {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

        // Construtor que cria um objeto Usuario a partir de um UsuarioDTO
    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        //usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setEndereco(this.endereco);
        usuario.setTelefone(this.telefone);
        usuario.setEmail(this.email);
        return usuario;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getters e setters
    
}