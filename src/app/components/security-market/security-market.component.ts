import { Component, OnInit } from '@angular/core';
import {DropdownModule} from 'primeng/dropdown';
import {SelectItem} from 'primeng/api';
import{SecurityService} from '../../service/security.service';

import {DialogService} from 'primeng/api';
import {DynamicDialogRef} from 'primeng/api';
import {DynamicDialogConfig} from 'primeng/api';
import {FundChartComponent} from '../../components/market/fund-chart/fund-chart.component';
interface City {
  type: string;
  code: string;
}
@Component({
  selector: 'app-security-market',
  templateUrl: './security-market.component.html',
  styleUrls: ['./security-market.component.scss'],
  providers:[DialogService]  
})

export class SecurityMarketComponent implements OnInit {
  options: City[];
  list:Array<any>;
  currentData:Array<any>;
  currentPage:number=0;
  perPageNum :number= 8;
  selectedCity:City;
  code:number=1;
  constructor(private service :SecurityService,public dialogService: DialogService) { 
    this.options = [
      {type:"Equity",code:'1'},
      {type:"Bond",code:'2'}
    ];
    this.selectedCity = this.options[0]
    this.setData(this.selectedCity.code);
  }

  ngOnInit() {

  }
  setData(code){
    if(code == '1'){
      this.service.getEquityList().subscribe(data=>{
        this.list = JSON.parse(JSON.stringify(data));
        this.currentData = this.list.slice(0,this.perPageNum);
      })
    }else{
      this.service.getFundList2().subscribe(data=>{
        this.list = JSON.parse(JSON.stringify(data));
          this.currentData = this.list.slice(0,this.perPageNum);
      })
    }
  }

  getTypeData(code){
    this.setData(code);
  }

  toggle(index){
    this.currentData[index].isShow = !this.currentData[index].isShow;
    console.log('change!',this.currentData[index].content[0]);
  }
  chartShow(){    
    const ref = this.dialogService.open(FundChartComponent,{
      header:'chart',
      width:'60%'
    });
  }
  pageChange(event){
     //console.log('event page',event.page)
     this.currentPage = event.page;

     console.log(this.currentPage)
     if(this.currentPage*this.perPageNum>(this.list.length-1)){
       //重新请求数据
     }
     else{
       this.currentData = this.list.slice(this.currentPage*this.perPageNum,Math.min(this.currentPage*this.perPageNum+this.perPageNum,this.list.length));
     }
  }

}
