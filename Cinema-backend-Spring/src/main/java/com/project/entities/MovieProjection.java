package com.project.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class MovieProjection implements Serializable {
		@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
		private Long id;
		private Date dateOfProjection;
		private double price;
		@ManyToOne
		@JsonProperty(access = Access.WRITE_ONLY)
		private Room room;
		@ManyToOne
		private Movie movie;
		@ManyToOne
		private Session session;
		@OneToMany(mappedBy = "movieProjection")
		@JsonProperty(access = Access.WRITE_ONLY)
		private Collection<Ticket> tickets;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getDateOfProjection() {
			return dateOfProjection;
		}
		public void setDateOfProjection(Date dateOfProjection) {
			this.dateOfProjection = dateOfProjection;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Room getRoom() {
			return room;
		}
		public void setRoom(Room room) {
			this.room = room;
		}
		public Movie getMovie() {
			return movie;
		}
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		public Session getSession() {
			return session;
		}
		public void setSession(Session session) {
			this.session = session;
		}
		public Collection<Ticket> getTickets() {
			return tickets;
		}
		public void setTickets(Collection<Ticket> tickets) {
			this.tickets = tickets;
		}
		
		
}
