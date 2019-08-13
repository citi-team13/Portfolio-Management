import { Component, OnInit,Input, Output,EventEmitter  } from '@angular/core';
import {SecurityService} from '../../service/security.service';

@Component({
  selector: 'app-auto-security-match',
  templateUrl: './auto-security-match.component.html',
  styleUrls: ['./auto-security-match.component.scss']

})
export class AutoSecurityMatchComponent implements OnInit {
  innerValue: any = "HELLO";

  filteredCountriesSingle: any[];

  constructor(private countryService: SecurityService) { }

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

  ngOnInit() {
    
  }


}
