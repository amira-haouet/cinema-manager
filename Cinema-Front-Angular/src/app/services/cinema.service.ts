import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
  };
@Injectable({
  providedIn: 'root'
})
export class CinemaService {

  public host:string = "http://localhost:3000";

  constructor(private http:HttpClient) { }

  public getCities(){
    return this.http.get(this.host+"/cities");
  }

  public getCinemas(city){
    return this.http.get(city._links.cinemas.href);
  }

  public getRooms(cinema){
    return this.http.get(cinema._links.rooms.href);
  }

  public getMovieProjections(room){
    let url = room._links.movieProjections.href.replace("{?projection}","");
    return this.http.get(url+"?projection=p1");
  }

  public getTickets_Seats(projection){
    let url = projection._links.tickets.href.replace("{?projection}","");
    return this.http.get(url+"?projection=ticketProj");
  }

  public payTickets(dataForm){
    return this.http.post(this.host+"/payTickets",dataForm);

  }

 /* ajouterCinema( prod: Cinema):Observable<Cinema>{
    return this.http.post<Cinema>(this.host, prod, httpOptions);
    }*/
    public listeCinemas(){
      //console.log(this.http.get<Ville[]>(this.host+"/vil"));
      return this.http.get(this.host);
    }
}
