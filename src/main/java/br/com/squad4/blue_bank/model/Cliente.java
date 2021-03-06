package br.com.squad4.blue_bank.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Telefone> telefones = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST}, mappedBy = "cliente")
    private Endereco endereco = new Endereco();

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    private String email;


    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas = new ArrayList<>();
    
    private boolean ativo;
    

	public Cliente() {
	}

    public Cliente(String nome, String cpf, Endereco endereco, LocalDate dataNascimento, String email, Telefone telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.email = email;
        adicionarTelefone(telefone);
        this.ativo = true;
    }

    public List<Conta> getContas() {
    	return contas;
    }
 

	public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

   public void adicionarTelefone(Telefone telefone) {
        this.telefones.add(telefone);
   }

   public void setTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
    
}
