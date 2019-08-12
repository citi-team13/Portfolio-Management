import { Component, OnInit,Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';
@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.scss']
})
export class MarketComponent implements OnInit {

  list: object;
  //private messageservice:MessageService
     
  constructor() {
    //this.messageservice;
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
  }

  toggle(index){
    this.list[index].isShow = !this.list[index].isShow;
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
}
