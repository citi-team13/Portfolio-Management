import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fund-list',
  templateUrl: './fund-list.component.html',
  styleUrls: ['./fund-list.component.scss']
})
export class FundListComponent implements OnInit {
  item = {
    'latestDate':'2019-01-01',
    'createDate':'2019-01-07',
    'price':'28.42',
    'changeRate':'0.01'
}

item2 = {
  'latestDate':'2019-01-07',
  'createDate':'2019-01-15',
  'price':'15.31',
  'changeRate':'-0.03'
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