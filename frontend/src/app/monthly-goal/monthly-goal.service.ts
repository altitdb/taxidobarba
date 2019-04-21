import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MonthlyGoalService {

  url = environment.baseUrl + '/api/v1/monthly-goal';

  constructor(private _httpClient: HttpClient) { }

  get() {
    const HEADERS = new HttpHeaders().set('Content-Type', 'application/json');
    return this._httpClient.get<MonthlyGoal>(this.url, {
      headers: HEADERS
    });
  }

}
