package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Note implements Serializable {
  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  private Etudiant etudiant;

  @Column(nullable=false)
  private Float amount;

  public void setEtudiant(Etudiant etudiant) {
    this.etudiant = etudiant;
  }

  public Etudiant getEtudiant() {
    return this.etudiant;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }
}
