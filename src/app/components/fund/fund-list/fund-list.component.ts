import { Component, OnInit } from '@angular/core';

import {SecurityService} from "../../../service/security.service";
import {DialogService} from 'primeng/api';
import {DynamicDialogRef} from 'primeng/api';
import {DynamicDialogConfig} from 'primeng/api';
import {FundChartComponent} from '../../market/fund-chart/fund-chart.component';
import {UpdateComponent} from '../../market/update/update.component';
@Component({
  selector: 'app-fund-list',
  templateUrl: './fund-list.component.html',
  styleUrls: ['./fund-list.component.scss'],
  providers:[DialogService] 
})
export class FundListComponent implements OnInit {
  list: Array<any>;
  currentPage:number=0;
  perPageNum :number= 8;
  currentData:Array<any>;

  constructor(private service:SecurityService, public dialogService: DialogService) {
    this.setData();
   }


  ngOnInit() {
  }

  acceptRequest(i:number){
    console.log("accept",i);
  }

  
  rejectRequest(i:number){
    console.log("reject",i);
  }


  setData(){
    this.service.getFundList().subscribe(data=>{
      this.list=JSON.parse(JSON.stringify(data)); 
      this.currentData = this.list.slice(0,this.perPageNum)  
    });
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

  update(){
    const ref = this.dialogService.open(UpdateComponent,{
      header:'update',
      width:'80%'
    })
  }
  
  paginate(event) {
    console.log("current page:",event.page);
    this.currentPage = event.page;
    if(this.currentPage*this.perPageNum>(this.list.length-1)){
      //重新请求数据
    }
    else{
      this.currentData = this.list.slice(this.currentPage*this.perPageNum,Math.min(this.currentPage*this.perPageNum+this.perPageNum,this.list.length));
    }
  }

}