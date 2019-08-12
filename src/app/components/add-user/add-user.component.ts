import { Component, OnInit } from '@angular/core';
import {SelectItem} from 'primeng/api';
import {UserService2Service} from '../../service/user-service2.service';

interface security{
  name:string;
  sid:number;
}

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  noSpecial: RegExp = /^[^<>*!]+$/

  userTypes:SelectItem[];
  selectedType:security;
  newUserName:string;
  userPwd:string;
  userConfirmPwd:string;
  newUserPhone:number;
  userEmail:string;

  constructor(private service:UserService2Service) { 
    this.initSelectOption();
  }

  ngOnInit() {
  }

  initSelectOption(){
    this.userTypes=[
      {label:'Fund Manager',value:{name:"FM",sid:1}},
      {label:'Administrator',value:{name:"Admin",sid:0}}
  
    ];

    this.selectedType = this.userTypes[0].value;
  }

  addUser(){


    let postData = {'type':this.selectedType,
     'name':this.newUserName,
     'pwd':this.userPwd,
     'phone':this.newUserPhone,
     'email':this.userEmail
    }  
     


     this.service.addUser(postData);

  }
}

