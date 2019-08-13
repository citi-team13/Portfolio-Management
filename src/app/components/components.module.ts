import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ComponentsRoutingModule } from './components-routing.module';
import { LoginComponent } from './login/login.component';
import { MarketComponent } from './market/market.component';
import { UpdatePriceComponent } from '../components/update-price/update-price.component';
import { SecurityComponent } from './security/security.component';
import { TransforComponent } from './transfor/transfor.component';
import { FundComponent } from './fund/fund.component';
import { CreateFundComponent } from './create-fund/create-fund.component';
import { RequestsComponent } from './transfor/requests/requests.component';
import { HistoryComponent } from './transfor/history/history.component';
import { AddUserComponent } from './add-user/add-user.component';
import {FundListComponent} from './fund/fund-list/fund-list.component';



@NgModule({
  declarations: [LoginComponent, MarketComponent, UpdatePriceComponent, SecurityComponent, TransforComponent, FundComponent, CreateFundComponent, RequestsComponent, HistoryComponent, AddUserComponent,FundListComponent],
  imports: [
    CommonModule,
    ComponentsRoutingModule
  ]
})
export class ComponentsModule { }
