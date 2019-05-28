import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TravelService {

  url = environment.baseUrl + '/api/v1/cash/travel';
  HEADERS = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private _httpClient: HttpClient) { }

  save(data) {
    if (data.id === undefined) {
      return this._httpClient.post<TravelResponse>(this.url, data, {
        headers: this.HEADERS
      });
    }
    return this._httpClient.put<TravelResponse>(this.url, data, {
      headers: this.HEADERS
    });
  }

  get(id) {
    return this._httpClient.get<TravelResponse>(`${this.url}/${id}`, {
      headers: this.HEADERS
    });
  }
}
