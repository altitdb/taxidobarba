import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TrafficTicketService {

  url = environment.baseUrl + '/api/v1/traffic-ticket';
  mensagem: String;

  constructor(private _httpClient: HttpClient) { }

  save(data) {
    const HEADERS = new HttpHeaders().set('Content-Type', 'application/json');
    return this._httpClient.post(this.url, data, {
      headers: HEADERS
    });
  }

  getAll() {
    const HEADERS = new HttpHeaders().set('Content-Type', 'application/json');
    return this._httpClient.get<TrafficTicketResponse>(`${this.url}`, {
      headers: HEADERS
    });
  }
}
