package com.evento.evento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String local;

    public Evento(EventoDados dados) {
        this.nome = dados.nome();
        this.data = dados.data();
        this.local = dados.local();
    }

    public Evento() {}

    public void atualizaEvento(EventoUpdateDados dados){
        this.nome = dados.nome();
        this.data = dados.data();
        this.local = dados.local();
    }




    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Evento [id=" + id + ", nome=" + nome + ", data=" + data + ", local=" + local + "]";
    }
}
