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
public class OsModelo 
{
    private String os;
    private String emissao;
    private String tipo;
    private String situacao;
    private String equipamento;
    private String defeito;
    private String servico;
    private String entrega;
    private String valor;
    private String idCliente;
    private String nomeCliente;
    private String alterado;
    private String responsavel;
    private String loja;
    private String totalDia;
    private String totalMes;

    public OsModelo()
    {
    }

    public OsModelo(String os, String emissao, String tipo, String situacao, String equipamento, String defeito, String servico, String entrega, String valor, String idCliente, String nomeCliente, String alterado, String responsavel, String loja, String totalDia, String totalMes) {
        this.os = os;
        this.emissao = emissao;
        this.tipo = tipo;
        this.situacao = situacao;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.entrega = entrega;
        this.valor = valor;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.alterado = alterado;
        this.responsavel = responsavel;
        this.loja = loja;
        this.totalDia = totalDia;
        this.totalMes = totalMes;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getAlterado() {
        return alterado;
    }

    public void setAlterado(String alterado) {
        this.alterado = alterado;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getTotalDia() {
        return totalDia;
    }

    public void setTotalDia(String totalDia) {
        this.totalDia = totalDia;
    }

    public String getTotalMes() {
        return totalMes;
    }

    public void setTotalMes(String totalMes) {
        this.totalMes = totalMes;
    }
}
