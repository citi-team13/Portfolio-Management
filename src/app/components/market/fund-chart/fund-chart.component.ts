import { Component, OnInit } from '@angular/core';
import {DynamicDialogRef} from 'primeng/api';
import {DynamicDialogConfig} from 'primeng/api';
@Component({
  selector: 'app-fund-chart',
  templateUrl: './fund-chart.component.html',
  styleUrls: ['./fund-chart.component.scss']
})
export class FundChartComponent implements OnInit {

  constructor(public ref: DynamicDialogRef, 
              public config: DynamicDialogConfig, 
             ) { }

  ngOnInit() {
  }

}
