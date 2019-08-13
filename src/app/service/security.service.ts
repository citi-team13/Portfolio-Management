
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

  getManager(){
    this.url='../../assets/mockData/updateData.json';
    return this.http.get(this.url)
  }
  
  getFundList(){
    this.url='../../assets/mockData/fundlistData.json';
    return this.http.get(this.url)
  }
  getEquityList(){
    this.url='../../assets/mockData/equityListData.json';
    return this.http.get(this.url)
  }
  getFundList2(){
    this.url='../../assets/mockData/bondlistData.json';
    return this.http.get(this.url)
  }
}
