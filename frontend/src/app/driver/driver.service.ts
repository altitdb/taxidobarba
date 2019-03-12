import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  private url = 'https://taxidobarba.herokuapp.com/api/v1/driver/findAll';

  constructor(public _http: HttpClient) { 
    this._http = _http;
  }

  public get() {
    return this._http.get<Array<Driver>>(this.url);
  }
 
}