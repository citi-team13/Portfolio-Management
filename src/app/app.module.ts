import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {InputTextModule,ButtonModule} from 'primeng/primeng';
import {MenubarModule} from 'primeng/menubar';
import { MenuItem } from 'primeng/api';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {KeyFilterModule} from 'primeng/keyfilter';
import {FormsModule, NgModel} from '@angular/forms';
import {MarketComponent} from './components/market/market.component';
import {AutoCompleteModule} from 'primeng/autocomplete';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { DefaultPageComponent } from './default-page/default-page.component';
import { CommonComponent } from './common/common.component';
import { ComponentsComponent } from './components/components.component';
import { NavigatorComponent } from './components/navigator/navigator.component';
import { LoginComponent } from './components/login/login.component';
import {DynamicDialogModule} from 'primeng/dynamicdialog';
import {TabViewModule} from 'primeng/tabview';
import {UserService } from './service/user.service';
import {HttpClientModule} from '@angular/common/http';
import {UpdatePriceComponent} from './components/update-price/update-price.component';
import {SecurityComponent} from './components/security/security.component';
import {TransforComponent} from './components/transfor/transfor.component';
import {FundComponent} from './components/fund/fund.component';
import {CreateFundComponent} from './components/create-fund/create-fund.component';
import {DropdownModule} from 'primeng/dropdown';

import {SecurityService} from './service/security.service';
import { AutoSecurityMatchComponent } from './common/auto-security-match/auto-security-match.component';
import {PortfolioService} from './service/portfolio.service';
import {PaginatorModule} from 'primeng/paginator';
import {RequestsComponent} from './components/transfor/requests/requests.component';
import {HistoryComponent} from './components/transfor/history/history.component';
import {AddUserComponent} from './components/add-user/add-user.component';
import {PasswordModule} from 'primeng/password';

import {UserService2Service} from './service/user-service2.service';
import {UpdateComponent} from "./components/market/update/update.component"
import {FundChartComponent} from "./components/market/fund-chart/fund-chart.component"


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    DefaultPageComponent,
    CommonComponent,
    ComponentsComponent,
    NavigatorComponent,
    LoginComponent,
    MarketComponent,
    UpdatePriceComponent,
    SecurityComponent,
    TransforComponent,
    FundComponent,
    CreateFundComponent,
    AutoSecurityMatchComponent,
    RequestsComponent,
    HistoryComponent,
<<<<<<< HEAD
    AddUserComponent,
    UpdateComponent,
    FundChartComponent
    
  ],
  entryComponents:[UpdateComponent,FundChartComponent],
=======
    AddUserComponent
  ],
>>>>>>> origin/dev
  imports: [
    BrowserModule,
    AppRoutingModule,
    InputTextModule,
    ButtonModule,
    MenubarModule,
    DynamicDialogModule,
    BrowserAnimationsModule,
    KeyFilterModule,
    FormsModule,
    TabViewModule,
    HttpClientModule,
    DropdownModule,
    AutoCompleteModule,
    PaginatorModule,
<<<<<<< HEAD
    PasswordModule,
=======
    PasswordModule
>>>>>>> origin/dev
  ],
  providers: [UserService,SecurityService,PortfolioService,UserService2Service],
  bootstrap: [AppComponent]
})
export class AppModule { }
