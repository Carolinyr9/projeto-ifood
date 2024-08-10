package model;

public class Usuario {
    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    	
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void logarUsuário(String email,String senha) {
    	setEmail(email);
    	setSenha(senha);
    }

    public void cadastrarUsuario() {
        // Implementar lógica para cadastrar o usuário
        System.out.println("Usuário cadastrado: " + this.toString());
    }

    public void editarUsuario(String novoEmail, String novaSenha) {
        setEmail(novoEmail);
        setSenha(novaSenha);
        System.out.println("Usuário editado: " + this.toString());
    }

    public void desativarUsuario() {
        // Implementar lógica para desativar o usuário
        System.out.println("Usuário desativado: " + this.toString());
    }

    @Override
    public String toString() {
        return "Usuário" +
               "\nE-mail: " + email +
               "\nSenha: " + senha;
    }
}

