package com.project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Room implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30)
	private String name;
	private int numberOfSeats;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cinema cinema;
	@OneToMany(mappedBy = "room")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Seat> seats;
	@OneToMany(mappedBy = "room")
	private Collection<MovieProjection> movieProjections;
	public Room(Long id, String name, int numberOfSeats, Cinema cinema, Collection<Seat> seats,
			Collection<MovieProjection> movieProjections) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.cinema = cinema;
		this.seats = seats;
		this.movieProjections = movieProjections;
	}
	public Room() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public Collection<Seat> getSeats() {
		return seats;
	}
	public void setSeats(Collection<Seat> seats) {
		this.seats = seats;
	}
	public Collection<MovieProjection> getMovieProjections() {
		return movieProjections;
	}
	public void setMovieProjections(Collection<MovieProjection> movieProjections) {
		this.movieProjections = movieProjections;
	}

	
}
