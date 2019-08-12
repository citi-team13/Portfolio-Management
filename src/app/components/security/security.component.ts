import { Component, OnInit } from '@angular/core';
import {SelectItem} from 'primeng/api';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

interface security{
  name:string;
  sid:number;
}

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.scss']
})
export class SecurityComponent implements OnInit {
  noSpecial: RegExp = /^[^<>*!]+$/

  security1:SelectItem[];
  selectedItem:security;
  newSecurityName:string;
  newSecurityPrice:number;


  constructor() { 
    this.initSelectOption();
  }

  ngOnInit() {
  }

  initSelectOption(){
    this.security1=[
      {label:'Bond',value:{name:"Bond",sid:0}},
      {label:'Equity',value:{name:"Equity",sid:1}},
      {label:'Future',value:{name:"Future",sid:2}},
      {label:'FX',value:{name:"FX",sid:3}}
    ];

    this.selectedItem = this.security1[0].value;
  }

  addSecurity(){
    console.log(this.selectedItem);
    console.log(this.newSecurityName);
    console.log(this.newSecurityPrice);
  }
}
