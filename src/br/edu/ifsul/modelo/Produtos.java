package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "produtos")
public class Produtos implements Serializable{

	@Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O Nome não pode ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
@NotNull(message = "O preço não pode ser nulo")
    @Min(value = 0, message = "O Preço não pode ser negativo")
    @Column(name = "preco", nullable = false, columnDefinition = "numeric(12,2)")
    private Double preco;

    public Produtos() {
    }

    public Produtos(String nome, Integer id, Double preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Produtos other = (Produtos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
        
        

}
