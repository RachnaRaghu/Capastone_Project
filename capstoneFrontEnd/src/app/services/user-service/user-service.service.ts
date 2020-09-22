import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  serviceUrl = 'http://localhost:9091';

  constructor(
    private http: HttpClient
  ) { }

  saveSurveyResponse(data: any) {
    return this.http.post(this.serviceUrl + '/user/saveResponse', data);
  }

  checkUser(data: any) {
    return this.http.post(this.serviceUrl + '/user/checkUser', data);
  }
  createUser(data) {
    return this.http.post(this.serviceUrl + '/user/createUser', data);
  }
  login(data) {
    return this.http.post(this.serviceUrl + '/user/login', data);
  }
}
