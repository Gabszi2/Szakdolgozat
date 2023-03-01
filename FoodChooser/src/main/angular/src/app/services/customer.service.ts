import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {lastValueFrom} from "rxjs";
import {FoodModel} from "../models/food-model";
import {RecommendationModel} from "../models/recommendation-model";
import {CityModel} from "../models/city-model";


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/'
  }

  async getQuestions(cuisine: string) {
    return lastValueFrom(this.http.get<string[]>(this.url + 'customer-questions/' + cuisine));
  }

  async getResult(answers: boolean[], town: string, cuisine: string) {
    let httpParams = new HttpParams();
    answers.forEach(answer => {
      httpParams = httpParams.append('answers', answer);
    })
    let options = {params: httpParams};
    return lastValueFrom(this.http.get<FoodModel>(this.url + 'result/' + town + '/' + cuisine, options));
  }
  async createRecommendation(recommendation:RecommendationModel){
    return lastValueFrom(this.http.post<RecommendationModel>(this.url+'customer-recommendation',recommendation));
  }
  async getCities(){
    return lastValueFrom(this.http.get<CityModel[]>(this.url+'cities'));
  }
}
