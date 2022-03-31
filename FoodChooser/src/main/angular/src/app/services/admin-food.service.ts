import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FoodModel} from "../models/food-model";

@Injectable({
  providedIn: 'root'
})
export class AdminFoodService {

  adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin'
  }

  getAllFood(town: string, kitchen: string) {
    return this.http.get<FoodModel[]>(this.adminUrl + '/foods/' + town + '/' + kitchen);
  }

  deleteFood(town: string, kitchen: string, food: FoodModel) {
    this.http.request('delete', this.adminUrl + '/food/' + town + '/' + kitchen, {body: food});
  }

  addFood(town: string, kitchen: string, food: FoodModel) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'

      })
    };
    return this.http.post(this.adminUrl + '/food/' + town + '/' + kitchen, food, httpOptions);
  }

  updateFood(town: string, kitchen: string, food: FoodModel) {
    return this.http.post<FoodModel>(this.adminUrl + '/food/' + town + '/' + kitchen, food);
  }
}
