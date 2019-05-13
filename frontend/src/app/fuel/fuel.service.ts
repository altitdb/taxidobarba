import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FuelService {

  url = environment.baseUrl + '/api/v1/fuel';
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  
  constructor(private _httpClient: HttpClient) { }

  save(data) {
    if (data.id === null) {
      return this._httpClient.post<FuelResponse>(this.url, data, {
        headers: this.headers
      });
    }
    return this._httpClient.put<FuelResponse>(this.url, data, {
      headers: this.headers
    });
  }

  get(id) {
    return this._httpClient.get<FuelResponse>(`${this.url}/${id}`, {
      headers: this.headers
    });
  }

}
