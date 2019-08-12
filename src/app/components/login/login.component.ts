import { Component, OnInit } from '@angular/core';
import {NgModule} from '@angular/core';
import {DynamicDialogRef} from 'primeng/api';
import {DynamicDialogConfig} from 'primeng/api';
import {UserService2Service} from '../../service/user-service2.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  noSpecial: RegExp = /^[^<>*!]+$/
  userPhone:string;
  userPwd:string;
  loginMsg:any = {'login':false};

  login(){


    this.service.userLogin({'phone':this.userPhone,'pwd':this.userPwd}).subscribe((data:any)=>{
      this.loginMsg = data;
      this.ngOnInit();
      this.ref.close(this.loginMsg);
    });

  }
  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig, private service:UserService2Service) { 

  }

  ngOnInit() {
  }

}
