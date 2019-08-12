import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  url:string;

  constructor(private http:HttpClient) { }

  getCountries() {
    this.url = "../../assets/test.json";
    return this.http.get(this.url);
}

getMarket(){
  this.url='../../assets/fundManager.json';
  return this.http.get(this.url);
  }
}
