import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  private url = environment.baseUrl + '/api/v1/driver';

  constructor(public _http: HttpClient) { }

  public get() {
    return this._http.get<Array<Driver>>(this.url);
  }

  public getActive() {
    return this._http.get<Array<Driver>>(this.url);
  }
 
}
