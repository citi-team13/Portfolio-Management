import {HttpClient,HttpHeaders,HttpErrorResponse} from '@angular/common/http';



export class UserService2Service {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json;application/x-www-form-urlencodeed; charset=utf-8'})
  };


  constructor(private httpClient:HttpClient) { }

  addUser(data:object) {
    let reqUrl = "";
    console.log("service get:",data);
    //后台接收数据 需要 @RequestBody 标签
    return this.httpClient.post(reqUrl, data, this.httpOptions)
  }

  userLogin(data:object){
    let reqUrl = "../../assets/mockData/userLoginData.json";
    console.log("service get:",data);
    //return this.httpClient.post();
    return this.httpClient.get(reqUrl);
  }

  userExit(){
    let resUrl = "";
    console.log("exit!");
    //this.httpClient.get();
  }

  userLoginCheck(){
    let reqUrl = "../../assets/mockData/userLoginCheck.json";
    //return this.httpClient.post();
    return this.httpClient.get(reqUrl);
  }
 
}
