import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MenuItem } from 'primeng/api';
import {Router} from '@angular/router';
import {DynamicDialogRef , DynamicDialogConfig , DialogService} from 'primeng/api';
import {LoginComponent} from '../components/login/login.component';
import {UserService2Service} from '../service/user-service2.service';
import {SecurityMarketComponent} from '../components/security-market/security-market.component'

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
  providers:[DialogService],
  encapsulation:ViewEncapsulation.None
})
export class HomePageComponent implements OnInit {

  items: MenuItem[];
  loginItems:MenuItem[];
  login:boolean;
  user:object;
  loginSetting = [];
  constructor(private router:Router , public dialogService: DialogService,private service:UserService2Service) {

    this.loginSetting =[ [
      {
        label:'Fund Management',
        command: ()=>this.toFundManagement()
 
      },

      {
        label:'Update Price',
        command:()=>this.toUpdatePrice()
 
      },

      {
        label:'Security Type',
        command:()=>this.toSecurity()

      },

      {
        label:'Transfor',
        command:()=>this.toTransfor()
      }
    ],


    [
      {
        label:'Fund List',
        command: ()=>this.toFund()
 
      },

      {
        label:'New Fund',
        command:()=>this.toCreateFund()
 
      },
      {
        label:'Security Market',
        command:()=>this.toSecMarket()
      }
    ]
  ]
}

  Login(){

    //this.router.navigate(['login']);
    const ref = this.dialogService.open(LoginComponent,{
      header:'Login',
      width:'20%'
    });

    ref.onClose.subscribe((data:any)=>{
      if(data != null && data.hasOwnProperty('login')){
      console.log(data);
      this.login = data.login;
      if(this.login){
      this.user = data;
      this.items = this.loginSetting[data.utype];
      this.router.navigate(['home/FundManagement']);
      }
      }
    })
    this.router.navigate(['home']);


  }

  Exit(){
/*
         connect to back office 

         codes here
*/
    this.user = null;
    this.login = false;
    this.items = [];
    this.service.userExit();
    this.router.navigate(['home']);
    this.Login();

  }

  ngOnInit() {
    // initial items of navigator

    //check if login , otherwise exec login
    this.service.userLoginCheck().subscribe((data:any)=>{
      this.login = data.login;
      if(this.login){
      this.user = data;
      this.items = this.loginSetting[data.utype];
      if(data.utype==0){
      this.router.navigate(['home/FundManagement']);
      }
      else if(data.utype==1){
        this.router.navigate(['home/Fund']);
        }
      }
      else{
        this.Login();
      }
      });
    

// initial items of login or sign etc. options
    this.loginItems = [
      {
        label:'Login'
      },

      {
        label:'Sign'
      }
    ];

  // initial login status
  this.login = false;



  }

  toFundManagement(){
    this.router.navigate(['home/FundManagement']);
  }

  toUpdatePrice(){
    this.router.navigate(['home/UpdatePrice']);
  }

  toSecurity(){
    this.router.navigate(['home/Security']);
  }

  toTransfor(){
    this.router.navigate(['home/Transfor']);
  }

  toFund(){
    this.router.navigate(['home/Fund']);
  }

  toCreateFund(){
    this.router.navigate(['home/CreateFund']);
  }

  toSecMarket(){
    this.router.navigate(['home/SecurityMarket'])
  }


}
