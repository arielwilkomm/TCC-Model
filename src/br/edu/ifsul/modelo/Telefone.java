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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_telefone", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O numero não pode ser nulo")
    @Length(max = 14, message = "O numero não pode ter mais que {max} caracteres")
    @NotBlank(message = "O numero não pode ser em branco")
    @Column(name = "numero", length = 14, nullable = false)
    private String numero;
    @NotNull(message = "A pessoa não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false,
            foreignKey = @javax.persistence.ForeignKey(name = "fk_pessoa"))
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(Integer id, String numero, Pessoa pessoa) {
        this.id = id;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



}
