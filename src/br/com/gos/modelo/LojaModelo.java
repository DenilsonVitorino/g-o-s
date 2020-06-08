/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.modelo;

/**
 *
 * @author dv22p
 */
public class LojaModelo 
{
    private String id;
    private String nome;
    private String cnpj;
    private String fone;
    private String email;
    private String cadastro;
    private String pgto;
    private String bloqueado;
    private String mensagem;

    public LojaModelo()
    {
    }

    public LojaModelo(String id, String nome, String cnpj, String fone, String email, String cadastro, String pgto, String bloqueado, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.fone = fone;
        this.email = email;
        this.cadastro = cadastro;
        this.pgto = pgto;
        this.bloqueado = bloqueado;
        this.mensagem = mensagem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getPgto() {
        return pgto;
    }

    public void setPgto(String pgto) {
        this.pgto = pgto;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
