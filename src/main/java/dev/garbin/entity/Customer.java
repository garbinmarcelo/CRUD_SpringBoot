package dev.garbin.entity;

import javax.persistence.*;

/**
 * appspring_gradle
 *
 * @author Marcelo Garbin
 * @version 1.0
 */
@Entity
public class Customer{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer age;

    public Customer(){}

    public Customer(String name, Integer age){
        this.name = name;
        this.age  = age;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
