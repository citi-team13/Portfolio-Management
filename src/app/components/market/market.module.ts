import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MarketRoutingModule } from './market-routing.module';
import { FundChartComponent } from './fund-chart/fund-chart.component';
import { UpdateComponent } from './update/update.component';


@NgModule({
  declarations: [FundChartComponent, UpdateComponent],
  imports: [
    CommonModule,
    MarketRoutingModule
  ]
})
export class MarketModule { }
