package rickalon.aexcea.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aexcea_users")
@JsonIgnoreProperties(ignoreUnknown=true)
public class AexceaUser {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable=false, length=200)
    @JsonProperty("name")
    private String name;

    @Column(nullable=false)
    @JsonProperty("age")
    private Integer age;

    public AexceaUser(){
        super();
    }

    public AexceaUser(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public void setID(Long ID){
        this.ID = ID;
    }

    public Long getID(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return age;
    }
}
