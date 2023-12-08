package com.example.demo.entidades;

import java.time.LocalDateTime;

public class Evento {
	private String titulo;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFinal;
	private int id;

	public Evento(String titulo, LocalDateTime dataInicio, LocalDateTime dataFinal) {
		this.titulo = titulo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public Evento() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean ehEventoFuturo() {
		return dataInicio.isAfter(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "Evento{" + "id='" + id + '\'' + "titulo='" + titulo + '\'' + ", dataInicio=" + dataInicio
				+ ", dataFinal=" + dataFinal + '}';
	}
}