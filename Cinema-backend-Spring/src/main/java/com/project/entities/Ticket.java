package com.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Ticket implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String clientName;
	private double price;
	@Column(unique = false , nullable = true)
	private Integer paymentCode;
	private boolean booked;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private MovieProjection movieProjection;
	@ManyToOne
	private Seat seat;
	public Ticket(Long id, String clientName, double price, Integer paymentCode, boolean booked,
			MovieProjection movieProjection, Seat seat) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.price = price;
		this.paymentCode = paymentCode;
		this.booked = booked;
		this.movieProjection = movieProjection;
		this.seat = seat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public MovieProjection getMovieProjection() {
		return movieProjection;
	}
	public void setMovieProjection(MovieProjection movieProjection) {
		this.movieProjection = movieProjection;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Ticket() {
		super();
	}
	
}
