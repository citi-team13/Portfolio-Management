import { Component, OnInit } from '@angular/core';
import {DynamicDialogRef} from 'primeng/api';
import {DynamicDialogConfig} from 'primeng/api';

import {FundService} from '../../../service/fund.service';
@Component({
  selector: 'app-fund-chart',
  templateUrl: './fund-chart.component.html',
  styleUrls: ['./fund-chart.component.scss']
})
export class FundChartComponent implements OnInit {

  data:any;
  options:any;
  formatData:Array<object>;
  labelsArr:any[];
  valuesArr:any[];
  currentSecurity:any;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,private service:FundService) { 
             }

  ngOnInit() {

    this.setData();
    console.log("set over");
  }

    
  setData() {

    this.service.getData("id").subscribe(data=>{
      let labelsArr = [];
      let valueArr = [];
      this.currentSecurity = data['securityName'];
      console.log(this.currentSecurity)
      for(let item of data['data']) {
    
          labelsArr.push(item.date.substr(0,4));
          valueArr.push(item.price);
    
      }

      this.labelsArr = this.filterLabel(labelsArr);
      this.valuesArr = valueArr;
      this.setChart();
    });
}


setChart(){


  this.data = {
    labels: this.labelsArr,
       datasets: [
        {
            label: this.currentSecurity,
            data: this.valuesArr,
            fill:false,
            borderColor:'rgba(30,149,191,1)',
            pointBackgroundColor:'rgba(255,255,255,0)',
            pointRadius:1
        }
    ]

};

this.options = {
title: {
    display: true,
    text: 'My Title',

    fontSize: 16
},
legend: {
    position: 'bottom'
}
};

}

filterLabel(data:any){
  let tempArr = [data[0]];
  let tempStr = data[0];
  for(let i=1;i<data.length;i++){
    if(tempStr==data[i]){
      tempArr.push("");
    }
    else{
      tempStr = data[i];
      tempArr.push(tempStr);
    }
  }

  return tempArr;
}


}
