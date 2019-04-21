import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AnnualSummaryService {

  url = environment.baseUrl + '/api/v1/annual-summary';

  constructor(private _httpClient: HttpClient) { }

  get() {
    const HEADERS = new HttpHeaders().set('Content-Type', 'application/json');
    return this._httpClient.get<AnnualSummary>(this.url, {
      headers: HEADERS
    });
  }
}
