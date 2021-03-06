package MesAplication.resControler.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;



/**
 * @author dratajczyk
 *
 */
/**
 * @author dratajczyk
 *
 */
@Entity
public class produkcja  {
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
//@SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
long id;

@Size(min = 2, max = 12)
String maszyna;

String operacja;

String czas;
@Size(min = 4, max = 8)
String material;

@Min(1)
@Max(6000)
String opis;

String norma;






public String getNorma() {
	return norma;
}




public void setNorma(String norma) {
	this.norma = norma;
}




public long getId() {
	return id;
}




public void setId(long id) {
	this.id = id;
}




public produkcja() {
	
}




public produkcja(String maszyna, String operacja, String czas, String material, String opis) {
	this.maszyna = maszyna;
	this.operacja = operacja;
	this.czas = czas;
	this.material = material;
	this.opis = opis;

}

public String getMaszyna() {
	return maszyna;
}
public void setMaszyna(String maszyna) {
	this.maszyna = maszyna;
}


public String getMaterial() {
	return material;
}
public void setMaterial(String material) {
	this.material = material;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}



public String getOperacja() {
	return operacja;
}
public void setOperacja(String operacja) {
	this.operacja = operacja;
}
public String getCzas() {
	return czas;
}
public void setCzas(String czas) {
	this.czas = czas;
}

public interface materialandcount{
	String getMaterial();
	String getOpis();
}


}
