import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private url = environment.baseUrl + '/api/v1/car';

  constructor(public _http: HttpClient) { }

  public getActive() {
    return this._http.get<Array<Car>>(this.url);
  }
  
}
