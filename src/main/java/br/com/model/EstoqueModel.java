package br.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Carlos
 * Java Persistence API 
 */

@Entity
@Table(name = "tbprodutos")
public class EstoqueModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Incremente
    private int estoque_id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "unidade")
    private String unidade;
    
    @Column(name = "preco")
    private float preco;
    
    @Column(name = "estoque")
    private int estoque;

    public EstoqueModel() {
    }
    
    public EstoqueModel(String descricao, String codigo, String unidade, float preco, int estoque) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.unidade = unidade;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    public int getEstoque_id() {
        return estoque_id;
    }

    public void setEstoque_id(int estoque_id) {
        this.estoque_id = estoque_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
