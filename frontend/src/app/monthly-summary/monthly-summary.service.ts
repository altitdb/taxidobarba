import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root"
})
export class MonthlySummaryService {
  url = environment.baseUrl + "/api/v1/actual-month-summary";

  constructor(private _httpClient: HttpClient) {}

  get() {
    const HEADERS = new HttpHeaders().set("Content-Type", "application/json");
    return this._httpClient.get<MonthlySummary>(this.url, {
      headers: HEADERS
    });
  }
}
