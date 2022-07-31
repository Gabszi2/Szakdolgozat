import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {lastValueFrom} from "rxjs";
import {FoodModel} from "../models/food-model";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  adminUrl: string;
  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/' }

  async getQuestions(kitchen:string){
    return lastValueFrom(this.http.get<string[]>(this.adminUrl + 'customer-questions/' + kitchen));
  }
  async getResult(answers:boolean[],town:string,kitchen:string){
    let httpParams = new HttpParams();
    answers.forEach(answer=>{
      httpParams=httpParams.append('answers',answer);
    })
    let options = { params: httpParams };
    return lastValueFrom(this.http.get<FoodModel>(this.adminUrl + 'result/' + town + '/' + kitchen, options));
  }
}
