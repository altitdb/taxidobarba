import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FuelService {

  url = environment.baseUrl + '/api/v1/fuel';
  
  constructor(private _httpClient: HttpClient) { }

  save(data) {
    const HEADERS = new HttpHeaders().set('Content-Type', 'application/json');
    return this._httpClient.post<FuelResponse>(this.url, data, {
      headers: HEADERS
    });
  }

}
