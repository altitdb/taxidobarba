import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  url = environment.baseUrl + '/api/v1/cash/city';
  HEADERS = new HttpHeaders().set('Content-Type', 'application/json');
  
  constructor(private _httpClient: HttpClient) { }

  save(data) {
    return this._httpClient.post<CityResponse>(this.url, data, {
      headers: this.HEADERS
    });
  }

  update(id, data) {
    return this._httpClient.put<CityResponse>(`${this.url}/${id}`, data, {
      headers: this.HEADERS
    });
  }

  get(id) {
    return this._httpClient.get<CityResponse>(`${this.url}/${id}`, {
      headers: this.HEADERS
    });
  }
}
