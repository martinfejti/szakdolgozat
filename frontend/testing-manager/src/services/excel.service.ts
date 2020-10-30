import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExcelService {

  constructor(private httpClient: HttpClient) { }

  exportProject(id: number) {
    return this.httpClient.post(`http://localhost:8080/excel/exportProject/${id}`, {});
  }

  exportComponent(id: number) {
    return this.httpClient.post(`http://localhost:8080/excel/exportComponent/${id}`, {});
  }
}
