package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contasPagar")
public class ContasPagar implements Serializable{

    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    @Min(value = 0, message = "O valor não pode ser negativo")
    private Double total;

    private Boolean pago;
    @Id
    @SequenceGenerator(name = "seq_contas_pagar", sequenceName = "seq_contas_pagar_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_contas_pagar", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A compra deve ser informada")
    @ManyToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "id", nullable = false, 
            foreignKey = @javax.persistence.ForeignKey(name = "fk_compra"))    
    private Compra compra;

    public ContasPagar(Calendar data, Double total, Boolean pago, Integer id) {
        this.data = data;
        this.total = total;
        this.pago = pago;
        this.id = id;
    }

    public ContasPagar() {
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final ContasPagar other = (ContasPagar) obj;
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
