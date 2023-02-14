import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {lastValueFrom} from "rxjs";
import {FoodModel} from "../models/food-model";
import {RecommendationModel} from "../models/recommendation-model";


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/'
  }

  async getQuestions(kitchen: string) {
    return lastValueFrom(this.http.get<string[]>(this.url + 'customer-questions/' + kitchen));
  }

  async getResult(answers: boolean[], town: string, kitchen: string) {
    let httpParams = new HttpParams();
    answers.forEach(answer => {
      httpParams = httpParams.append('answers', answer);
    })
    let options = {params: httpParams};
    return lastValueFrom(this.http.get<FoodModel>(this.url + 'result/' + town + '/' + kitchen, options));
  }
  async createRecommendation(recommendation:RecommendationModel){
    return lastValueFrom(this.http.post<RecommendationModel>(this.url+'customer-recommendation',recommendation));
  }
}
