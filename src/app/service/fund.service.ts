import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FundService {

  constructor(private http:HttpClient) { }

  getData(portfolioId:string){
    let url = "../../assets/mockData/portfolio_perfomance.json";
    return this.http.get(url);
  }
}
