import { Component, OnInit,Injectable } from '@angular/core';
import {SecurityService} from "../../service/security.service";
import {DynamicDialogRef , DynamicDialogConfig , DialogService} from 'primeng/api';
import {FundChartComponent} from '../../components/market/fund-chart/fund-chart.component';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.scss'],
  providers:[DialogService]  

})
export class MarketComponent implements OnInit {
  url:String;
  list: object;
  list_2: object;
  
  //private messageservice:MessageService
     
  constructor(private service:SecurityService, public dialogService: DialogService) {
    
    this.setData();
   }

  ngOnInit() {
  }
  setData(){
    
    this.list = [
      { name:'mike',
        details:'blabla',
        content:'……………………………………………………',
        isShow:false
      },{
        name:'lily',
        details:'blabla',
        content:'2222222',
        isShow:false
      },{
        name:'lily',
        details:'blabla',
        content:'3333333',
        isShow:false
      },{
        name:'lily',
        details:'blabla',
        content:'444444444',
        isShow:false
      }]
      
    this.service.getMarket().subscribe(data=>{
      this.list_2=data;
      console.log(this.list_2);
    });
    
  }

  toggle(index){
    this.list_2[index].isShow = !this.list_2[index].isShow;
    console.log('change!',this.list_2[index].content[0]);
  }
  delete(index){
    //this.messageservice.add({summary:'Success', detail:'Data Saved'});
    console.log('delete'+(index+1))
  }
  update(index){
    console.log('update'+(index+1))
  }
  submit(){
    console.log('submit')
  }
  chartShow(){    
    const ref = this.dialogService.open(FundChartComponent,{
      header:'chart',
      width:'60%'
    });

  }
}
