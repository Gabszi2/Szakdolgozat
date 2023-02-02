import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FoodModel} from "../models/food-model";
import {lastValueFrom} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminFoodService {

  adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin'
  }

  async getAllFood(town: string, kitchen: string) {
    return lastValueFrom(this.http.get<FoodModel[]>(this.adminUrl + '/foods/' + town + '/' + kitchen));
  }

  async getFood(town: string, kitchen: string, foodName: string) {
    return lastValueFrom(this.http.get<FoodModel>(this.adminUrl + '/food/' + town + '/' + kitchen + '/' + foodName))
  }

  async deleteFood(town: string, kitchen: string, food: FoodModel) {
    return lastValueFrom(this.http.delete(this.adminUrl + '/food/' + town + '/' + kitchen, {body: food}));
  }

  async addFood(town: string, kitchen: string, food: FoodModel) {

    return lastValueFrom(this.http.post<FoodModel>(this.adminUrl + '/food/' + town + '/' + kitchen, food));
  }

  async updateFood(town: string, kitchen: string, food: FoodModel) {
    return lastValueFrom(this.http.put(this.adminUrl + '/food/' + town + '/' + kitchen, food));
  }
}
