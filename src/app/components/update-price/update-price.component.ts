import { Component, OnInit } from '@angular/core';
import {UserService} from '../../service/user.service';
import {SelectItem} from 'primeng/api';
import {SecurityService} from '../../service/security.service';

interface security{
  name:string;
  sid:number;
}

@Component({
  selector: 'app-update-price',
  templateUrl: './update-price.component.html',
  styleUrls: ['./update-price.component.scss']
})
export class UpdatePriceComponent implements OnInit {
  noSpecial: RegExp = /^[^<>*!]+$/
  
  security1:SelectItem[];
  selectedItem:security;
  SecurityName:string;
  SecurityPrice:number;


  constructor(private countryService: SecurityService) { 
    this.initSelectOption();
  }

  ngOnInit() {
  }


  initSelectOption(){
    this.security1=[
      {label:'Bond',value:{name:"Bond",sid:0}},
      {label:'Equity',value:{name:"Equity",sid:1}},
      {label:'Future',value:{name:"Future",sid:2}},
      {label:'FX',value:{name:"FX",sid:3}}
    ];

    this.selectedItem = this.security1[0].value;
  }

  updateSecurity(){
    console.log(this.selectedItem);
    console.log(this.SecurityName);
    console.log(this.SecurityPrice);
  }


/*  AUTO COMPLETE START*/
// 实现自定义 双向绑定失败， 可升级
  filteredCountriesSingle: any[];


  filterCountrySingle(event) {
      let query = event.query;
      this.countryService.getCountries().subscribe(countries => {
          this.filteredCountriesSingle = this.filterCountry(query, countries);
      });
  }

  filterCountry(query, countries: any):any[] {
    //in a real application, make a request to a remote url with the query and return filtered results, for demo we filter at client side
    let filtered : any[] = [];
    for(let i = 0; i < countries.length; i++) {
        let country = countries[i];
        if(country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
            filtered.push(country);
        }
    }
    return filtered;
}

/* AUTO COMPLETE OVER*/




}
