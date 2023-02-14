import { Injectable } from '@angular/core';
import {lastValueFrom} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {RecommendationModel} from "../models/recommendation-model";


@Injectable({
  providedIn: 'root'
})
export class AdminRecommendationService {
adminUrl:string;
  constructor(private http: HttpClient) {
    this.adminUrl='http://localhost:8080/admin/'
  }
  async getAllRecommendations(){
    return lastValueFrom(this.http.get<RecommendationModel[]>(this.adminUrl+'recommendations'))
  }
  async getAllApprovedRecommendations(){
    return lastValueFrom(this.http.get<RecommendationModel[]>(this.adminUrl+'approved-recommendations'))
  }
  async getRecommendation(id:number){
    return lastValueFrom(this.http.get<RecommendationModel>(this.adminUrl+'recommendation/'+id))
  }
  async deleteRecommendation(id:number){
    return lastValueFrom(this.http.delete(this.adminUrl+'recommendation/'+id))
  }
  async updateRecommendationApprove(id:number){
    return lastValueFrom(this.http.put(this.adminUrl+'recommendation/'+id,null))
  }
}
