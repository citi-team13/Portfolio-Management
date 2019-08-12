import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MarketRoutingModule } from './market-routing.module';
import { FundChartComponent } from './fund-chart/fund-chart.component';


@NgModule({
  declarations: [FundChartComponent],
  imports: [
    CommonModule,
    MarketRoutingModule
  ]
})
export class MarketModule { }
