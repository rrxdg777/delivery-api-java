package com.example.restaurantedevapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantedevapi.dto.UsuarioDTO;
import com.example.restaurantedevapi.model.Usuario;
import com.example.restaurantedevapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        // Aqui, você pode converter os objetos Usuario em UsuarioDTOs conforme necessário
        // e retornar a lista de DTOs.     
        List<UsuarioDTO> usuarioDTOs = usuarios.stream()
                .map(Usuario::toUsuarioDTO)
                .collect(Collectors.toList());
        return usuarioDTOs;
    }

    public UsuarioDTO buscarUsuarioPorId(int id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);        
        // Verifique se o usuário foi encontrado e, em seguida, converta-o em um DTO e retorne.
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return usuario.toUsuarioDTO(); // Converte o usuário encontrado em um DTO e retorna
        } else {
            return null; // Retorna null ou lança uma exceção personalizada se preferir
        }
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {

        // Converter o DTO em um objeto Usuario
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioDTO.getNome());
        novoUsuario.setEndereco(usuarioDTO.getEndereco());
        novoUsuario.setTelefone(usuarioDTO.getTelefone());
        novoUsuario.setEmail(usuarioDTO.getEmail());

        // Salvar o novo usuário no banco de dados
        Usuario usuarioCriado = usuarioRepository.save(novoUsuario);

        // Converter o objeto criado em um DTO e retornar
        return usuarioCriado.toUsuarioDTO();
    }

    public void atualizarUsuario(int id, UsuarioDTO usuarioDTO) {
        // Aqui, você pode atualizar os detalhes do usuário com base no ID fornecido
        // usando os dados do DTO.
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            // O usuário existe, então atualize seus detalhes com base nos dados do DTO
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNome(usuarioDTO.getNome());
            usuarioExistente.setEndereco(usuarioDTO.getEndereco());
            usuarioExistente.setTelefone(usuarioDTO.getTelefone());
            usuarioExistente.setEmail(usuarioDTO.getEmail());

            // Salve as alterações no banco de dados
            usuarioRepository.save(usuarioExistente);
        } else {
            // Trate a situação em que o usuário com o ID fornecido não existe
            throw new UsuarioNaoEncontradoException("Usuário com o ID " + id + " não encontrado");
        }
    }

    public void deletarUsuario(int id) {
        // Aqui, você pode excluir o usuário com base no ID fornecido.
    }
}
