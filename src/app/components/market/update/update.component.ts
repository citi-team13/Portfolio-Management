import { Component, OnInit } from '@angular/core';
import {SecurityService} from "../../../service/security.service";
import {DynamicDialogRef , DynamicDialogConfig , DialogService} from 'primeng/api';
import {SelectItem} from 'primeng/api';

interface security{
  name:string;
  sid:number;
}

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})


export class UpdateComponent implements OnInit {
  update:object;
  name:String;
  phone:number;
  email:string;
  utype:number;
  pwd:number;
  type:number = 1;
  userTypes:SelectItem[];
  selectedType:security;
  constructor(private service:SecurityService,
              public ref: DynamicDialogRef, 
              public config: DynamicDialogConfig) {
    this.getUpdateData();
   
  }

  ngOnInit() {
  }
  
  getUpdateData(){
    this.service.getManager().subscribe(data=>{
      this.name = data[0].name;
      this.email = data[0].email;
      this.utype =data[0].utype;
      this.phone = data[0].phone;
      this.pwd = data[0].pwd;
      console.log(this.utype);
      this.initSelectOption();
      
    })
  }
  initSelectOption(){
    this.userTypes=[
      {label:'Administrator',value:{name:'Admin',sid:0}},
      {label:'Fund Manager',value:{name:'FM',sid:1}}
    ];
    console.log('utype',this.utype);
    console.log(this.userTypes[this.utype]);
    this.selectedType = this.userTypes[this.utype].value;
    console.log(this.selectedType)
    //this.selctedType = this.userTypes[1].value;
    
  }
  confirm(){
    console.log('修改');
  }
  
}
