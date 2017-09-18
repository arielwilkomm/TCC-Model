package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "compraItens")
public class CompraItens implements Serializable{

@Id
    @SequenceGenerator(name = "seq_compra_itens", sequenceName = "seq_compra_itens_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_compra_itens", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "numeric(12,2)")
    private Integer quantidade;
    @NotNull(message = "O valor unitário deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorUnitario;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    @NotNull(message = "O produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_produto"))
    private Produtos produtos;
    @NotNull(message = "A compra deve ser informada")
    @ManyToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "id", nullable = false, 
            foreignKey = @javax.persistence.ForeignKey(name = "fk_compra"))    
    private Compra compra;

    public CompraItens(Integer id, Double valorUnitario, Double valorTotal, Integer quantidade, Produtos produtos) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
        this.produtos = produtos;
    }

    public CompraItens() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompraItens other = (CompraItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

}
