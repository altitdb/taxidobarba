import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MonthlyService {

  private url = environment.baseUrl + '/api/v1/monthly-report';

  constructor(private _httpClient: HttpClient) { }

  public get() {
    return this._httpClient.get<MonthlyReport>(this.url);
  }

}
