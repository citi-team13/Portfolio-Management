import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {

  item = {
    'requestDate':'2019-01-01',
    'Asker':'Tommy',
    'startDate':'2019-01-07',
    'endDate':'2019-01-15',
    'description':'For a vacation'
}

item2 = {
  'requestDate':'2017-08-01',
  'Asker':'Jason',
  'startDate':'2017-09-02',
  'endDate':'2017-01-07',
  'description':'For a vacation'
}

  data:object[] = [
    this.item,this.item2,this.item2,this.item,this.item,this.item2,this.item2,this.item,
    this.item2,this.item,this.item2,this.item2,this.item,this.item,this.item2,this.item2,
    this.item2,this.item2,this.item2,this.item,this.item,this.item,this.item,this.item2,
  ];
  currentPage = 0;
  perPageNum = 8
  currentData = this.data.slice(0,this.perPageNum);

  constructor() { }

  ngOnInit() {
  }

  acceptRequest(i:number){
    console.log("accept",i);
  }

  
  rejectRequest(i:number){
    console.log("reject",i);
  }

  paginate(event) {
    console.log("current page:",event.page);
    this.currentPage = event.page;
    if(this.currentPage*this.perPageNum>(this.data.length-1)){
      //重新请求数据
    }
    else{
      this.currentData = this.data.slice(this.currentPage*this.perPageNum,Math.min(this.currentPage*this.perPageNum+this.perPageNum,this.data.length-1));
    }

}
}
