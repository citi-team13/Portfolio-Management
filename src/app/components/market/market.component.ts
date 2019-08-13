import { Component, OnInit,Injectable } from '@angular/core';
import {SecurityService} from "../../service/security.service";
import {DialogService} from 'primeng/api';
import {DynamicDialogRef} from 'primeng/api';
import {DynamicDialogConfig} from 'primeng/api';
import {FundChartComponent} from '../../components/market/fund-chart/fund-chart.component';
import {UpdateComponent} from '../../components/market/update/update.component';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.scss'],
  providers:[DialogService]  

})
export class MarketComponent implements OnInit {
  list: Array<any>;

  currentPage:number=0;
  perPageNum :number= 8;
  currentData:Array<any>;
  
  constructor(private service:SecurityService, public dialogService: DialogService) {
    
    this.setData();
   }

  ngOnInit() {
  }
  setData(){

    this.service.getMarket().subscribe(data=>{
      this.list=JSON.parse(JSON.stringify(data)); 
      this.currentData = this.list.slice(0,this.perPageNum)  
    });
    
  }

  toggle(index){
    this.currentData[index].isShow = !this.currentData[index].isShow;
    console.log('change!',this.currentData[index].content[0]);
  }
  delete(index){
    //this.messageservice.add({summary:'Success', detail:'Data Saved'});
    console.log('delete'+(index+1))
  }
  update(){
    const ref = this.dialogService.open(UpdateComponent,{
      header:'update',
      width:'80%'
    })
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
  pageChange(event){
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
