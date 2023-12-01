package com.example.demo.entidades;

import java.time.LocalDateTime;

public class Evento {
	private String titulo;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFim;
	private int id;

	public Evento(String titulo, LocalDateTime horarioInicio, LocalDateTime horarioFim) {
		this.titulo = titulo;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
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

	public LocalDateTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalDateTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalDateTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalDateTime horarioFim) {
		this.horarioFim = horarioFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEventoFuturo() {
		return horarioInicio.isAfter(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "Evento{" + "id='" + id + '\'' + "titulo='" + titulo + '\'' + ", horarioInicio=" + horarioInicio
				+ ", horarioFim=" + horarioFim + '}';
	}
}