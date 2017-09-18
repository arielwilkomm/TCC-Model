package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "compra")
public class Compra implements Serializable{
@NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    @Min(value = 0, message = "O valor não pode ser negativo")
	private Double valor;
@Id
    @SequenceGenerator(name = "seq_compra", sequenceName = "seq_compra_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_compra", strategy = GenerationType.SEQUENCE)
	private Integer id;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
	private Calendar data;
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_pessoa"))
	private Pessoa pessoa;
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CompraItens> itens = new ArrayList<>();
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ContasPagar> contasPagar = new ArrayList<>();

    public Compra(Double valor, Integer id, Calendar data, Pessoa pessoa) {
        this.valor = valor;
        this.id = id;
        this.data = data;
        this.pessoa = pessoa;
    }

    public Compra() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<CompraItens> getItens() {
        return itens;
    }

    public void setItens(List<CompraItens> itens) {
        this.itens = itens;
    }

    public List<ContasPagar> getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(List<ContasPagar> contasPagar) {
        this.contasPagar = contasPagar;
    }

    
}
